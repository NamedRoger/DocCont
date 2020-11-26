package src.com.NamedRoger.presentacion.controladores;

import java.util.Scanner;

public abstract class ControllerBase {
    protected Scanner scanner;
    public ControllerBase(){
        this.scanner = new Scanner(System.in);
    }
}
