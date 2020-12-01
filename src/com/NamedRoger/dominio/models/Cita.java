package src.com.NamedRoger.dominio.models;

import src.com.NamedRoger.infraestructura.Constante;

public class Cita extends BaseModelo {
    private Paciente paciente;
    private Doctor doctor;
    private String fecha;
    private String razon;
    private Constante.ESTATUS_CITA estatusCita = Constante.ESTATUS_CITA.valueOf("PENDIENTE");

    public Cita(){
        this.paciente = new Paciente();
        this.doctor = new Doctor();
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public void setEstatusCita(Constante.ESTATUS_CITA estatusCita) {
        this.estatusCita = estatusCita;
    }

    public Constante.ESTATUS_CITA getEstatusCita() {
        return estatusCita;
    }
}
