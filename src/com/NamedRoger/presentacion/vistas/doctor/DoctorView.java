package src.com.NamedRoger.presentacion.vistas.doctor;

import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class DoctorView extends View {

    public DoctorView(Scanner scanner) {
        super("Listado de Doctores",scanner);
    }

    public void Index(){
        this.apartado();
        System.out.println("Aqui iria una lista de apartados");
    }
}

