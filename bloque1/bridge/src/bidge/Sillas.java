import java.util.*;
import java.util.stream.Collectors;

public class Sillas implements Proveedor {
    private String nombre;
    private List<Producto> stocks;

    public Sillas(String nombre) {
        this.nombre = nombre;
        this.stocks = new ArrayList<>();
    }

    @Override
    public List<Producto> buscarProductos() {
        return stocks.stream()
                .filter(p -> p.getUnidades() > 0 && p.getTipo().equalsIgnoreCase("Silla"))
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
        if (producto.getTipo().equalsIgnoreCase("Silla")) {
            // Verificar si el producto ya existe, si es así sumar unidades
            boolean existe = false;
            for (Producto p : stocks) {
                if (p.equals(producto)) {
                    p.setUnidades(p.getUnidades() + producto.getUnidades());
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                stocks.add(producto);
            }
        }
    }

    @Override
    public void eliminarProducto(String nombre) {
        stocks.removeIf(p -> p.getNombre().equals(nombre));
    }

    @Override
    public String getTipo() {
        return "Silla";
    }

    public String getNombre() {
        return nombre;
    }
}
