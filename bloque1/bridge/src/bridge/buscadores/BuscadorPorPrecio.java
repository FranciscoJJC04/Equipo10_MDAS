package bridge.buscadores;

import java.util.ArrayList;
import java.util.List;

import bridge.modelo.Producto;
import bridge.proveedores.Proveedor;

public abstract class BuscadorPorPrecio {
    protected final List<Proveedor> proveedores;

    protected BuscadorPorPrecio(Proveedor proveedor) {
        this.proveedores = new ArrayList<>();
        this.proveedores.add(proveedor);
    }

    public void agregarProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }

    public abstract List<Producto> buscarOrdenadoPorPrecio();
}
