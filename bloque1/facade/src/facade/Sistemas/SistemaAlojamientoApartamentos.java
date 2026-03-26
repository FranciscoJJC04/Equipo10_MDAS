package Sistemas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Buscadores.BuscarAloj;
import Clases.Alojamiento;

// Ejemplo proveedor de apartamentos.
public class SistemaAlojamientoApartamentos implements BuscarAloj {

    private List<Alojamiento> catalogo;

    public SistemaAlojamientoApartamentos() {
        this.catalogo = new ArrayList<>();
        cargarCatalogo();
    }

    // Ejemplo de hoteles
    private void cargarCatalogo() {
        catalogo.add(new Alojamiento("Apartamentos Alameda", "Sevilla", LocalDate.of(2026, 1, 1), LocalDate.of(2026, 12, 31), 12));
        catalogo.add(new Alojamiento("Apartamentos Prado", "Madrid", LocalDate.of(2026, 2, 1), LocalDate.of(2026, 11, 30), 8));
    }

    @Override
    public List<Alojamiento> buscar(String ciudadDestino, LocalDate inicio, LocalDate fin, int personas) {
        List<Alojamiento> resultado = new ArrayList<>();

        for (Alojamiento a : catalogo) { //busqueda que coicnida 
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