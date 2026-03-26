package Buscadores;
import java.util.List;

import Clases.Alojamiento;

import java.time.LocalDate;

// Interfaz comun para sistemas que buscan alojamientos.
public interface BuscarAloj {
     // Busca alojamientos por ciudad destino, fechas y numero de personas.
     List<Alojamiento> buscar(String ciudadDestino, LocalDate inicio, LocalDate fin, int personas);
}
