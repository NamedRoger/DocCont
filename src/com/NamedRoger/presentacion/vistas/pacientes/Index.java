package src.com.NamedRoger.presentacion.vistas.pacientes;

import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class Index extends View {
    public Index(String title, Scanner scanner) {
        super(title, scanner);
    }

    public int index(){
        apartado();
        System.out.println("" +
                "(1) Listar \n" +
                "(2) Agregar \n" +
                "(3) Editar \n" +
                "(4) Borrar \n" +
                "(5) Regresar \n" +
                "(6) Salir \n");
        var op = scanner.nextInt();
        scanner.nextLine();
        return op;
    }
}
