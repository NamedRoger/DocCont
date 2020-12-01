package src.com.NamedRoger.presentacion.vistas.pacientes;

import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.Paciente;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class Add extends View {
    public Add(String title, Scanner scanner) {
        super(title, scanner);
    }

    public Paciente add(){
        apartado();
        Paciente paciente = new Paciente();
        System.out.println("Nombre del paciente");
        var nombre = this.scanner.nextLine();

        paciente.setNombre(nombre);

        return paciente;
    }
}
