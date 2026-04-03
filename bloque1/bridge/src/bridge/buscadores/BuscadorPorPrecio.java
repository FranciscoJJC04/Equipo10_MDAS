package bridge_modular.buscadores;

import java.util.ArrayList;
import java.util.List;

import bridge_modular.modelo.Producto;
import bridge_modular.proveedores.Proveedor;

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
