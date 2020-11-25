package src.com.NamedRoger.Presentacion;


import src.com.NamedRoger.Presentacion.Controladores.LoginController;
import src.com.NamedRoger.Presentacion.Vistas.Inicio;

public class Main {
    public static void main(String args[]){
        LoginController loginController = new LoginController();
        loginController.showLogin();
    }
}
