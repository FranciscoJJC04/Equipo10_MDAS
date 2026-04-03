package bridge.proveedores;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import bridge.modelo.Producto;

public class Mesas implements Proveedor {
    private final String nombre;
    private final List<Producto> stocks;

    public Mesas(String nombre) {
        this.nombre = nombre;
        this.stocks = new ArrayList<>();
    }

    @Override
    public List<Producto> buscarProductos() {
        return stocks.stream() //Filtra los productos para incluir solo aquellos que son mesas y tienen unidades disponibles
                .filter(producto -> producto.getUnidades() > 0 && producto.getTipo().equalsIgnoreCase("Mesa"))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> buscarPorPrecio() {
        return buscarProductos().stream() //Ordena los productos por precio de menor a mayor utilizando un comparador
                .sorted(Comparator.comparingDouble(Producto::getPrecio))
                .collect(Collectors.toList());
    }

    @Override
    public List<Producto> buscarPorUnidades() {
        return buscarProductos().stream() //Ordena los productos por unidades disponibles de mayor a menor utilizando un comparador
                .sorted((p1, p2) -> Integer.compare(p2.getUnidades(), p1.getUnidades()))
                .collect(Collectors.toList());
    }

    @Override
    public void agregarProducto(Producto producto) {
        if (!producto.getTipo().equalsIgnoreCase("Mesa")) { //equalsIgnoreCase sive pa comparar el tipo del producto sin importar mayús o minús
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
        return "Mesa";
    }

    public String getNombre() {
        return nombre;
    }
}
