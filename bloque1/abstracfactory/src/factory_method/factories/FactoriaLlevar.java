package factory_method.factories;
import factory_method.Plato;
import factory_method.TipoAcompanamiento;
import factory_method.TipoPlato;
import factory_method.menus.MenuSemanal;
import factory_method.menus.MenuTemporada;

public class FactoriaLlevar implements Factoria {


    @Override
    public MenuSemanal crearMenuSemanal(TipoAcompanamiento acompanamiento) {
        Plato entrante  = new Plato("Patatas",         8.99f * 1.02f, TipoPlato.ENTRANTE,  TipoAcompanamiento.SIN_ACOMPANAMIENTO);
        Plato principal = new Plato("Calentito-Kebab",  8.99f * 1.02f, TipoPlato.PRINCIPAL, TipoAcompanamiento.ENSALADA);

        entrante.setAcompanamiento(acompanamiento);
        principal.setAcompanamiento(acompanamiento);

        MenuSemanal menusemanal = new MenuSemanal();
        menusemanal.asignarPlato(entrante);
        menusemanal.asignarPlato(principal);
        return menusemanal;
    }

    @Override
    public MenuTemporada crearMenuTemporada(TipoAcompanamiento acompanamiento) {
        MenuTemporada menutemporada = new MenuTemporada();
        Plato unico = new Plato("Bocadillo especial", 8.99f * 1.02f, TipoPlato.PRINCIPAL, acompanamiento);
        menutemporada.asignarPlato(unico);
        return menutemporada;
    }
}

