package src.com.NamedRoger.dominio.models;

import src.com.NamedRoger.infraestructura.interfaces.Modelo;

public class Especialidad implements Modelo {
    private Integer id;
    private String nombre;

    @Override
    public Integer getId() {
        return this.id;
    }
}
