package Buscadores;

import java.time.LocalDate;
import java.util.List;

import Clases.Actividad;

// Interfaz comun para buscar actividades, sin importar la oficina concreta.
public interface BuscarAct {
    // Devuelve actividades que encajan por fecha y tamano de grupo.
    List<Actividad> buscar(LocalDate inicio, LocalDate fin, int personas);
}
