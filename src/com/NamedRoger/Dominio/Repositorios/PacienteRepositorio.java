package src.com.NamedRoger.Dominio.Repositorios;

import src.com.NamedRoger.Dominio.Models.Paciente;

import java.util.List;

public class PacienteRepositorio implements IRepository<Paciente>{

    @Override
    public List<Paciente> obetenerTodos() {
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
