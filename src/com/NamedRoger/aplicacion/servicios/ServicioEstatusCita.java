package src.com.NamedRoger.aplicacion.servicios;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.Cita;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.infraestructura.interfaces.Modelo;

import java.io.IOException;
import java.util.List;

public class ServicioEstatusCita {
    DataBase db;
    public  ServicioEstatusCita(DataBase db){
        this.db = db;
    }

    public EstatusCita obtener(int id){
        return this.db.getEstatusCita().obtener(id);
    }

    public List<EstatusCita> obtenerTodos() {
        return this.db.getEstatusCita().obtenerTodos();
    }

    public void insertarEstatusCita(String nombre) throws IOException {
        EstatusCita estatusCita = new EstatusCita();
        estatusCita.setNombre(nombre);
        this.db.getEstatusCita().insertar(estatusCita);
    }

    public void editarEstatusCita(int id,EstatusCita estatusCita) throws IOException {
        var estatusCitaActual = this.db.getEstatusCita().obtener(id);
        this.db.getEstatusCita().editar(estatusCitaActual,estatusCita);
    }

    public boolean borrarEstatusCita(int id) throws IOException {
        var estatusCita = this.db.getEstatusCita().obtener(id);
        var exito = this.db.getEstatusCita().borrar(estatusCita);
        return exito;
    }
}
