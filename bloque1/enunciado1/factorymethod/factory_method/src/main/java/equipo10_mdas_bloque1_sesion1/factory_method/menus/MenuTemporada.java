package equipo10_mdas_bloque1_sesion1.factory_method.menus;

import equipo10_mdas_bloque1_sesion1.factory_method.Plato;
import equipo10_mdas_bloque1_sesion1.factory_method.TipoAcompanamiento;
import equipo10_mdas_bloque1_sesion1.factory_method.TipoPlato;

public class MenuTemporada extends Menu 
{
//hereda de menu
    @Override
    public MenuTemporada crearTemporada(TipoAcompanamiento acompanamiento)
    {
        Plato entrante=new Plato("Patatas-Foster", 8.99f*1.02f, TipoPlato.ENTRANTE, TipoAcompanamiento.SIN_ACOMPANAMIENTO );
        entrante.setAcompanamiento(acompanamiento);
        asignarPlato(entrante);

        Plato principal=new Plato("Bocadillo", 8.99f*1.02f, TipoPlato.PRINCIPAL, TipoAcompanamiento.ENSALADA);
        principal.setAcompanamiento(acompanamiento);
        asignarPlato(principal);

        Plato postre=new Plato("Donetes", 8.99f*1.02f, TipoPlato.POSTRE, TipoAcompanamiento.SIN_ACOMPANAMIENTO );
        postre.setAcompanamiento(acompanamiento);
        asignarPlato(postre);
        
        return menutemporada;
        
    }
}
