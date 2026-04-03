import java.util.*;

public class MenuBuscador {
    private static Sofas empresaA_Sofas;
    private static Mesas empresaB_Mesas;
    private static SofasYMesas empresaC_SofasYMesas;
    private static Scanner scanner;

    public static void main(String[] args) {
        inicializarProveedores();
        mostrarMenuPrincipal();
    }

    private static void inicializarProveedores() {
        // Crear proveedores
        empresaA_Sofas = new Sofas("Empresa A");
        empresaB_Mesas = new Mesas("Empresa B");
        empresaC_SofasYMesas = new SofasYMesas("Empresa C");

        // Agregar productos a Empresa A (solo sofás)
        empresaA_Sofas.agregarProducto(new Producto("Sofá Moderno", 450.00, 5, "Sofa"));
        empresaA_Sofas.agregarProducto(new Producto("Sofá Clásico", 350.00, 3, "Sofa"));
        empresaA_Sofas.agregarProducto(new Producto("Sofá Reina", 650.00, 2, "Sofa"));

        // Agregar productos a Empresa B (solo mesas)
        empresaB_Mesas.agregarProducto(new Producto("Mesa Comedor", 200.00, 8, "Mesa"));
        empresaB_Mesas.agregarProducto(new Producto("Mesa Madera", 300.00, 4, "Mesa"));
        empresaB_Mesas.agregarProducto(new Producto("Mesa Vidrio", 250.00, 6, "Mesa"));

        // Agregar productos a Empresa C (sofás y mesas)
        empresaC_SofasYMesas.agregarProducto(new Producto("Sofá Moderno", 420.00, 4, "Sofa"));
        empresaC_SofasYMesas.agregarProducto(new Producto("Mesa Comedor", 180.00, 10, "Mesa"));
        empresaC_SofasYMesas.agregarProducto(new Producto("Sofá Premium", 700.00, 1, "Sofa"));

        scanner = new Scanner(System.in);
    }

    private static void mostrarMenuPrincipal() {
        boolean continuar = true;
        while (continuar) {
            limpiarPantalla();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║     SISTEMA DE BÚSQUEDA DE MUEBLES - PATRÓN BRIDGE            ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
            System.out.println("Selecciona el tipo de búsqueda:\n");
            System.out.println("  [1] Búsqueda ordenada por PRECIO (menor a mayor)");
            System.out.println("  [2] Búsqueda ordenada por STOCK (mayor a menor)");
            System.out.println("  [0] Salir\n");
            System.out.print("Ingresa tu opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                switch (opcion) {
                    case 1:
                        menuBusquedaPorPrecio();
                        break;
                    case 2:
                        menuBusquedaPorStock();
                        break;
                    case 0:
                        continuar = false;
                        System.out.println("\n¡Hasta luego!\n");
                        break;
                    default:
                        System.out.println("\n❌ Opción no válida. Por favor, intenta de nuevo.");
                        scanner.nextLine();
                        pausa();
                }
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Error: Debes ingresar un número.");
                scanner.nextLine();
                pausa();
            }
        }
        scanner.close();
    }

    private static void menuBusquedaPorPrecio() {
        boolean volver = false;
        while (!volver) {
            limpiarPantalla();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║     BÚSQUEDA ORDENADA POR PRECIO (Menor a Mayor)             ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
            System.out.println("Selecciona el tipo de producto:\n");
            System.out.println("  [1] Sofás (Empresa A + Empresa C)");
            System.out.println("  [2] Mesas (Empresa B + Empresa C)");
            System.out.println("  [3] Todos los productos");
            System.out.println("  [0] Volver al menú principal\n");
            System.out.print("Ingresa tu opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        mostrarBusquedaPrecioSofas();
                        break;
                    case 2:
                        mostrarBusquedaPrecioMesas();
                        break;
                    case 3:
                        mostrarBusquedaPrecioTodos();
                        break;
                    case 0:
                        volver = true;
                        break;
                    default:
                        System.out.println("\n❌ Opción no válida.");
                        pausa();
                }
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Error: Debes ingresar un número.");
                scanner.nextLine();
                pausa();
            }
        }
    }

    private static void menuBusquedaPorStock() {
        boolean volver = false;
        while (!volver) {
            limpiarPantalla();
            System.out.println("╔═══════════════════════════════════════════════════════════════╗");
            System.out.println("║     BÚSQUEDA ORDENADA POR STOCK (Mayor a Menor)              ║");
            System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");
            System.out.println("Selecciona el tipo de producto:\n");
            System.out.println("  [1] Sofás (Empresa A + Empresa C)");
            System.out.println("  [2] Mesas (Empresa B + Empresa C)");
            System.out.println("  [3] Todos los productos");
            System.out.println("  [0] Volver al menú principal\n");
            System.out.print("Ingresa tu opción: ");

            try {
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        mostrarBusquedaStockSofas();
                        break;
                    case 2:
                        mostrarBusquedaStockMesas();
                        break;
                    case 3:
                        mostrarBusquedaStockTodos();
                        break;
                    case 0:
                        volver = true;
                        break;
                    default:
                        System.out.println("\n❌ Opción no válida.");
                        pausa();
                }
            } catch (InputMismatchException e) {
                System.out.println("\n❌ Error: Debes ingresar un número.");
                scanner.nextLine();
                pausa();
            }
        }
    }

    // ============ BÚSQUEDAS POR PRECIO ============
    private static void mostrarBusquedaPrecioSofas() {
        limpiarPantalla();
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("SOFÁS - Ordenados por Precio (Menor a Mayor)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        BuscadorPrecioSofasYMesas buscador = new BuscadorPrecioSofasYMesas(empresaA_Sofas, "Sofa");
        buscador.agregarProveedor(empresaC_SofasYMesas);

        List<Producto> resultados = buscador.buscarOrdenadoPorPrecio();
        if (resultados.isEmpty()) {
            System.out.println("No hay sofás disponibles.");
        } else {
            resultados.forEach(p -> System.out.println("  ✓ " + p));
        }
        pausa();
    }

    private static void mostrarBusquedaPrecioMesas() {
        limpiarPantalla();
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("MESAS - Ordenadas por Precio (Menor a Mayor)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        BuscadorPrecioSofasYMesas buscador = new BuscadorPrecioSofasYMesas(empresaB_Mesas, "Mesa");
        buscador.agregarProveedor(empresaC_SofasYMesas);

        List<Producto> resultados = buscador.buscarOrdenadoPorPrecio();
        if (resultados.isEmpty()) {
            System.out.println("No hay mesas disponibles.");
        } else {
            resultados.forEach(p -> System.out.println("  ✓ " + p));
        }
        pausa();
    }

    private static void mostrarBusquedaPrecioTodos() {
        limpiarPantalla();
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("TODOS LOS PRODUCTOS - Ordenados por Precio (Menor a Mayor)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        BuscadorPrecioSofasYMesas buscador = new BuscadorPrecioSofasYMesas(empresaA_Sofas);
        buscador.agregarProveedor(empresaB_Mesas);
        buscador.agregarProveedor(empresaC_SofasYMesas);

        List<Producto> resultados = buscador.buscarOrdenadoPorPrecio();
        if (resultados.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            resultados.forEach(p -> System.out.println("  ✓ " + p));
        }
        pausa();
    }

    // ============ BÚSQUEDAS POR STOCK ============
    private static void mostrarBusquedaStockSofas() {
        limpiarPantalla();
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("SOFÁS - Ordenados por Stock (Mayor a Menor)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        BuscadorStockSofasYMesas buscador = new BuscadorStockSofasYMesas(empresaA_Sofas, "Sofa");
        buscador.agregarProveedor(empresaC_SofasYMesas);

        List<Producto> resultados = buscador.buscarOrdenadoPorStock();
        if (resultados.isEmpty()) {
            System.out.println("No hay sofás disponibles.");
        } else {
            resultados.forEach(p -> System.out.println("  ✓ " + p));
        }
        pausa();
    }

    private static void mostrarBusquedaStockMesas() {
        limpiarPantalla();
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("MESAS - Ordenadas por Stock (Mayor a Menor)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        BuscadorStockSofasYMesas buscador = new BuscadorStockSofasYMesas(empresaB_Mesas, "Mesa");
        buscador.agregarProveedor(empresaC_SofasYMesas);

        List<Producto> resultados = buscador.buscarOrdenadoPorStock();
        if (resultados.isEmpty()) {
            System.out.println("No hay mesas disponibles.");
        } else {
            resultados.forEach(p -> System.out.println("  ✓ " + p));
        }
        pausa();
    }

    private static void mostrarBusquedaStockTodos() {
        limpiarPantalla();
        System.out.println("═══════════════════════════════════════════════════════════════");
        System.out.println("TODOS LOS PRODUCTOS - Ordenados por Stock (Mayor a Menor)");
        System.out.println("═══════════════════════════════════════════════════════════════\n");

        BuscadorStockSofasYMesas buscador = new BuscadorStockSofasYMesas(empresaA_Sofas);
        buscador.agregarProveedor(empresaB_Mesas);
        buscador.agregarProveedor(empresaC_SofasYMesas);

        List<Producto> resultados = buscador.buscarOrdenadoPorStock();
        if (resultados.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            resultados.forEach(p -> System.out.println("  ✓ " + p));
        }
        pausa();
    }

    private static void pausa() {
        System.out.print("\nPresiona ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
