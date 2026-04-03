package bridge_modular.app;

import java.util.List;
import java.util.Scanner;

import bridge_modular.buscadores.BuscadorPrecioSofasYMesas;
import bridge_modular.buscadores.BuscadorStockSofasYMesas;
import bridge_modular.modelo.Producto;
import bridge_modular.proveedores.Mesas;
import bridge_modular.proveedores.Sofas;
import bridge_modular.proveedores.SofasYMesas;

public class BuscadorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Sofas empresaA = new Sofas("Empresa A");
        Mesas empresaB = new Mesas("Empresa B");
        SofasYMesas empresaC = new SofasYMesas("Empresa C");

        empresaA.agregarProducto(new Producto("Sofa Moderno", 450.00, 5, "Sofa"));
        empresaA.agregarProducto(new Producto("Sofa Clasico", 350.00, 3, "Sofa"));
        empresaA.agregarProducto(new Producto("Sofa Reina", 650.00, 2, "Sofa"));

        empresaB.agregarProducto(new Producto("Mesa Comedor", 200.00, 8, "Mesa"));
        empresaB.agregarProducto(new Producto("Mesa Madera", 300.00, 4, "Mesa"));
        empresaB.agregarProducto(new Producto("Mesa Vidrio", 250.00, 6, "Mesa"));

        empresaC.agregarProducto(new Producto("Sofa Moderno", 420.00, 4, "Sofa"));
        empresaC.agregarProducto(new Producto("Mesa Comedor", 180.00, 10, "Mesa"));
        empresaC.agregarProducto(new Producto("Sofa Premium", 700.00, 1, "Sofa"));

        System.out.println("Seleccione el metodo de busqueda para todo el catalogo:");
        System.out.println("1. Ordenar por PRECIO (Menor a Mayor)");
        System.out.println("2. Ordenar por STOCK (Mayor a Menor - Unidades Agregadas)");
        System.out.print("\nOpcion: ");

        int opcion = scanner.nextInt();

        System.out.println("\n--- RESULTADOS DEL CATALOGO COMPLETO (A + B + C) ---");

        if (opcion == 1) {
            BuscadorPrecioSofasYMesas buscadorPrecio = new BuscadorPrecioSofasYMesas(empresaA);
            buscadorPrecio.agregarProveedor(empresaB);
            buscadorPrecio.agregarProveedor(empresaC);

            List<Producto> resultados = buscadorPrecio.buscarOrdenadoPorPrecio();
            resultados.forEach(producto -> System.out.println("  EUR " + producto.getPrecio() + " - " + producto.getNombre() + " (" + producto.getTipo() + ")"));
        } else if (opcion == 2) {
            BuscadorStockSofasYMesas buscadorStock = new BuscadorStockSofasYMesas(empresaA);
            buscadorStock.agregarProveedor(empresaB);
            buscadorStock.agregarProveedor(empresaC);

            List<Producto> resultados = buscadorStock.buscarOrdenadoPorStock();
            resultados.forEach(producto -> System.out.println("  Stock: " + producto.getUnidades() + " - " + producto.getNombre()));
        } else {
            System.out.println("Opcion no valida.");
        }

        scanner.close();
    }
}
