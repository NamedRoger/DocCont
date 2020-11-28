package src.com.NamedRoger.presentacion;


import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.db.RegistroDataBase;

public class Main {
    public static void main(String args[]) throws Exception {
        DataBase db = DataBase.getInstance();
        RegistroDataBase registroDataBase = RegistroDataBase.getInstance();
    }
}