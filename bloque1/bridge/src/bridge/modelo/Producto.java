package bridge.modelo;

public class Producto {
    private String nombre;
    private double precio;
    private int unidades;
    private String tipo;

    public Producto(String nombre, double precio, int unidades, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidades = unidades;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Producto producto = (Producto) other;
        return nombre.equals(producto.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return nombre + " | Precio: " + precio + " | Stock: " + unidades + " | Tipo: " + tipo;
    }
}
