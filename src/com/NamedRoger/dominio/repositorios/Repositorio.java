package src.com.NamedRoger.dominio.repositorios;

import src.com.NamedRoger.dominio.models.Entidad;
import src.com.NamedRoger.infraestructura.interfaces.Modelo;

import java.io.IOException;
import java.util.List;

public class Repositorio<TModel extends Modelo> implements IRepository<TModel> {
    Entidad<TModel> entidad;

    public Repositorio(Entidad<TModel> entidad){
        this.entidad = entidad;
    }

    @Override
    public List<TModel> obetenerTodos() {
        return this.entidad.obtener();
    }

    @Override
    public void insertar(TModel enitdad) throws IOException {
        this.entidad.insertar(enitdad);
    }

    @Override
    public void actualizar(TModel entidad, TModel entidadActualizada) throws IOException {
        this.entidad.editar(entidad, entidadActualizada);
    }

    @Override
    public void borrar(TModel entidad) {
        this.entidad.borrar(entidad);
    }
}
