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

    public void insertarPaciente(Paciente paciente) throws IOException {
        this.db.getPaciente().insertar(paciente);
    }

    public void editarPaciente(Paciente pacienteActual,Paciente pacienteEditado) throws IOException {
        this.db.getPaciente().editar(pacienteActual,pacienteEditado);
    }

    public boolean borrarPaciente(Paciente paciente) throws IOException {
        var exito = this.db.getPaciente().borrar(paciente);
        return exito;
    }
}
