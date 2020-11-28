package src.com.NamedRoger.dominio.models;

import src.com.NamedRoger.infraestructura.interfaces.Modelo;

public class Doctor extends BaseModelo {
    private String nombre;
    private String cedula;
    private Especialidad especialidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
}
