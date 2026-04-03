import java.util.*;

public abstract class BuscadorPorPrecio {
    protected Proveedor proveedor;

    public BuscadorPorPrecio(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    // Método que delega en la implementación para obtener productos ordenados por precio
    public abstract List<Producto> buscarOrdenadoPorPrecio();

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
