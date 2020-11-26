package src.com.NamedRoger.presentacion.controladores;


import src.com.NamedRoger.presentacion.vistas.login.LoginView;

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
