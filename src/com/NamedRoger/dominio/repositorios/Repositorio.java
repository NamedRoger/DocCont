package src.com.NamedRoger.dominio.repositorios;

import src.com.NamedRoger.dominio.models.Entidad;
import src.com.NamedRoger.dominio.models.Modelo;

import java.io.IOException;
import java.util.List;

public abstract class Repositorio<TEntidad extends Modelo> implements IRepository<TEntidad> {
    Entidad<TEntidad> entidad;

    public Repositorio(Entidad<TEntidad> entidad){
        this.entidad = entidad;
    }

    @Override
    public List<TEntidad> obetenerTodos() {
        return this.entidad.obtener();
    }

    @Override
    public void insertar(TEntidad enitdad) {
        this.entidad.insertar(enitdad);
    }

    @Override
    public void actualizar(TEntidad entidad, TEntidad entidadActualizada) {
        this.entidad.editar(entidad, entidadActualizada);
    }

    @Override
    public void borrar(int id) {
        this.entidad.borrar(id);
    }
}
