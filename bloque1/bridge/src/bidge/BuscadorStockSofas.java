import java.util.*;

public class BuscadorStockSofas extends BuscadorPorStock {

    public BuscadorStockSofas(Proveedor proveedor) {
        super(proveedor);
    }

    @Override
    public List<Producto> buscarOrdenadoPorStock() {
        return proveedor.buscarPorUnidades();
    }
}
