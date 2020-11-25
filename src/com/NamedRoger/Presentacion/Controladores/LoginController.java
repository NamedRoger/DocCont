package src.com.NamedRoger.Presentacion.Controladores;


import src.com.NamedRoger.Presentacion.Vistas.Login.LoginView;

import java.util.Scanner;

public class LoginController extends ControllerBase{
    LoginView view;
    Scanner scanner;

    public LoginController(){
        view = new LoginView(this.scanner);
    }

    public void showLogin(){
        view.Login();
    }
}
