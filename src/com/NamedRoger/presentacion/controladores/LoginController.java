package src.com.NamedRoger.presentacion.controladores;


import src.com.NamedRoger.aplicacion.servicios.ServicioUsuario;
import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.presentacion.vistas.login.LoginView;

public class LoginController extends ControllerBase{
    LoginView view;
    ServicioUsuario servicioUsuario;

    public LoginController(DataBase dataBase){
        super(dataBase);
        view = new LoginView(this.scanner);
        servicioUsuario = new ServicioUsuario(this.dataBase);
    }

    public boolean showLogin() {
        boolean noLogueado = true;
        do{
            var usuario = view.Login();
            var existe = servicioUsuario.login(usuario.getUserName(),usuario.getPassword());
            if(existe){
               noLogueado = false;
                System.out.println("Te has logueado");
            }else {
                System.out.println("Puede que el usuario o la contraseña sean incorrectos");
            }
        }while (noLogueado);

        return !noLogueado;
    }
}
