package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.*;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        cargarDatos();
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

    public void cargarDatos() throws IOException {
        var estatusCitas = EstatusCitaCreador.creador();
        estatusCita.setRegistros(estatusCitas);
        var citas = CitaCreador.creador();
        cita.setRegistros(citas);
        var usuarios = UsuarioCreador.creador();
        usuario.setRegistros(usuarios);
        var pacientes = PacienteCreador.creador();
        paciente.setRegistros(pacientes);
        var doctores = DoctorCreador.creador();
        doctor.setRegistros(doctores);
        var especialidades = EspecialidadCreador.creador();
        especialidad.setRegistros(especialidades);
    }


}
