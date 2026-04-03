import java.util.*;
import java.util.stream.Collectors;

public class BuscadorStockSofasYMesas extends BuscadorPorStock {
    private List<Proveedor> proveedores;
    private String tipoProducto;

    public BuscadorStockSofasYMesas(Proveedor proveedor) {
        super(proveedor);
        this.proveedores = new ArrayList<>();
        this.proveedores.add(proveedor);
        this.tipoProducto = null;
    }

    public BuscadorStockSofasYMesas(Proveedor proveedor, String tipoProducto) {
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
    public List<Producto> buscarOrdenadoPorStock() {
        Map<String, Producto> productosAgregados = new HashMap<>();
        for (Proveedor p : proveedores) {
            for (Producto prod : filtrarPorTipo(p.buscarProductos())) {
                if (productosAgregados.containsKey(prod.getNombre())) {
                    Producto existente = productosAgregados.get(prod.getNombre());
                    existente.setUnidades(existente.getUnidades() + prod.getUnidades());
                } else {
                    productosAgregados.put(prod.getNombre(), 
                        new Producto(prod.getNombre(), prod.getPrecio(), prod.getUnidades(), prod.getTipo()));
                }
            }
        }
        
        return productosAgregados.values().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getUnidades(), p1.getUnidades()))
                .collect(Collectors.toList());
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
}
