package factory_method.factories;
import factory_method.Plato;
import factory_method.TipoAcompanamiento;
import factory_method.TipoPlato;
import factory_method.menus.MenuSemanal;
import factory_method.menus.MenuTemporada;


// Creator concreto: crea menús con PRECIO BASE (sin recargo, consumo en restaurante).
public class FactoriaRestaurante implements Factoria {

    @Override
    public MenuSemanal crearMenuSemanal(TipoAcompanamiento acompanamiento) {
        Plato entrante  = new Plato("Patatas",        8.99f, TipoPlato.ENTRANTE,  TipoAcompanamiento.SIN_ACOMPANAMIENTO);
        Plato principal = new Plato("Calentito-Kebab", 8.99f, TipoPlato.PRINCIPAL, TipoAcompanamiento.ENSALADA);
        Plato postre    = new Plato("Palmerita",       8.99f, TipoPlato.POSTRE,    TipoAcompanamiento.SIN_ACOMPANAMIENTO);

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
        MenuTemporada menutemporada = new MenuTemporada();
        Plato unico = new Plato("Bocadillo especial", 8.99f, TipoPlato.PRINCIPAL, acompanamiento);
        menutemporada.asignarPlato(unico);
        return menutemporada;
    }
}

