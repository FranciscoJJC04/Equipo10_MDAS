package equipo10_mdas_bloque1_sesion1.factory_method.factories;
import equipo10_mdas_bloque1_sesion1.factory_method.Plato;
import equipo10_mdas_bloque1_sesion1.factory_method.TipoAcompanamiento;
import equipo10_mdas_bloque1_sesion1.factory_method.TipoPlato;
import equipo10_mdas_bloque1_sesion1.factory_method.menus.MenuSemanal;
import equipo10_mdas_bloque1_sesion1.factory_method.menus.MenuTemporada;

public class FactoriaLlevar implements Factoria {


    @Override
    public MenuSemanal crearMenuSemanal(TipoAcompanamiento acompanamiento) {
        Plato entrante  = new Plato("Patatas",         8.99f * 1.02f, TipoPlato.ENTRANTE,  TipoAcompanamiento.SIN_ACOMPANAMIENTO);
        Plato principal = new Plato("Calentito-Kebab",  8.99f * 1.02f, TipoPlato.PRINCIPAL, TipoAcompanamiento.ENSALADA);
        Plato postre    = new Plato("Palmerita",        8.99f * 1.02f, TipoPlato.POSTRE,    TipoAcompanamiento.SIN_ACOMPANAMIENTO);

        entrante.setAcompanamiento(acompanamiento);
        principal.setAcompanamiento(acompanamiento);
        postre.setAcompanamiento(acompanamiento);

        MenuSemanal menusemanal = new MenuSemanal();
        menusemanal.asignarPlato(entrante);
        menusemanal.asignarPlato(principal);
        menusemanal.asignarPlato(postre);
        return menusemanal;
    }

    @Override
    public MenuTemporada crearMenuTemporada(TipoAcompanamiento acompanamiento) {
        Plato entrante  = new Plato("Patatas-Foster", 8.99f * 1.02f, TipoPlato.ENTRANTE,  TipoAcompanamiento.SIN_ACOMPANAMIENTO);
        Plato principal = new Plato("Bocadillo",      8.99f * 1.02f, TipoPlato.PRINCIPAL, TipoAcompanamiento.ENSALADA);
        Plato postre    = new Plato("Donetes",        8.99f * 1.02f, TipoPlato.POSTRE,    TipoAcompanamiento.SIN_ACOMPANAMIENTO);

        entrante.setAcompanamiento(acompanamiento);
        principal.setAcompanamiento(acompanamiento);
        postre.setAcompanamiento(acompanamiento);

        MenuTemporada menutemporada = new MenuTemporada();
        menutemporada.asignarPlato(entrante);
        menutemporada.asignarPlato(principal);
        menutemporada.asignarPlato(postre);
        return menutemporada;
    }
}

