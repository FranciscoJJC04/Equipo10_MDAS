import java.util.*;

public class BuscadorPrecioSofas extends BuscadorPorPrecio {

    public BuscadorPrecioSofas(Proveedor proveedor) {
        super(proveedor);
    }

    @Override
    public List<Producto> buscarOrdenadoPorPrecio() {
        return proveedor.buscarPorPrecio();
    }
}
