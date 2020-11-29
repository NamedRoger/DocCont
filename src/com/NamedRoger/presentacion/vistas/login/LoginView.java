package src.com.NamedRoger.presentacion.vistas.login;

import src.com.NamedRoger.dominio.models.Usuario;
import src.com.NamedRoger.presentacion.vistas.View;

import java.util.Scanner;

public class LoginView extends View {

    public LoginView(Scanner scanner) {
        super("Login",scanner);
    }

    public Usuario Login(){
        this.apartado();
        
        System.out.println("Usuario");
        var userName= scanner.nextLine();
        System.out.println("Password");
        var password = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setUserName(userName);
        usuario.setPassword(password);

        return usuario;
    }
}
