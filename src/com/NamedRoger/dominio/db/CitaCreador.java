package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CitaCreador {
    public static List<Cita> creador() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"citas"+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken<ArrayList<EstatusCita>>(){}.getType();
        ArrayList<Cita> citas = new ArrayList<Cita>();
        Gson gson = new Gson();
        citas =  gson.fromJson(registrosJson,collectionType);
        return citas;
    }
}
