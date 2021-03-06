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

        this.registros = new ArrayList<TModelo>();
    }

    public TModelo obtener(int id){
        return this.registros.stream().filter(modelo -> modelo.getId() == id).findFirst().orElseThrow();
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

    public void editar(TModelo modelo, TModelo modeloEditado) throws IOException {
        var modeloActual = this.registros.indexOf(modelo);
        this.registros.set(modeloActual,modeloEditado);
        this.guardar();
    }

    public boolean borrar(TModelo modelo) throws IOException {
        var modeloBorrado =  this.registros.remove(this.registros.indexOf(modelo));
        boolean exito = false;
        if (modeloBorrado != null) {
            exito = true;
            this.guardar();
        }
        return exito;
    }

    private void guardar() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+tabla+".json");
        Files.write(path, (new Gson().toJson(this.registros)).getBytes());
    }

    public void setRegistros(List<TModelo> registros) {
        this.registros = registros;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
}
