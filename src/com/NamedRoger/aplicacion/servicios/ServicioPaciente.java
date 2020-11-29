package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.Paciente;

import java.io.IOException;
import java.util.List;

public class ServicioPaciente {

    DataBase db;
    public  ServicioPaciente(DataBase db){
        this.db = db;
    }

    public Paciente obtener(int id){
        return this.db.getPaciente().obtener(id);
    }

    public List<Paciente> obtenerTodos() {
        return this.db.getPaciente().obtenerTodos();
    }

    public void insertarPaciente(String nombre) throws IOException {
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        this.db.getPaciente().insertar(paciente);
    }

    public void editarPaciente(int id,Paciente paciente) throws IOException {
        var pacienteActual= this.db.getPaciente().obtener(id);
        this.db.getPaciente().editar(pacienteActual,paciente);
    }

    public boolean borrarPaciente(int id) throws IOException {
        var paciente = this.db.getPaciente().obtener(id);
        var exito = this.db.getPaciente().borrar(paciente);
        return exito;
    }
}
