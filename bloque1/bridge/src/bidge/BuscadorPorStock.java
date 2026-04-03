import java.util.*;

public abstract class BuscadorPorStock {
    protected Proveedor proveedor;

    public BuscadorPorStock(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    // Método que delega en la implementación para obtener productos ordenados por stock
    public abstract List<Producto> buscarOrdenadoPorStock();

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
