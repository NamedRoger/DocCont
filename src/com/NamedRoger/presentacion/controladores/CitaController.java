package src.com.NamedRoger.presentacion.controladores;

import src.com.NamedRoger.aplicacion.servicios.ServicioCita;
import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.infraestructura.exceptions.OpcionException;
import src.com.NamedRoger.presentacion.vistas.cita.AddCita;
import src.com.NamedRoger.presentacion.vistas.cita.EditCita;
import src.com.NamedRoger.presentacion.vistas.cita.IndexCita;
import src.com.NamedRoger.presentacion.vistas.cita.ListarCita;
import src.com.NamedRoger.presentacion.vistas.doctor.Edit;

import java.io.IOException;

public class CitaController extends ControllerBase{
    ServicioCita servicioCita;
    IndexCita indexCita;
    AddCita addCita;
    EditCita editCita;
    ListarCita listarCita;

    public CitaController(DataBase dataBase) {
        super(dataBase);

        indexCita = new IndexCita("Menu Cita",this.scanner);
        addCita = new AddCita("Agregar Cita",this.scanner);
        editCita = new EditCita("Editar Citar", this.scanner);
        listarCita = new ListarCita("Citas",this.scanner);

        servicioCita = new ServicioCita(this.dataBase);
    }

    public boolean index(){
        boolean regresarOSalir = true;
        boolean estoyEnDoctores = true;
        do {
            try{
                var op = indexCita.index();
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
        listarCita.listar(this.servicioCita.obtenerCitas());
    }

    public void add(){

    }

    public void edit(){

    }

    public void delete(){

    }
}
