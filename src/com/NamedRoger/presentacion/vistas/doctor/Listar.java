package src.com.NamedRoger.presentacion.vistas.doctor;

import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.List;
import java.util.Scanner;

public class Listar extends View {
    public Listar(String title, Scanner scanner) {
        super(title, scanner);
    }

    public void listar(List<Doctor> doctores){
        apartado();
        if(doctores.size() < 1){
            System.out.println("No hay doctores");
        }else{
            doctores.forEach(doctor -> {
                System.out.println(String.format("Nombre: %s",doctor.getNombre()));
                System.out.println(String.format("Especialidad: %s",doctor.getEspecialidad()));
                System.out.println(String.format("Cedula: %s",doctor.getCedula()));
                System.out.println();
            });
        }
    }
}
