package src.com.NamedRoger.presentacion.controladores;

import src.com.NamedRoger.aplicacion.servicios.ServicioDoctor;
import src.com.NamedRoger.aplicacion.servicios.ServicioPaciente;
import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.infraestructura.exceptions.OpcionException;
import src.com.NamedRoger.presentacion.vistas.pacientes.Add;
import src.com.NamedRoger.presentacion.vistas.pacientes.Edit;
import src.com.NamedRoger.presentacion.vistas.pacientes.Index;
import src.com.NamedRoger.presentacion.vistas.pacientes.Listar;

import java.io.IOException;

public class PacienteController extends ControllerBase {
    Index index;
    Listar listar;
    Add add;
    Edit edit;

    ServicioPaciente servicioPaciente;

    public PacienteController(DataBase dataBase) {
        super(dataBase);
        servicioPaciente = new ServicioPaciente(this.dataBase);
    }

    public boolean index(){
        boolean regresarOSalir = true;
        boolean estoyEnDoctores = true;
        do {
            try{
                var op = index.index();
                validarOpcion(op,0,6);
                switch (op){
                    case 1:
                        this.list();
                        break;
                    case 2:
                        this.add();
                        break;
                    case 3:
                        this.edit();
                        break;
                    case 4:
                        this.delete();
                        break;
                    case 5:
                        regresarOSalir = true;
                        estoyEnDoctores = false;
                        break;
                    case 6:
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
        this.listar.listar(this.servicioPaciente.obtenerTodos());
    }

    public void add() throws IOException {
        var nuevoPaciente = this.add.add();
        this.servicioPaciente.insertarPaciente(nuevoPaciente);
        System.out.println("Paciente agregado");
    }

    public void edit() throws IOException {
        var id = scanner.nextInt();
        var paciente = this.servicioPaciente.obtener(id);
        var pacienteEditado  = this.edit.editar(paciente);
        this.servicioPaciente.editarPaciente(paciente,pacienteEditado);
        System.out.println("Paciente editado");
    }

    public void delete(){
        System.out.println("Paciente eliminado");
    }


}
