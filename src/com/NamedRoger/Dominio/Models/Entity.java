package src.com.NamedRoger.Dominio.Models;

import src.com.NamedRoger.Infraestructura.Constante;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Entity<TModel> {
    private String tabla;

    public Entity(String tabla) throws IOException {
        this.tabla = tabla;
        this.crearTabla();
    }

    public List<TModel> obtener(){

        return null;
    }

    public void insertar(TModel tModel){

    }

    public void editar(TModel model){

    }

    public void borrar(int id){

    }

    private void crearTabla() throws IOException {
        var path = Paths.get(Constante.getPath()+tabla+".json");
        String dataInit = "{ \n\n}";
        if(!Files.exists(path)){
            Files.write(path,dataInit.getBytes());
        }
    }
}
