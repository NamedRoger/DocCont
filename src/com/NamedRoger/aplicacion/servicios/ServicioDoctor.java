package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.Doctor;

import javax.print.Doc;
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

    public Doctor obtenerPorCedula(String cedula){
        var doctor = this.obtenerTodos().stream()
                .filter(d -> d.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
        return doctor;
    }

    public List<Doctor> obtenerTodos() {
        return this.db.getDoctor().obtenerTodos();
    }

    public void insertarDoctor(Doctor doctor) throws IOException {
        this.db.getDoctor().insertar(doctor);
    }

    public void editarDoctor(Doctor doctorActual,Doctor doctorEditado) throws IOException {
        this.db.getDoctor().editar(doctorActual,doctorEditado);
    }

    public boolean borrarDoctor(Doctor doctor) throws IOException {
        var exito = this.db.getDoctor().borrar(doctor);
        return exito;
    }
}
