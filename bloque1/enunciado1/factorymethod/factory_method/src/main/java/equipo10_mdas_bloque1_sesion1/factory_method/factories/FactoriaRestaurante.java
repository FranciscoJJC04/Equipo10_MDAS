package equipo10_mdas_bloque1_sesion1.factory_method.factories;
import java.awt.Menu;

import equipo10_mdas_bloque1_sesion1.factory_method.Plato;
import equipo10_mdas_bloque1_sesion1.factory_method.TipoAcompanamiento;
import equipo10_mdas_bloque1_sesion1.factory_method.TipoPlato;
import equipo10_mdas_bloque1_sesion1.factory_method.menus.MenuSemanal;
import equipo10_mdas_bloque1_sesion1.factory_method.menus.MenuTemporada;


    public class FactoriaRestaurante implements  Factoria{
    @Override
    public MenuSemanal crearMenuSemanal(TipoAcompanamiento acompanamiento){
        Plato principal=new Plato("Carne", 8.99f, TipoPlato.PRINCIPAL, TipoAcompanamiento.PATATAS );
        principal.setAcompanamiento(acompanamiento);
        
        MenuSemanal menusemanal=new MenuSemanal();
        menusemanal.asignarPlato(principal);
        return menusemanal;
    }

    @Override
    public MenuTemporada crearMenuTemporada(TipoAcompanamiento acompanamiento){
        Plato principal=new Plato("Carne", 8.99f, TipoPlato.PRINCIPAL, TipoAcompanamiento.PATATAS );
        principal.setAcompanamiento(acompanamiento);

        MenuTemporada menutemporada=new MenuTemporada();
        menutemporada.asignarPlato(principal);

        return menutemporada;
    }
}

