package src.com.NamedRoger.presentacion;

import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.db.RegistroDataBase;
import src.com.NamedRoger.presentacion.controladores.LoginController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;



public class Main {

    public static void main(String args[]) throws Exception {
        boolean logueado = false;
        DataBase db = DataBase.getInstance();
        RegistroDataBase registroDataBase = RegistroDataBase.getInstance();

        LoginController loginController = new LoginController(db);
        apartado("Bienvendo al sistema DocCont");
        do {
            try{
                if(!logueado){
                    var noExiste = true;
                    do{
                        noExiste = !(loginController.showLogin());
                        if(noExiste){
                            throw new Exception("El usuario es invalido, verfica");
                        }
                    }while (noExiste);
                }else{
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }while (logueado);
    }

    protected static void apartado(String title){
        double diff = 60 - title.length();
        double half = (diff/2<(60/2))?(diff/2): (diff/2)-(title.length()/2);

        boolean writed = false;
        for(int i =0;i<diff;i++){
            if(i<half || writed){
                System.out.print("-");
            }else{
                System.out.print(title);
                writed = true;
            }
        }
        System.out.println("");
    }

}
