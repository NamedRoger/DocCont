package src.com.NamedRoger.Dominio.Models;

public class Paciente {

    private Integer id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private boolean isDelete;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoP() {
        return apellidoP;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
    public boolean getDelete() {
        return isDelete;
    }
}
