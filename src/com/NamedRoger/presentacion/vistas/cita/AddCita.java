package src.com.NamedRoger.presentacion.vistas.cita;

import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.Paciente;
import src.com.NamedRoger.infraestructura.Constante;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class AddCita extends View {
    public AddCita(String title, Scanner scanner) {
        super(title, scanner);
    }

    public Cita add(Paciente paciente, Doctor doctor){
        apartado();
        Cita cita = new Cita();
        System.out.println("Motivo de la cita");
        var razon = this.scanner.nextLine();
        System.out.println("fecha");
        var fecha = this.scanner.nextLine();

        cita.setPaciente(paciente);
        cita.setDoctor(doctor);
        cita.setRazon(razon);
        cita.setFecha(fecha);
        cita.setEstatusCita(Constante.ESTATUS_CITA.PENDIENTE);
        return cita;
    }
}
