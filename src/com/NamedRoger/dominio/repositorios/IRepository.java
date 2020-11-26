package src.com.NamedRoger.dominio.repositorios;

import src.com.NamedRoger.dominio.models.Entidad;

import java.io.IOException;
import java.util.List;

public interface IRepository<TEntidad>  {
    public List<TEntidad> obetenerTodos();
    public void insertar(TEntidad entidad) throws IOException;
    public void actualizar(TEntidad entidad, TEntidad entidadActualizada) throws IOException;
    public void borrar(TEntidad entidad);
}
