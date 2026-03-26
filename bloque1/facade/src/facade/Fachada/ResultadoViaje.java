package Fachada;

import java.util.List;

import Clases.Actividad;
import Clases.Alojamiento;
import Clases.Transporte;

// Objeto de salida: agrupa en una sola respuesta todo lo encontrado por la fachada.
public class ResultadoViaje {
    private List<Transporte> transportes;
    private List<Alojamiento> alojamientos;
    private List<Actividad> actividades;

    public ResultadoViaje(List<Transporte> transportes, List<Alojamiento> alojamientos, List<Actividad> actividades) {
        this.transportes = transportes;
        this.alojamientos = alojamientos;
        this.actividades = actividades;
    }

    // Getters para que el cliente imprima cada bloque de resultados.
    public List<Transporte> getTransportes() {
        return transportes;
    }

    public List<Alojamiento> getAlojamientos() {
        return alojamientos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}
