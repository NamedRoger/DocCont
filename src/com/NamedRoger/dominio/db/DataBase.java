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
    private Entidad<Paciente> paciente = new Entidad<>("pacientes");
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
        UsuarioCreador usuarioCreador = new UsuarioCreador(this.usuario.getTabla());
        this.usuario.setRegistros(usuarioCreador.cargarDatos());

        CitaCreador citaCreador = new CitaCreador(this.cita.getTabla());
        this.cita.setRegistros(citaCreador.cargarDatos());

        DoctorCreador doctorCreador = new DoctorCreador(this.doctor.getTabla());
        this.doctor.setRegistros(doctorCreador.cargarDatos());

        PacienteCreador pacienteCreador = new PacienteCreador(this.paciente.getTabla());
        this.paciente.setRegistros(pacienteCreador.cargarDatos());
    }


}
