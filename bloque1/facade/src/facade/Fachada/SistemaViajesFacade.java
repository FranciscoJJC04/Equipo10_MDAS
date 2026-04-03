package Fachada;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Buscadores.BuscarAct;
import Buscadores.BuscarAloj;
import Buscadores.BuscarTrans;
import Clases.Actividad;
import Clases.Alojamiento;
import Clases.Transporte;
import Sistemas.SistemaAlojamientoApartamentos;
import Sistemas.SistemaAlojamientoHotel;
import Sistemas.SistemaTransporteTrenes;
import Sistemas.SistemaTransporteVuelos;

// Facade: expone una operacion simple y coordina varios subsistemas.
public class SistemaViajesFacade {

    private List<BuscarTrans> buscadoresTransporte;
    private List<BuscarAloj> buscadoresAlojamiento;
    private RegistroOficinasTurismo registroOficinas;

    public SistemaViajesFacade() {
        buscadoresTransporte = new ArrayList<>();
        buscadoresAlojamiento = new ArrayList<>();
        registroOficinas = new RegistroOficinasTurismo();

        // Subsistemas de TASNPORTE disponibles.
        buscadoresTransporte.add(new SistemaTransporteVuelos());
        buscadoresTransporte.add(new SistemaTransporteTrenes());

        // Subsistemas de ALOJAMIENTO disponibles.
        buscadoresAlojamiento.add(new SistemaAlojamientoHotel());
        buscadoresAlojamiento.add(new SistemaAlojamientoApartamentos());
    }

    public ResultadoViaje buscarViaje(LocalDate inicio, LocalDate fin, String origen, String destino, int personas) {
        // La fachada valida parametros y oculta esta logica al cliente.
        validarEntrada(inicio, fin, origen, destino, personas);

        // Delega en todos los sistemas de transporte.
        List<Transporte> transportes = new ArrayList<>();
        for (BuscarTrans buscador : buscadoresTransporte) {
            transportes.addAll(buscador.buscar(origen, destino, inicio, fin, personas));
        }

        // Delega en todos los sistemas de alojamiento.
        List<Alojamiento> alojamientos = new ArrayList<>();
        for (BuscarAloj buscador : buscadoresAlojamiento) {
            alojamientos.addAll(buscador.buscar(destino, inicio, fin, personas));
        }

        // Localiza la oficina de turismo de destino y consulta actividades.
        List<Actividad> actividades = new ArrayList<>();
        BuscarAct oficina = registroOficinas.obtenerPorCiudad(destino);
        if (oficina != null) {
            actividades = oficina.buscar(inicio, fin, personas);
        }

        // Devuelve un resultado unificado para el cliente.
        return new ResultadoViaje(transportes, alojamientos, actividades);
    }

    private void validarEntrada(LocalDate inicio, LocalDate fin, String origen, String destino, int personas) {
        if (inicio == null || fin == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas");
        }
        if (inicio.isAfter(fin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha fin");
        }
        if (origen == null || origen.isBlank() || destino == null || destino.isBlank()) {
            throw new IllegalArgumentException("Origen y destino son obligatorios");
        }
        if (personas <= 0) {
            throw new IllegalArgumentException("El numero de personas debe ser mayor que 0"); //IllegalArgumentException es una excepcion no verificada que no obliga a capturarla o declararla (cositas eh ;) ).
        }
    }
}
