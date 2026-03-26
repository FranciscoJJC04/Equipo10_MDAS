package Fachada;

import java.util.HashMap;
import java.util.Map;

import Adaptadores.AdaptadorTurismoMadrid;
import Adaptadores.AdaptadorTurismoSevilla;
import Buscadores.BuscarAct;
import Oficinas.OficinaTurismoMadrid;
import Oficinas.OficinaTurismoSevilla;

// Registro/lokup de oficinas para que la fachada no conozca detalles de creacion.
public class RegistroOficinasTurismo {

    private Map<String, BuscarAct> oficinas;

    public RegistroOficinasTurismo() {
        this.oficinas = new HashMap<>(); //guardamos pares clave valor donde la clave es el nombre de la ciudad y el valor es el adaptador que implementa BuscarAct para esa ciudad
        inicializar();
    }

    private void inicializar() {
        // Cada ciudad se asocia a un adaptador con interfaz comun.
        oficinas.put("madrid", new AdaptadorTurismoMadrid(new OficinaTurismoMadrid()));
        oficinas.put("sevilla", new AdaptadorTurismoSevilla(new OficinaTurismoSevilla()));
    }

    public BuscarAct obtenerPorCiudad(String ciudadDestino) {
        if (ciudadDestino == null) {
            return null;
        }
        return oficinas.get(ciudadDestino.toLowerCase());
    }
}
