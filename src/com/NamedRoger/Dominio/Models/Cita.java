package src.com.NamedRoger.Dominio.Models;

import java.util.Date;

public class Cita {
    private Integer id;
    private Paciente paciente;
    private Doctor doctor;
    private Date fecha;
    private EstatusCita estatusCita;

    Cita(){
        this.paciente = new Paciente();
        this.doctor = new Doctor();
        this.estatusCita = new EstatusCita();
    }

    public Integer getId() {
        return id;
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

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setEstatusCita(EstatusCita estatusCita) {
        this.estatusCita = estatusCita;
    }

    public EstatusCita getEstatusCita() {
        return estatusCita;
    }
}
