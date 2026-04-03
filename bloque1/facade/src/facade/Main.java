import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import Fachada.ResultadoViaje;
import Fachada.SistemaViajesFacade;

// Cliente: solo conoce la fachada y no invoca subsistemas directamente.
public class Main {

    public static void main(String[] args) {
        // Se crea una unica puerta de entrada al sistema (Facade).
        SistemaViajesFacade facade = new SistemaViajesFacade();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== BUSCADOR DE VIAJES (PATRON FACADE) ===");
        System.out.println("Formato de fecha obligatorio: AAAA-MM-DD");

        boolean continuar = true;
        while (continuar) {
            try {
                // Datos minimos que pide el enunciado para buscar un viaje de grupo.
                System.out.print("\nIntroduce fecha de inicio (AAAA-MM-DD): ");
                LocalDate inicio = LocalDate.parse(scanner.nextLine().trim());

                System.out.print("Introduce fecha de fin (AAAA-MM-DD): ");
                LocalDate fin = LocalDate.parse(scanner.nextLine().trim());

                System.out.print("Introduce ciudad de origen: ");
                String origen = scanner.nextLine().trim();

                System.out.print("Introduce ciudad de destino: ");
                String destino = scanner.nextLine().trim();

                System.out.print("Introduce numero de personas: ");
                int personas = Integer.parseInt(scanner.nextLine().trim());

                // Una sola llamada a la fachada sustituye llamadas manuales a subsistemas.
                ResultadoViaje resultado = facade.buscarViaje(inicio, fin, origen, destino, personas);
                System.out.println("\n=== RESULTADO DE LA BUSQUEDA ===");
                System.out.println("Transportes encontrados: " + resultado.getTransportes().size());
                for (Clases.Transporte t : resultado.getTransportes()) {
                    System.out.println(" - " + t.getProveedor() + " | " + t.getCiudadOrigen() + " -> " + t.getCiudadDestino()
                            + " | " + t.getFechaSalida() + " | plazas: " + t.getPlazas());
                }

                System.out.println("Alojamientos encontrados: " + resultado.getAlojamientos().size());
                for (Clases.Alojamiento a : resultado.getAlojamientos()) {
                    System.out.println(" - " + a.getNombre() + " | " + a.getCiudad() + " | "
                            + a.getFechaEntrada() + " a " + a.getFechaSalida() + " | plazas: " + a.getPlazas());
                }

                System.out.println("Actividades encontradas: " + resultado.getActividades().size());
                for (Clases.Actividad a : resultado.getActividades()) {
                    System.out.println(" - " + a.getActividadflipante() + " | " + a.getCiudad() + " | "
                            + a.getFechaActividad() + " | tipo: " + a.getTipo());
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: la fecha debe tener formato AAAA-MM-DD.");
            } catch (NumberFormatException e) {
                System.out.println("Error: el numero de personas debe ser un entero valido.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error de validacion: " + e.getMessage());
            }

            // Permite probar facilmente varios casos en una misma ejecucion.
            System.out.print("\nQuieres hacer otra busqueda? (s/n): ");
            String respuesta = scanner.nextLine().trim();
            continuar = respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("si");
        }

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
