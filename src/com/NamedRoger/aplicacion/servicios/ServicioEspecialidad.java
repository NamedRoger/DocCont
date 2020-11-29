package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.Especialidad;

import java.io.IOException;
import java.util.List;

public class ServicioEspecialidad {
    DataBase db;
    public  ServicioEspecialidad(DataBase db){
        this.db = db;
    }

    public Especialidad obtener(int id){
        return this.db.getEspecialidad().obtener(id);
    }

    public List<Especialidad> obtenerTodos() {
        return this.db.getEspecialidad().obtenerTodos();
    }

    public void insertarEstatusCita(String nombre) throws IOException {
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(nombre);
        this.db.getEspecialidad().insertar(Especialidad);
    }

    public void editarEspecialidad(int id,Especialidad especialidad) throws IOException {
        var especialidadActual = this.db.getEspecialidad().obtener(id);
        this.db.getEstatusCita().editar(especialidadActual,especialidad);
    }

    public boolean borrarEspecialidad(int id) throws IOException {
        var especialidad = this.db.getEspecialidad().obtener(id);
        var exito = this.db.getEspecialidad().borrar(Especialidad);
        return exito;
    }
}
