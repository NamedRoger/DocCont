package src.com.NamedRoger.presentacion.vistas.pacientes;

import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.Paciente;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class Edit extends View {
    public Edit(String title, Scanner scanner) {
        super(title, scanner);
    }


    public Paciente editar(Paciente paciente){

        System.out.println("Nombre del paciente");
        var nombre = this.scanner.nextLine();

        paciente.setNombre(nombre);
        return paciente;
    }
}
