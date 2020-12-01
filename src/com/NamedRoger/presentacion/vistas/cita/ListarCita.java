package src.com.NamedRoger.presentacion.vistas.cita;

import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.Doctor;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.List;
import java.util.Scanner;

public class ListarCita extends View {
    public ListarCita(String title, Scanner scanner) {
        super(title, scanner);
    }

    public void listar(List<Cita> citas){
        apartado();
        if(citas.size() < 1){
            System.out.println("No hay Citas");
        }else{
            citas.forEach(cita -> {
                System.out.println(String.format("Paciente: %s",cita.getPaciente().getNombre()));
                System.out.println(String.format("Especialidad: %s",cita.getDoctor().getNombre()));
                System.out.println(String.format("Razon: %s",cita.getRazon()));
                System.out.println(String.format("Fecha: %s",cita.getFecha()));
                System.out.println();
            });
        }
    }
}
