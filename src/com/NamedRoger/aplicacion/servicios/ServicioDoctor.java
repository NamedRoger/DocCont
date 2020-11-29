package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.EstatusCita;

import java.io.IOException;
import java.util.List;

public class ServicioDoctor {
    DataBase db;
    public  ServicioDoctor(DataBase db){
        this.db = db;
    }

    public Doctor obtener(int id){
        return this.db.getDoctor().obtener(id);
    }

    public List<EstatusCita> obtenerTodos() {
        return this.db.getEstatusCita().obtenerTodos();
    }

    public void insertarDoctor(String nombre) throws IOException {
        Doctor doctor = new Doctor();
        doctor.setNombre(nombre);
        this.db.getEstatusCita().insertar(doctor);
    }

    public void editarDoctor(int id,Doctor doctor) throws IOException {
        var doctorActual = this.db.getEstatusCita().obtener(id);
        this.db.getEstatusCita().editar(doctorActual,doctor);
    }

    public boolean borrarDoctor(int id) throws IOException {
        var doctor = this.db.getDoctor().obtener(id);
        var exito = this.db.getDoctor().borrar(doctor);
        return exito;
    }
}
