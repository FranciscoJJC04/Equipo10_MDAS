package Buscadores;
import java.util.List;

import Clases.Transporte;

import java.time.LocalDate;

// interfaz comun para sistemas que ofrecen transporte.
public interface BuscarTrans {
    // Busca opciones por origen, destino, fechas y tamano del grupo.
    List<Transporte> buscar(String ciudadOrigen, String ciudadDestino, LocalDate inicio, LocalDate fin, int personas);
}
