package Sistemas;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Buscadores.BuscarTrans;
import Clases.Transporte;

// Ejemplo proveedor de trenes.
public class SistemaTransporteTrenes implements BuscarTrans {

    private List<Transporte> catalogo;

    public SistemaTransporteTrenes() {
        this.catalogo = new ArrayList<>();
        cargarCatalogo();
    }

    // Ejemplo de trenes
    private void cargarCatalogo() {
        catalogo.add(new Transporte("Renfe", "Valencia", "Madrid", LocalDate.of(2026, 5, 10), LocalDate.of(2026, 5, 10), 25));
        catalogo.add(new Transporte("Renfe", "Madrid", "Sevilla", LocalDate.of(2026, 6, 20), LocalDate.of(2026, 6, 20), 20));
    }

    @Override
    public List<Transporte> buscar(String ciudadOrigen, String ciudadDestino, LocalDate inicio, LocalDate fin, int personas) {
        List<Transporte> resultado = new ArrayList<>();

        for (Transporte t : catalogo) { //busqueda que coincida
            boolean rutaOk = t.getCiudadOrigen().equalsIgnoreCase(ciudadOrigen) && t.getCiudadDestino().equalsIgnoreCase(ciudadDestino); //equalsIgnoreCas() lo que hace es comparar el array entero y comprobar que sea le mismo
            boolean fechaOk = !t.getFechaSalida().isBefore(inicio) && !t.getFechaSalida().isAfter(fin);
            boolean plazasOk = t.getPlazas() >= personas;
            
            if (rutaOk && fechaOk && plazasOk) {
                resultado.add(t);
            }
        }
        return resultado;
    }
}