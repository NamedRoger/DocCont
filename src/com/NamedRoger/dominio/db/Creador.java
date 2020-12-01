package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.infraestructura.Constante;
import src.com.NamedRoger.infraestructura.interfaces.ICreador;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class Creador implements ICreador {
    protected String tabla;

    public Creador(String tabla) throws IOException {
        this.tabla = tabla;
        this.crearTabla();
    }

    public void crearTabla() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+tabla+".json");
        String dataInit = "";
        if(!Files.exists(path)){
            Files.write(path,dataInit.getBytes());
        }
    }
}
