package src.com.NamedRoger.Presentacion.Vistas.Login;

import src.com.NamedRoger.Dominio.Models.Usuario;
import src.com.NamedRoger.Presentacion.Vistas.View;

import java.util.Scanner;

public class LoginView extends View {

    public LoginView(Scanner scanner) {
        super("Login",scanner);
    }

    public Usuario Login(){
        this.apartado();
        System.out.println("Usuario");
        System.out.println("Password");

        return new Usuario();
    }
}
