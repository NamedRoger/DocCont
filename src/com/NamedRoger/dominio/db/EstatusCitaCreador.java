package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.infraestructura.Constante;
import src.com.NamedRoger.infraestructura.interfaces.EntidadCreador;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EstatusCitaCreador {

    public static List<EstatusCita> creador() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"estatus_citas"+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken<ArrayList<EstatusCita>>(){}.getType();
        ArrayList<EstatusCita> estatusCitas = new ArrayList<EstatusCita>();
        Gson gson = new Gson();
        estatusCitas =  gson.fromJson(registrosJson,collectionType) != null
                ? gson.fromJson(registrosJson,collectionType) : new ArrayList<>();
        return estatusCitas;
    }
}
