import java.util.*;
import java.util.stream.Collectors;

public class BuscadorMesas extends Buscador {

    public BuscadorMesas(Proveedor proveedor) {
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
