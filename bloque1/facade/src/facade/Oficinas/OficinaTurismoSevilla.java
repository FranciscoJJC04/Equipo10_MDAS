package Oficinas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Clases.Actividad;

// Ejemplo de oficina de turismo de Sevilla, con su propia API y catalogo de actividades.
public class OficinaTurismoSevilla {

    private List<Actividad> catalogo;

    public OficinaTurismoSevilla() {
        this.catalogo = new ArrayList<>();
        cargarCatalogo();
    }

    // Ejemplo de actividades de la oficina
    private void cargarCatalogo() {
        catalogo.add(new Actividad("Visita Alcazar", "Sevilla", "cultural", LocalDate.of(2026, 6, 16), 50));
        catalogo.add(new Actividad("Espectaculo flamenco", "Sevilla", "cultural", LocalDate.of(2026, 6, 17), 40));
    }

    // API especifica de esta oficina: solo filtra por fecha.
    public List<Actividad> buscarPorFecha(LocalDate inicio, LocalDate fin, int personas) {
        List<Actividad> resultado = new ArrayList<>();
        for (Actividad a : catalogo) {
            boolean fechaOk = !a.getFechaActividad().isBefore(inicio) && !a.getFechaActividad().isAfter(fin);
            boolean plazasOk = a.getNPersonas() >= personas;
            if (fechaOk && plazasOk) {
                resultado.add(a);
            }
        }
        return resultado;
    }
}
