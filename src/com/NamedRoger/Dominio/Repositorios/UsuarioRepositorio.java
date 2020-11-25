package src.com.NamedRoger.Dominio.Repositorios;

import src.com.NamedRoger.Dominio.Models.Usuario;

import java.util.List;

public class UsuarioRepositorio implements IRepository<Usuario> {
    @Override
    public List<Usuario> obetenerTodos() {
        return null;
    }

    @Override
    public void insertar() {

    }

    @Override
    public void actualizar() {

    }

    @Override
    public boolean borrar() {
        return false;
    }
}
