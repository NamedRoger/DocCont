package src.com.NamedRoger.infraestructura.interfaces;

import java.io.IOException;
import java.util.List;

public interface ICreador<TModel> {
    public List<TModel> cargarDatos() throws IOException;
    public void crearTabla() throws IOException;
}
