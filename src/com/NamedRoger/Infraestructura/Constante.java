package src.com.NamedRoger.Infraestructura;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Constante {

    public static String getPath() {
        var separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%scom%sNamedRoger%sFiles%s",separator,separator,separator,separator);

        return fileName;
    }
}
