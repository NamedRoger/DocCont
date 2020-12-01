package src.com.NamedRoger.presentacion.controladores;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.infraestructura.exceptions.OpcionException;
import src.com.NamedRoger.presentacion.vistas.home.Home;

public class HomeController extends ControllerBase {
    Home home;
    public HomeController(DataBase dataBase) {
        super(dataBase);
        home = new Home("Menu Principal",this.scanner);
    }

    public void principal() throws OpcionException {
        boolean enPrincipal = true;
        DoctorController doctorController = new DoctorController(this.dataBase);
        PacienteController pacienteController = new PacienteController(this.dataBase);

        do{
            try{
                var opHome = home.principal();
                validarOpcion(opHome,0,4);

                switch (opHome){
                    case 1:
                        enPrincipal = doctorController.index();
                        break;
                    case 2:
                        enPrincipal = pacienteController.index();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        enPrincipal = false;
                        break;
                }
            }catch (OpcionException opcionException){
                System.out.println(opcionException.getMessage());
            }

        }while (enPrincipal);
    }
}
