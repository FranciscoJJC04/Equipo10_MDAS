package bridge_modular.buscadores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bridge_modular.modelo.Producto;
import bridge_modular.proveedores.Proveedor;

public class BuscadorPrecioSofasYMesas extends BuscadorPorPrecio {
    private final String tipoProducto;

    public BuscadorPrecioSofasYMesas(Proveedor proveedor) {
        this(proveedor, null);
    }

    public BuscadorPrecioSofasYMesas(Proveedor proveedor, String tipoProducto) {
        super(proveedor);
        this.tipoProducto = tipoProducto;
    }

    @Override
    public List<Producto> buscarOrdenadoPorPrecio() {
        List<Producto> resultado = new ArrayList<>();
        for (Proveedor proveedor : proveedores) {
            resultado.addAll(proveedor.buscarPorPrecio());
        }

        return resultado.stream()
                .filter(producto -> tipoProducto == null || producto.getTipo().equalsIgnoreCase(tipoProducto))
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
    }
}
