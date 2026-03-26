package Adaptadores;

import java.time.LocalDate;
import java.util.List;

import Buscadores.BuscarAct;
import Clases.Actividad;
import Oficinas.OficinaTurismoMadrid;

// Adaptador: convierte la API especifica de Madrid a la interfaz BuscarAct.
public class AdaptadorTurismoMadrid implements BuscarAct {

    private OficinaTurismoMadrid oficina;

    public AdaptadorTurismoMadrid(OficinaTurismoMadrid oficina) {
        this.oficina = oficina;
    }

    @Override
    public List<Actividad> buscar(LocalDate inicio, LocalDate fin, int personas) {
        // Regla de negocio elegida: para Madrid se filtran actividades culturales.
        return oficina.buscarPorTipoYFecha("cultural", inicio, fin, personas);
    }
}
