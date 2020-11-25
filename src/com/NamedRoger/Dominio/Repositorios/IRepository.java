package src.com.NamedRoger.Dominio.Repositorios;

import java.util.List;

public interface IRepository<TEntity>  {
    List<TEntity> obetenerTodos();
    void insertar();
    void actualizar();
    boolean borrar();
}
