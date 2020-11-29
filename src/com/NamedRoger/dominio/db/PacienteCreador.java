package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.Paciente;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PacienteCreador {
    public static List<Paciente> creador() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"pacientes"+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken<ArrayList<Paciente>>(){}.getType();
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        Gson gson = new Gson();
        pacientes =  gson.fromJson(registrosJson,collectionType);
        return pacientes;
    }
}
