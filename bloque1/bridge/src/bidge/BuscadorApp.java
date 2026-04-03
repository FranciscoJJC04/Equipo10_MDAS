import java.util.*;

public class BuscadorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Inicialización de Proveedores (Implementación)
        Sofas empresaA = new Sofas("Empresa A");
        Mesas empresaB = new Mesas("Empresa B");
        SofasYMesas empresaC = new SofasYMesas("Empresa C");

        // Carga de todos los productos (Catálogo completo)
        empresaA.agregarProducto(new Producto("Sofá Moderno", 450.00, 5, "Sofa"));
        empresaA.agregarProducto(new Producto("Sofá Clásico", 350.00, 3, "Sofa"));
        empresaA.agregarProducto(new Producto("Sofá Reina", 650.00, 2, "Sofa"));

        empresaB.agregarProducto(new Producto("Mesa Comedor", 200.00, 8, "Mesa"));
        empresaB.agregarProducto(new Producto("Mesa Madera", 300.00, 4, "Mesa"));
        empresaB.agregarProducto(new Producto("Mesa Vidrio", 250.00, 6, "Mesa"));

        empresaC.agregarProducto(new Producto("Sofá Moderno", 420.00, 4, "Sofa"));
        empresaC.agregarProducto(new Producto("Mesa Comedor", 180.00, 10, "Mesa"));
        empresaC.agregarProducto(new Producto("Sofá Premium", 700.00, 1, "Sofa"));

        
        System.out.println("Seleccione el método de búsqueda para todo el catálogo:");
        System.out.println("1. Ordenar por PRECIO (Menor a Mayor)");
        System.out.println("2. Ordenar por STOCK (Mayor a Menor - Unidades Agregadas)");
        System.out.print("\nOpción: ");
        
        int opcion = sc.nextInt();

        System.out.println("\n--- RESULTADOS DEL CATÁLOGO COMPLETO (A + B + C) ---");

        if (opcion == 1) {
            // Abstracción de Precio configurada con todos los proveedores
            BuscadorPrecioSofasYMesas buscadorPrecio = new BuscadorPrecioSofasYMesas(empresaA);
            buscadorPrecio.agregarProveedor(empresaB);
            buscadorPrecio.agregarProveedor(empresaC);
            
            List<Producto> resultados = buscadorPrecio.buscarOrdenadoPorPrecio();
            resultados.forEach(p -> System.out.println("  €" + p.getPrecio() + " - " + p.getNombre() + " (" + p.getTipo() + ")"));
            
        } else if (opcion == 2) {
            // Abstracción de Stock configurada con todos los proveedores
            BuscadorStockSofasYMesas buscadorStock = new BuscadorStockSofasYMesas(empresaA);
            buscadorStock.agregarProveedor(empresaB);
            buscadorStock.agregarProveedor(empresaC);
            
            List<Producto> resultados = buscadorStock.buscarOrdenadoPorStock();
            resultados.forEach(p -> System.out.println("  Stock: " + p.getUnidades() + " - " + p.getNombre()));
            
        } else {
            System.out.println("Opción no válida.");
        }

        sc.close();
    }
}
