package src.com.NamedRoger.presentacion.controladores;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.infraestructura.exceptions.OpcionException;

import java.util.Scanner;

public abstract class ControllerBase {
    protected Scanner scanner;
    protected DataBase dataBase;
    public ControllerBase(DataBase dataBase){
        this.dataBase = dataBase;
        this.scanner = new Scanner(System.in);
    }

    public void validarOpcion(int op,int opInicial, int opFinal) throws OpcionException {
        String mensaje = String.format("La opcion debe de ser mayor a %s y menor a %s",opInicial,opFinal);
        if (op < opInicial || op > opFinal) throw new OpcionException(mensaje);
    }
}
