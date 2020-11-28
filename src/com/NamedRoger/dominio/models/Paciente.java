package src.com.NamedRoger.dominio.models;

public class Paciente extends BaseModelo {

    private String nombre;
    private String apellidoP;
    private String apellidoM;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
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

}
