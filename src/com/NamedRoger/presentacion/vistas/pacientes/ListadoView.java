package src.com.NamedRoger.presentacion.vistas.pacientes;

import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class ListadoView extends View {

    public ListadoView(Scanner scanner) {
        super("Listado de Pacientes",scanner);
    }

    public void Index(){
        this.apartado();
        System.out.println("Aqui iria una lista de pacientes");
    }
}
