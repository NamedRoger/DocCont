package src.com.NamedRoger.presentacion.vistas.cita;

import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class CitaView extends View {

    public CitaView(Scanner scanner) {
        super("Listado de Citas",scanner);
    }

    public void Index(){
        this.apartado();
        System.out.println("Aqui iria una lista de citas");
    }
}
