package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.Especialidad;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadCreador extends  Creador{

    public EspecialidadCreador(String tabla) throws IOException {
        super(tabla);
    }

    public List<Especialidad> cargarDatos() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+this.tabla+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken<ArrayList<Especialidad>>(){}.getType();
        ArrayList<Especialidad> citas = new ArrayList<Especialidad>();
        Gson gson = new Gson();
        citas =  gson.fromJson(registrosJson,collectionType) != null
                ? gson.fromJson(registrosJson,collectionType) : new ArrayList<>();
        return citas;
    }

    public void crearTabla() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+this.tabla+".json");
        String dataInit = "";
        if(!Files.exists(path)){
            Files.write(path,dataInit.getBytes());
        }
    }
}
