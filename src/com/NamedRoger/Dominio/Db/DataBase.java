package src.com.NamedRoger.Dominio.Db;

public class DataBase {
    private static DataBase dataBase;
    private DataBase(){

    }

    public static DataBase getInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
        }
        return dataBase;
    }
}
