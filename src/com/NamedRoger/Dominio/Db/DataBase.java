package src.com.NamedRoger.Dominio.Db;

import src.com.NamedRoger.Dominio.Models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static DataBase dataBase;

    private Entity<Cita> citas = new Entity<>("citas");
    private Entity<Doctor> doctores = new Entity<>("doctores");
    private Entity<Especialidad> especialidades = new Entity<>("especialidades");
    private Entity<Paciente> pacientes = new Entity<>("pacientes");
    private Entity<EstatusCita> estatusCitas = new Entity<>("estaus_citas");
    private Entity<Usuario> usuarios = new Entity<>("usuarios");

    private DataBase() throws IOException {

    }

    public Entity<Cita> getCitas() {
        return citas;
    }

    public Entity<Doctor> getDoctores() {
        return doctores;
    }

    public Entity<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public Entity<EstatusCita> getEstatusCitas() {
        return estatusCitas;
    }

    public Entity<Paciente> getPacientes() {
        return pacientes;
    }

    public Entity<Usuario> getUsuarios() {
        return usuarios;
    }

    public static DataBase getInstance() throws IOException {
        if (dataBase == null) {
            dataBase = new DataBase();
        }

        return dataBase;
    }
}
