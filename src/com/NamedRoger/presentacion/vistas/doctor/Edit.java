package src.com.NamedRoger.presentacion.vistas.doctor;

import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.Paciente;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class Edit extends View {
    public Edit(String title, Scanner scanner) {
        super(title, scanner);
    }

    public Doctor editar(Doctor doctor){

        System.out.println("Nombre del doctor");
        var nombre = this.scanner.nextLine();
        System.out.println("Especialidad");
        var especialidad = this.scanner.nextLine();
        System.out.println("Cedula");
        var cedula = this.scanner.nextLine();

        doctor.setNombre(nombre);
        doctor.setEspecialidad(especialidad);
        doctor.setCedula(cedula);

        return doctor;
    }
}