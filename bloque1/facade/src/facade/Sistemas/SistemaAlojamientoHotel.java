package Sistemas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Buscadores.BuscarAloj;
import Clases.Alojamiento;

// Ejemplo proveedor de hoteles.
public class SistemaAlojamientoHotel implements BuscarAloj {

    private List<Alojamiento> catalogo;

    public SistemaAlojamientoHotel() {
        this.catalogo = new ArrayList<>();
        cargarCatalogo();
    }

    // Ejemplo de hoteles
    private void cargarCatalogo() {
        catalogo.add(new Alojamiento("Hotel Centro", "Madrid", LocalDate.of(2026, 4, 1), LocalDate.of(2026, 12, 31), 50));
        catalogo.add(new Alojamiento("Hotel Sol", "Sevilla", LocalDate.of(2026, 3, 1), LocalDate.of(2026, 10, 31), 30));
    }

    @Override
    public List<Alojamiento> buscar(String ciudadDestino, LocalDate inicio, LocalDate fin, int personas) {
        List<Alojamiento> resultado = new ArrayList<>();

        for (Alojamiento a : catalogo) { //busqueda que coincida
            boolean ciudadOk = a.getCiudad().equalsIgnoreCase(ciudadDestino);
            boolean fechasOk = !inicio.isBefore(a.getFechaInicioDisponible()) && !fin.isAfter(a.getFechaFinDisponible());
            boolean plazasOk = a.getPlazas() >= personas;
            
            if (ciudadOk && fechasOk && plazasOk) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}