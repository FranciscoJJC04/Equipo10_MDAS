package Sistemas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Buscadores.BuscarTrans;
import Clases.Transporte;

// Ejemplo proveedor de vuelos.
public class SistemaTransporteVuelos implements BuscarTrans {

    private List<Transporte> catalogo;

    public SistemaTransporteVuelos() {
        this.catalogo = new ArrayList<>();
        cargarCatalogo();
    }

    // Ejemplo de vuelos
    private void cargarCatalogo() {
        catalogo.add(new Transporte("Iberia", "Valencia", "Madrid", LocalDate.of(2026, 5, 10), LocalDate.of(2026, 5, 10), 40));
        catalogo.add(new Transporte("Air Europa", "Barcelona", "Sevilla", LocalDate.of(2026, 6, 15), LocalDate.of(2026, 6, 15), 35));
    }

    @Override
    public List<Transporte> buscar(String ciudadOrigen, String ciudadDestino, LocalDate inicio, LocalDate fin, int personas) {
        List<Transporte> resultado = new ArrayList<>();

        for (Transporte t : catalogo) { //busqueda que coincida
            boolean rutaOk = t.getCiudadOrigen().equalsIgnoreCase(ciudadOrigen) && t.getCiudadDestino().equalsIgnoreCase(ciudadDestino); //equalsIgnoreCas() ya lo expliqué en sistema de trenes chu chu chulis
            boolean fechaOk = !t.getFechaSalida().isBefore(inicio) && !t.getFechaSalida().isAfter(fin);
            boolean plazasOk = t.getPlazas() >= personas;

            if (rutaOk && fechaOk && plazasOk) {
                resultado.add(t);
            }
        }
        return resultado;
    }
}