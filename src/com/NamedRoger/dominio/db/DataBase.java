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
        Gson gson = new Gson();
        Path path = Paths.get(Constante.getPath()+"/"+"estatus_citas"+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken< ArrayList<EstatusCita>>(){}.getType();
        ArrayList<EstatusCita> estatusCitas = new ArrayList<EstatusCita>();
        estatusCitas =  gson.fromJson(registrosJson,collectionType);
        for(var p : estatusCitas){
            System.out.println(p.getNombre());
        }
    }

}
