package src.com.NamedRoger.presentacion.vistas.pacientes;

import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.dominio.models.Paciente;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class Listar extends View {
    public Listar(String title, Scanner scanner) {
        super(title, scanner);
    }

    public void listar(java.util.List<Paciente> pacientes){
        apartado();
        if(pacientes.size() < 1){
            System.out.println("No hay pacientes");
        }else{
            pacientes.forEach(paciente -> {
                System.out.println(String.format("Id: %s",paciente.getId()));
                System.out.println(String.format("Nombre: %s",paciente.getNombre()));
                System.out.println();
            });
        }
    }
}
