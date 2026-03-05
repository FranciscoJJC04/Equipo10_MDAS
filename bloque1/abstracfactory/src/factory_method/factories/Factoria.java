package factory_method.factories;

import factory_method.TipoAcompanamiento;
import factory_method.menus.MenuSemanal;
import  factory_method.menus.MenuTemporada;
//https://java-design-patterns.com/es/patterns/abstract-factory/#explicacion


public interface Factoria {

    MenuSemanal crearMenuSemanal(TipoAcompanamiento acompanamiento);
    MenuTemporada crearMenuTemporada(TipoAcompanamiento acompanamiento);

}


