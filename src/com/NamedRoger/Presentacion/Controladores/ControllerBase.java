package src.com.NamedRoger.Presentacion.Controladores;

import java.util.Scanner;

public abstract class ControllerBase {
    protected Scanner scanner;
    public ControllerBase(){
        this.scanner = new Scanner(System.in);
    }
}
