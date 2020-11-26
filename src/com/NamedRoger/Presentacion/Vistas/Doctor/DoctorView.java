package src.com.NamedRoger.Presentacion.Vistas.Doctor;

import src.com.NamedRoger.Presentacion.Vistas.View;

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

