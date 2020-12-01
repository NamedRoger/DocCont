package src.com.NamedRoger.dominio.db;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.Usuario;
import src.com.NamedRoger.infraestructura.Constante;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UsuarioCreador extends Creador {

    public UsuarioCreador(String tabla) throws IOException {
        super(tabla);
        crearTabla();
    }

    public List<Usuario> cargarDatos() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+this.tabla+".json");
        String registrosJson = new String(Files.readAllBytes(path));
        Type collectionType = new TypeToken<ArrayList<Usuario>>(){}.getType();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Gson gson = new Gson();
        usuarios =  gson.fromJson(registrosJson,collectionType) != null
                ? gson.fromJson(registrosJson,collectionType) : new ArrayList<>();
        return usuarios;
    }

    public void crearTabla() throws IOException {
        Path path = Paths.get(Constante.getPath()+"/"+this.tabla+".json");


        String dataInit = "";
        if(!Files.exists(path)){
            Gson gson = new Gson();
            List<Usuario> usuarios = new ArrayList<>();
            Usuario admin = new Usuario();
            admin.setUserName("admin");
            admin.setPassword("admin");
            usuarios.add(admin);
            var usuarioJson = gson.toJson(usuarios);
            Files.write(path,usuarioJson.getBytes());
        }
    }
}
