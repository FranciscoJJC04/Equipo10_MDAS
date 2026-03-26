package Oficinas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Clases.Actividad;

// Ejemplo de oficina de turismo de Madrid, con su propia API y catalogo de actividades.
public class OficinaTurismoMadrid {

    private List<Actividad> catalogo;

    public OficinaTurismoMadrid() {
        this.catalogo = new ArrayList<>();
        cargarCatalogo();
    }

    // Ejemplo de actividades de la oficina.
    private void cargarCatalogo() {
        catalogo.add(new Actividad("Museo del Prado", "Madrid", "cultural", LocalDate.of(2026, 5, 11), 100));
        catalogo.add(new Actividad("Teatro Real", "Madrid", "cultural", LocalDate.of(2026, 5, 12), 60));
        catalogo.add(new Actividad("Ruta gastronomica", "Madrid", "gastronomia", LocalDate.of(2026, 5, 12), 20));
    }

    // API especifica de esta oficina: filtra por tipo y por fecha.
    public List<Actividad> buscarPorTipoYFecha(String tipo, LocalDate inicio, LocalDate fin, int personas) {
        List<Actividad> resultado = new ArrayList<>();
        for (Actividad a : catalogo) {
            boolean tipoOk = a.getTipo().equalsIgnoreCase(tipo);
            boolean fechaOk = !a.getFechaActividad().isBefore(inicio) && !a.getFechaActividad().isAfter(fin);
            boolean plazasOk = a.getNPersonas() >= personas;
            if (tipoOk && fechaOk && plazasOk) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}
