package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DoctorCreador {
    public static List<Doctor> creador() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"doctores"+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken<ArrayList<Doctor>>(){}.getType();
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        Gson gson = new Gson();
        doctores =  gson.fromJson(registrosJson,collectionType);
        return doctores;
    }
}
