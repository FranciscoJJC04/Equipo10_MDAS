import java.util.*;

public class BuscadorStockMesas extends BuscadorPorStock {

    public BuscadorStockMesas(Proveedor proveedor) {
        super(proveedor);
    }

    @Override
    public List<Producto> buscarOrdenadoPorStock() {
        return proveedor.buscarPorUnidades();
    }
}
