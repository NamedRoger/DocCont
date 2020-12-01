package src.com.NamedRoger.presentacion.controladores;

import src.com.NamedRoger.aplicacion.servicios.ServicioDoctor;
import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.infraestructura.exceptions.OpcionException;
import src.com.NamedRoger.presentacion.vistas.doctor.Add;
import src.com.NamedRoger.presentacion.vistas.doctor.Edit;
import src.com.NamedRoger.presentacion.vistas.doctor.Index;
import src.com.NamedRoger.presentacion.vistas.doctor.Listar;

import java.io.IOException;

public class DoctorController extends ControllerBase {
    ServicioDoctor servicioDoctor;
    Index index;
    Listar listar;
    Add add;
    Edit edit;

    public DoctorController(DataBase dataBase) {
        super(dataBase);
        servicioDoctor = new ServicioDoctor(this.dataBase);
        index = new Index("Menu Doctores",this.scanner);
        listar = new Listar("Doctores",this.scanner);
        add = new Add("Agregar Doctor",this.scanner);
        edit = new Edit("Editar Doctor",this.scanner);
    }

    public boolean index() throws OpcionException {
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
        this.listar.listar(this.servicioDoctor.obtenerTodos());
    }

    public void add() throws IOException {
        var usuarioNuevo = this.add.add();
        this.servicioDoctor.insertarDoctor(usuarioNuevo);
        System.out.println("Doctor agregdo");
    }

    public void edit() throws IOException {
        System.out.println("Introduce la cedula");
        var cedula = this.scanner.nextLine();
        var doctor = this.servicioDoctor.obtenerPorCedula(cedula);
        var doctorEditado = this.edit.editar(doctor);
        this.servicioDoctor.editarDoctor(doctor,doctorEditado);
        System.out.println("Doctor editado");
    }

    public void delete() throws IOException {
        System.out.println("Introduce la cedula");
        var cedula = this.scanner.nextLine();
        var doctor = this.servicioDoctor.obtenerPorCedula(cedula);
        this.servicioDoctor.borrarDoctor(doctor);
        System.out.println("Doctor eliminado");
    }

}
