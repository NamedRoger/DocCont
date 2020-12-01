package src.com.NamedRoger.presentacion.vistas.home;

import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class Home extends View {

    public Home(String title, Scanner scanner) {
        super(title, scanner);
    }

    public int principal(){
        apartado();
        System.out.println("" +
                "(1) Doctores \n" +
                "(2) Pacientes \n" +
                "(3) Citas \n" +
                "(4) Especialidades \n" +
                "(5) Salir \n");
        var op = scanner.nextInt();
        scanner.nextLine();
        return op;
    }
}
