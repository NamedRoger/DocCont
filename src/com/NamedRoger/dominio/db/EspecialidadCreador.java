package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.Especialidad;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadCreador {
    public static List<Especialidad> creador() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"especialidad"+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken<ArrayList<Especialidad>>(){}.getType();
        ArrayList<Especialidad> especialidad = new ArrayList<Especialidad>();
        Gson gson = new Gson();
        especialidad =  gson.fromJson(registrosJson,collectionType);
        return especialidad;
    }
}
