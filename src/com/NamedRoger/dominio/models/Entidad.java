package src.com.NamedRoger.dominio.models;

import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class Entidad<TModelo extends Modelo> {
    private String tabla;

    public Entidad(String tabla) throws IOException {
        this.tabla = tabla;
        this.crearTabla();
    }

    public List<TModelo> obtener(){

        return null;
    }

    public void insertar(TModelo model){
        List<TModelo> entidades = this.obtener();
        entidades.add(model);
        this.guardar();

    }

    public void editar(TModelo model,TModelo entidadActualizada){
        List<TModelo> entidades = this.obtener();
        int idx = entidades.indexOf(model);
        TModelo entididad = entidades.get(idx);

        entidades.set(idx,entidadActualizada);
        this.guardar();
    }

    public void borrar(int id){

    }

    private void crearTabla() throws IOException {
        Path path = Paths.get(Constante.getPath()+tabla+".json");
        String dataInit = "{ \n\n}";
        if(!Files.exists(path)){
            Files.write(path,dataInit.getBytes());
        }
    }

    private void guardar(){

    }

}
