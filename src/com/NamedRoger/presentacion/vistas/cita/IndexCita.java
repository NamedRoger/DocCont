package src.com.NamedRoger.presentacion.vistas.cita;

import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class IndexCita extends View {
    public IndexCita(String title, Scanner scanner) {
        super(title, scanner);
    }

    public int index(){
        apartado();
        System.out.println("" +
                "(1) Listar \n" +
                "(2) Agregar \n" +
                "(3) Borrar \n" +
                "(4) Regresar \n" +
                "(5) Salir \n");
        var op = scanner.nextInt();
        scanner.nextLine();
        return op;
    }


}
