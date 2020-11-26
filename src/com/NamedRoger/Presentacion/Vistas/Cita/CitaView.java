package src.com.NamedRoger.Presentacion.Vistas.Cita;

import src.com.NamedRoger.Presentacion.Vistas.View;

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
