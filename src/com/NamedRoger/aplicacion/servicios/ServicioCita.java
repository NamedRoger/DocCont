package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.Paciente;

import java.io.IOException;
import java.util.List;

public class ServicioCita {
    private DataBase db;

    public ServicioCita(DataBase db){
        this.db = db;
    }

    public Cita obtenerCita(int id){
        return this.db.getCita().obtener(id);
    }

    public List<Cita> obtenerCitas(){
        return  this.db.getCita().obtenerTodos();
    }

    public void insertarCita(Cita cita) throws IOException {
        this.db.getCita().insertar(cita);
    }
}
