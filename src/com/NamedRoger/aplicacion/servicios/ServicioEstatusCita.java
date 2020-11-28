package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.infraestructura.interfaces.IServicio;

import java.util.List;

public class ServicioEstatusCita {
    DataBase db;
    public  ServicioEstatusCita(DataBase db){
        this.db = db;
    }
    public List obtenerEstatusCita() {
        return this.db.getEstatusCita().obtener();
    }

    public void insertarEstatusCita(String estatusCita) {

    }

    public void editarEstatusCita(EstatusCita estatusCita) {

    }

    public void borrarEstatusCita(EstatusCita estatusCita) {

    }


}
