import java.util.*;
import java.util.stream.Collectors;

public class BuscadorSofas extends Buscador {

    public BuscadorSofas(Proveedor proveedor) {
        super(proveedor);
    }

    @Override
    public List<Producto> buscar() {
        return proveedor.buscarProductos();
    }

    @Override
    public List<Producto> buscarPorPrecio() {
        return proveedor.buscarPorPrecio();
    }

    @Override
    public List<Producto> buscarPorUnidades() {
        return proveedor.buscarPorUnidades();
    }
}
