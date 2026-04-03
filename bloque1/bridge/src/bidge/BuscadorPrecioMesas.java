import java.util.*;

public class BuscadorPrecioMesas extends BuscadorPorPrecio {

    public BuscadorPrecioMesas(Proveedor proveedor) {
        super(proveedor);
    }

    @Override
    public List<Producto> buscarOrdenadoPorPrecio() {
        return proveedor.buscarPorPrecio();
    }
}
