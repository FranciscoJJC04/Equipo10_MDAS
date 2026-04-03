
import java.util.*;
import java.util.stream.Collectors;

public abstract class Buscador {
    protected Proveedor proveedor;
    private Map<String, Integer> stockAgregado;

    public Buscador(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.stockAgregado = new HashMap<>();
    }

    // Método general de búsqueda
    public abstract List<Producto> buscar();

    // Búsqueda ordenada por precio de menor a mayor
    public abstract List<Producto> buscarPorPrecio();

    // Búsqueda ordenada por unidades de mayor a menor
    public abstract List<Producto> buscarPorUnidades();

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.stockAgregado.clear();
    }

    protected void actualizarStockAgregado(List<Producto> productos) {
        this.stockAgregado.clear();
        for (Producto p : productos) {
            stockAgregado.put(p.getNombre(), 
                stockAgregado.getOrDefault(p.getNombre(), 0) + p.getUnidades());
        }
    }

    public Map<String, Integer> getStockAgregado() {
        return stockAgregado;
    }
}

