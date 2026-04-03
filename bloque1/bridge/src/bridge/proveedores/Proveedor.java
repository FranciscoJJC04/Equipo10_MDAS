package bridge_modular.proveedores;

import java.util.List;
import bridge_modular.modelo.Producto;

public interface Proveedor {
    List<Producto> buscarProductos();
    List<Producto> buscarPorPrecio();
    List<Producto> buscarPorUnidades();
    void agregarProducto(Producto producto);
    void eliminarProducto(String nombre);
    String getTipo();
}
