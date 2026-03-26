package Adaptadores;

import java.time.LocalDate;
import java.util.List;

import Buscadores.BuscarAct;
import Clases.Actividad;
import Oficinas.OficinaTurismoSevilla;

// Adaptador: normaliza la API de Sevilla para que el facade use siempre BuscarAct.
public class AdaptadorTurismoSevilla implements BuscarAct {

    private OficinaTurismoSevilla oficina;

    public AdaptadorTurismoSevilla(OficinaTurismoSevilla oficina) {
        this.oficina = oficina;
    }

    @Override
    public List<Actividad> buscar(LocalDate inicio, LocalDate fin, int personas) {
        return oficina.buscarPorFecha(inicio, fin, personas);
    }
}
