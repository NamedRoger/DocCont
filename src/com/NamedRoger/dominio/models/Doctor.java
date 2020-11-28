package src.com.NamedRoger.dominio.models;

import src.com.NamedRoger.infraestructura.interfaces.Modelo;

public class Doctor implements Modelo {
    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }
}
