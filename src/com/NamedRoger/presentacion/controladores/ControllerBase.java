package src.com.NamedRoger.presentacion.controladores;

import src.com.NamedRoger.dominio.db.DataBase;

import java.util.Scanner;

public abstract class ControllerBase {
    protected Scanner scanner;
    protected DataBase dataBase;
    public ControllerBase(DataBase dataBase){
        this.dataBase = dataBase;
        this.scanner = new Scanner(System.in);
    }
}
