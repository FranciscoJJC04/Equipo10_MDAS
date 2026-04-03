package bridge.buscadores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bridge.modelo.Producto;
import bridge.proveedores.Proveedor;

public class BuscadorStockSofasYMesas extends BuscadorPorStock {
    private final String tipoProducto;

    public BuscadorStockSofasYMesas(Proveedor proveedor) {
        this(proveedor, null);
    }

    public BuscadorStockSofasYMesas(Proveedor proveedor, String tipoProducto) {
        super(proveedor);
        this.tipoProducto = tipoProducto;
    }

    @Override
    public List<Producto> buscarOrdenadoPorStock() {
        Map<String, Producto> productosAgregados = new HashMap<>();

        for (Proveedor proveedor : proveedores) {
            for (Producto producto : proveedor.buscarProductos()) {
                if (tipoProducto != null && !producto.getTipo().equalsIgnoreCase(tipoProducto)) {
                    continue;
                }

                if (productosAgregados.containsKey(producto.getNombre())) {
                    Producto existente = productosAgregados.get(producto.getNombre());
                    existente.setUnidades(existente.getUnidades() + producto.getUnidades());
                } else {
                    productosAgregados.put(producto.getNombre(),
                            new Producto(producto.getNombre(), producto.getPrecio(), producto.getUnidades(), producto.getTipo()));
                }
            }
        }

        return productosAgregados.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getUnidades(), p1.getUnidades()))
                .collect(Collectors.toList());
    }
}
