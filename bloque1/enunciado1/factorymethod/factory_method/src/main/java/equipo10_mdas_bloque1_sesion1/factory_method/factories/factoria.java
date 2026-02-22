package equipo10_mdas_bloque1_sesion1.factory_method.factories;
import equipo10_mdas_bloque1_sesion1.factory_method.TipoAcompanamiento;
import equipo10_mdas_bloque1_sesion1.factory_method.menus.MenuSemanal;
import equipo10_mdas_bloque1_sesion1.factory_method.menus.MenuTemporada;
//https://java-design-patterns.com/es/patterns/abstract-factory/#explicacion
public interface Factoria {
MenuSemanal crearMenuSemanal(TipoAcompanamiento acompanamiento);
MenuTemporada crearMenuTemporada(TipoAcompanamiento acompanamiento);

}


