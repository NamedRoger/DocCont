package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.EstatusCita;

import java.io.IOException;
import java.util.List;

public class ServicioEstatusCita {
    DataBase db;
    public  ServicioEstatusCita(DataBase db){
        this.db = db;
    }

    public List<EstatusCita> obtenerTodos() {
        return this.db.getEstatusCita().obtenerTodos();
    }

    public void insertarEstatusCita(String nombre) throws IOException {
        EstatusCita estatusCita = new EstatusCita();
        estatusCita.setNombre(nombre);
        this.db.getEstatusCita().insertar(estatusCita);
    }
}
