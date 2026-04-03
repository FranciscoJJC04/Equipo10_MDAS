package bridge_modular.proveedores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bridge_modular.modelo.Producto;

public class Sofas implements Proveedor {
    private final String nombre;
    private final List<Producto> stocks;

    public Sofas(String nombre) {
        this.nombre = nombre;
        this.stocks = new ArrayList<>();
    }

    @Override
    public List<Producto> buscarProductos() {
        return stocks.stream()
                .filter(producto -> producto.getUnidades() > 0 && producto.getTipo().equalsIgnoreCase("Sofa"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> buscarPorPrecio() {
        return buscarProductos().stream()
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> buscarPorUnidades() {
        return buscarProductos().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getUnidades(), p1.getUnidades()))
                .collect(Collectors.toList());
    }

    @Override
    public void agregarProducto(Producto producto) {
        if (!producto.getTipo().equalsIgnoreCase("Sofa")) {
            return;
        }
        for (Producto existente : stocks) {
            if (existente.equals(producto)) {
                existente.setUnidades(existente.getUnidades() + producto.getUnidades());
                return;
            }
        }
        stocks.add(producto);
    }

    @Override
    public void eliminarProducto(String nombre) {
        stocks.removeIf(producto -> producto.getNombre().equals(nombre));
    }

    @Override
    public String getTipo() {
        return "Sofa";
    }

    public String getNombre() {
        return nombre;
    }
}
