package src.com.NamedRoger.infraestructura.interfaces;

import java.util.List;

public interface IServicio<TEntidad> {
    public List<TEntidad> obtenerTodos();
    public void insertar(TEntidad entidad);
    public void editar(TEntidad entidad);
    public void borrar(TEntidad entidad);
}
