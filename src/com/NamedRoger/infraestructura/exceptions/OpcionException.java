package src.com.NamedRoger.infraestructura.exceptions;

public class OpcionException extends Exception {
    String mensaje;

    public OpcionException(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
