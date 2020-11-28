package src.com.NamedRoger.dominio.models;

import src.com.NamedRoger.infraestructura.interfaces.Modelo;

public class BaseModelo implements Modelo {
    protected Integer id = 1;

    @Override
    public Integer getId() {
        return (Integer) this.id;
    }
}
