package src.com.NamedRoger.dominio.models;

import com.google.gson.Gson;
import src.com.NamedRoger.infraestructura.Constante;
import src.com.NamedRoger.infraestructura.interfaces.Modelo;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Entidad<TModelo extends Modelo> {
    private String tabla;
    List<TModelo> registros;

    public Entidad(String tabla) throws IOException {
        this.tabla = tabla;
        this.crearTabla();
        this.registros = new ArrayList<>();
        cargarDatos();
    }


    public List<TModelo> obtener(){
        return this.registros;
    }

    public void insertar(TModelo model) throws IOException {
        this.registros.add(model);
        this.guardar();

    }

    public void editar(TModelo model,TModelo entidadActualizada) throws IOException {
        int idx = this.registros.indexOf(model);
        TModelo entididad = this.registros.get(idx);

        this.registros.set(idx,entidadActualizada);
        this.guardar();
    }

    public void borrar(TModelo modelo){
        this.registros.remove(modelo);
    }

    private void crearTabla() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+tabla+".json");
        String dataInit = "";
        if(!Files.exists(path)){
            Files.write(path,dataInit.getBytes());
        }
    }

    private void guardar() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+tabla+".json");
        Files.write(path, (new Gson().toJson(this.registros)).getBytes(), StandardOpenOption.CREATE);
    }

    private void cargarDatos() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+tabla+".json");
        String registrosJson = new String(Files.readAllBytes(path));

        if(!registrosJson.isEmpty()){
            Gson gson = new Gson();
           this.registros = gson.fromJson(registrosJson, (Type) Object.class);
        }

    }

}
