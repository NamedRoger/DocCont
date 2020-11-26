package src.com.NamedRoger.infraestructura;

import java.nio.file.FileSystems;

public class Constante {

    public static String getPath() {
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%sNamedRoger%sFiles%s",separator,separator,separator,separator);

        return fileName;
    }
}
