package equipo10_mdas_bloque1_sesion1.factory_method.factories;
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
        return new MenuSemanal();
    }

    @Override
    public MenuTemporada crearMenuTemporada(TipoAcompanamiento acompanamiento){
        Plato principal=new Plato("Carne", 8.99f, TipoPlato.PRINCIPAL, TipoAcompanamiento.PATATAS );
        principal.setAcompanamiento(acompanamiento);
        return new MenuTemporada();
    }
}

