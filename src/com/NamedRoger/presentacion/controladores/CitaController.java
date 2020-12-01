package src.com.NamedRoger.presentacion.controladores;

import src.com.NamedRoger.aplicacion.servicios.ServicioCita;
import src.com.NamedRoger.aplicacion.servicios.ServicioDoctor;
import src.com.NamedRoger.aplicacion.servicios.ServicioPaciente;
import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.infraestructura.exceptions.OpcionException;
import src.com.NamedRoger.presentacion.vistas.cita.AddCita;
import src.com.NamedRoger.presentacion.vistas.cita.IndexCita;
import src.com.NamedRoger.presentacion.vistas.cita.ListarCita;

import java.io.IOException;

public class CitaController extends ControllerBase{
    ServicioCita servicioCita;
    ServicioPaciente servicioPaciente;
    ServicioDoctor servicioDoctor;
    IndexCita indexCita;
    AddCita addCita;
    ListarCita listarCita;

    public CitaController(DataBase dataBase) {
        super(dataBase);

        indexCita = new IndexCita("Menu Cita",this.scanner);
        addCita = new AddCita("Agregar Cita",this.scanner);
        listarCita = new ListarCita("Citas",this.scanner);

        servicioCita = new ServicioCita(this.dataBase);
        servicioPaciente = new ServicioPaciente(this.dataBase);
        servicioDoctor = new ServicioDoctor(this.dataBase);
    }

    public boolean index(){
        boolean regresarOSalir = true;
        boolean estoyEnDoctores = true;
        do {
            try{
                var op = indexCita.index();
                validarOpcion(op,0,5);
                switch (op){
                    case 1:
                        this.list();
                        break;
                    case 2:
                        this.add();
                        break;
                    case 3:
                        this.delete();
                        break;
                    case 4:
                        regresarOSalir = true;
                        estoyEnDoctores = false;
                        break;
                    case 5:
                        regresarOSalir = false;
                        estoyEnDoctores = false;
                        break;
                }
            }catch (OpcionException | IOException opcionException){
                System.out.println(opcionException.getMessage());
            }
        }while (estoyEnDoctores);
        return regresarOSalir;
    }

    public void list(){
        listarCita.listar(this.servicioCita.obtenerCitas());
    }

    public void add() throws IOException {
        System.out.println("Introduce el id del paciente");
        var idPaciente = this.scanner.nextInt();
        scanner.nextLine();
        var paciente = this.servicioPaciente.obtener(idPaciente);
        System.out.println("Cedual del Doctor");
        var cedula = this.scanner.nextLine();
        var doctor = this.servicioDoctor.obtenerPorCedula(cedula);
        var cita = this.addCita.add(paciente,doctor);
        this.servicioCita.insertarCita(cita);
        System.out.println("Cita agregda");
    }

    public void delete() throws IOException {
        System.out.println("Introduce el id de la cita");
        var id = this.scanner.nextInt();
        this.scanner.nextLine();
        var cita = this.servicioCita.obtenerCita(id);
        this.servicioCita.borrarCita(cita);
    }
}
