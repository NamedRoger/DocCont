package src.com.NamedRoger.dominio.repositorios;

import src.com.NamedRoger.dominio.models.Entidad;

import java.util.List;

public interface IRepository<TEntidad>  {
    public List<TEntidad> obetenerTodos();
    public void insertar(TEntidad entidad);
    public void actualizar(TEntidad entidad, TEntidad entidadActualizada);
    public void borrar(int id);
}
