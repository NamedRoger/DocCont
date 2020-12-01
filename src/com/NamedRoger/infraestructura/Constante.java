package src.com.NamedRoger.infraestructura;

import java.nio.file.FileSystems;

public class Constante {

    public static String getPath() {
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format(System.getProperty("user.home"));
        return fileName;
    }

    public enum ESTATUS_CITA {
        CANCELADA,
        PENDIENTE,
        REALIZADA
    }
}
