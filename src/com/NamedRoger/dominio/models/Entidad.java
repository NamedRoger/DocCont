package src.com.NamedRoger.dominio.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.db.RegistroDataBase;
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

public class Entidad<TModelo extends BaseModelo> {
    private String tabla;
    private List<TModelo> registros;

    public Entidad(String tabla) throws IOException {
        this.tabla = tabla;
        this.crearTabla();
        this.registros = new ArrayList<TModelo>();
    }

    public List<TModelo> obtenerTodos(){
        return this.registros;
    }

    public void insertar(TModelo model) throws IOException {
        RegistroDataBase registroDataBase = RegistroDataBase.getInstance();
        int ultimoId = (int) (registroDataBase.obtenerRegistro(this.tabla) +1);
        model.setId(ultimoId);
        this.registros.add(model);
        this.guardar();
        registroDataBase.editarRegistro(this.tabla,ultimoId);
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

    public void setRegistros(List<TModelo> registros) {
        this.registros = registros;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
}
