package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.dominio.models.Usuario;

import java.io.IOException;
import java.util.List;

public class ServicioUsuario {
    DataBase db;
    public  ServicioUsuario(DataBase db){
        this.db = db;
    }

    public Usuario obtener(int id){
        return this.db.getUsuario().obtener(id);
    }

    public List<Usuario> obtenerTodos() {
        return this.db.getUsuario().obtenerTodos();
    }

    public void insertarUsuario(String userName, String password) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setUserName(userName);
        usuario.setPassword(password);
        this.db.getUsuario().insertar(usuario);
    }

    public void editarUsuario(int id,Usuario usuario) throws IOException {
        var usuarioActual = this.db.getUsuario().obtener(id);
        this.db.getUsuario().editar(usuarioActual,usuario);
    }

    public void editarPassword(int id, String password) throws IOException {
        var usuarioActual = this.db.getUsuario().obtener(id);
        var usuarioEditado = this.db.getUsuario().obtener(id);
        usuarioEditado.setPassword(password);
        this.db.getUsuario().editar(usuarioActual,usuarioEditado);
    }

    public boolean borrarUsuario(int id) throws IOException {
        var usuario = this.db.getUsuario().obtener(id);
        var exito = this.db.getUsuario().borrar(usuario);
        return exito;
    }
}
