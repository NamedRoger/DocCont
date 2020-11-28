package src.com.NamedRoger.dominio.db;

import java.util.HashMap;

public class RegistroDataBase {
    private HashMap<String,Integer> registroTablas= new HashMap<>();

    public void agregarOEditarRegistro(String tabla, Integer ultimoId){
        registroTablas.put(tabla,ultimoId);
    }

    public Integer obtenerRegistro(String tabla){
        var registro = registroTablas.get(tabla);
        return registro;
    }
}
