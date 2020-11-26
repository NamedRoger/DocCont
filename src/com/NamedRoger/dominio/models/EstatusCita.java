package src.com.NamedRoger.dominio.models;

public class EstatusCita implements Modelo{
    private Integer id;
    private String nombre;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
