package src.com.NamedRoger.presentacion;


import com.google.gson.Gson;
import src.com.NamedRoger.dominio.db.DataBase;
import src.com.NamedRoger.dominio.models.EstatusCita;
import src.com.NamedRoger.dominio.repositorios.Repositorio;

public class Main {
    public static void main(String args[]) throws Exception {
        DataBase dataBase = DataBase.getInstance();
        Repositorio<EstatusCita> e = new Repositorio<>(dataBase.getEstatusCita());
        EstatusCita eee = new EstatusCita();
        try {

            eee.setNombre("ddsdas");
            e.insertar(eee);
            e.insertar(eee);
            for(var aa:e.obetenerTodos()){
                System.out.println(aa.getNombre());
            }
        }catch (Exception p){
            System.out.println(p.getMessage());
        }

    }
}