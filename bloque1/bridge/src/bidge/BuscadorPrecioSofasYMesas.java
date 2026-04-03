import java.util.*;
import java.util.stream.Collectors;

public class BuscadorPrecioSofasYMesas extends BuscadorPorPrecio {
    private List<Proveedor> proveedores;
    private String tipoProducto;

    public BuscadorPrecioSofasYMesas(Proveedor proveedor) {
        super(proveedor);
        this.proveedores = new ArrayList<>();
        this.proveedores.add(proveedor);
        this.tipoProducto = null;
    }

    public BuscadorPrecioSofasYMesas(Proveedor proveedor, String tipoProducto) {
        super(proveedor);
        this.proveedores = new ArrayList<>();
        this.proveedores.add(proveedor);
        this.tipoProducto = tipoProducto;
    }

    public void agregarProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }

    private List<Producto> filtrarPorTipo(List<Producto> productos) {
        if (tipoProducto == null) {
            return productos;
        }
        return productos.stream()
                .filter(p -> p.getTipo().equalsIgnoreCase(tipoProducto))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> buscarOrdenadoPorPrecio() {
        List<Producto> resultado = new ArrayList<>();
        for (Proveedor p : proveedores) {
            resultado.addAll(p.buscarPorPrecio());
        }
        return filtrarPorTipo(resultado).stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
