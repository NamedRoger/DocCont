package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

public class RegistroDataBase {
    private static RegistroDataBase registroDataBase;
    private HashMap<String,Double> registroTablas = new HashMap<>();

    private RegistroDataBase() throws IOException {
        crearTabla();
        cargarRegistros();
    }

    public static RegistroDataBase getInstance() throws IOException {
        if (registroDataBase == null) {
            registroDataBase = new RegistroDataBase();
        }

        return registroDataBase;
    }

    public void editarRegistro(String tabla, Integer ultimoId) throws IOException {
        registroTablas.put(tabla,ultimoId.doubleValue());
        actualizarTabla();
    }

    public int obtenerRegistro(String tabla){
        var registro = registroTablas.get(tabla).intValue();
        return registro;
    }

    private void actualizarTabla() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"registros"+".json");
        Files.write(path, (new Gson().toJson(this.registroTablas)).getBytes(), StandardOpenOption.CREATE);
    }

    private  void crearTabla() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"registros"+".json");

        if(!Files.exists(path)){
            Gson g = new Gson();
            double initId = (int) 0;
            registroTablas.put("citas",initId);
            registroTablas.put("usuarios",initId);
            registroTablas.put("pacientes",initId);
            registroTablas.put("doctores",initId);
            registroTablas.put("estatus_citas",initId);
            registroTablas.put("especialidades",initId);
            var registroJson = g.toJson(this.registroTablas);
            Files.write(path,registroJson.getBytes());
        }
    }

    private void cargarRegistros() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+"registros"+".json");
        String registrosJson = new String(Files.readAllBytes(path));

        if(!registrosJson.isEmpty()){
            Gson gson = new Gson();
            this.registroTablas = gson.fromJson(registrosJson, registroTablas.getClass());
        }
    }
}
