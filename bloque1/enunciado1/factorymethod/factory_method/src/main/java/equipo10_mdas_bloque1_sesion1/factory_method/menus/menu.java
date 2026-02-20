package equipo10_mdas_bloque1_sesion1.factory_method.menus;

import java.util.List;

public abstract class Menu {


    public abstract double calculoPrecio(); //Calcula el precio total del menú aplicando el incremento del 2 % cuando corresponde.

    public abstract List<Plato> obtenerPlatos(); //Devuelve la lista de platos que componen el menú.

    public abstract void asignarPlato(Plato plato); //funcion para añadir un plato al menú, validando si el plato es compatible con las reglas de negocio (p. ej., no se añade postre en un menú para llevar).
}
