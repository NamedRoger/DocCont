package src.com.NamedRoger.dominio.db;

import src.com.NamedRoger.dominio.models.*;

import java.io.IOException;

public class DataBase {
    private static DataBase dataBase;
    private RegistroDataBase registroDataBase;

    private Entidad<Cita> cita = new Entidad<>("citas");
    private Entidad<Doctor> doctor = new Entidad<>("doctores");
    private Entidad<Especialidad> especialidad = new Entidad<>("especialidades");
    private Entidad<Paciente> paciente = new Entidad<>("pacientes");
    private Entidad<EstatusCita> estatusCita = new Entidad<>("estatus_citas");
    private Entidad<Usuario> usuario = new Entidad<>("usuarios");

    private DataBase() throws IOException {
    }

    public Entidad<Cita> getCita() {
        return cita;
    }

    public Entidad<Doctor> getDoctor() {
        return doctor;
    }

    public Entidad<Especialidad> getEspecialidad() {
        return especialidad;
    }

    public Entidad<EstatusCita> getEstatusCita() {
        return estatusCita;
    }

    public Entidad<Paciente> getPaciente() {
        return paciente;
    }

    public Entidad<Usuario> getUsuario() {
        return usuario;
    }

    public static DataBase getInstance() throws IOException {
        if (dataBase == null) {
            dataBase = new DataBase();
        }

        return dataBase;
    }

}
