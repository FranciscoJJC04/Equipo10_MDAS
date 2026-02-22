package equipo10_mdas_bloque1_sesion1.factory_method.menus;
import java.util.List;

import equipo10_mdas_bloque1_sesion1.factory_method.Plato;

public abstract class Menu {
    public List<Plato> lista;
    public float CalcularPrcio(){
        float preciottoal=0;
        for(int i=0; i<lista.size();i++){
            preciottoal=preciottoal+lista.get(i).getPrecio();
        }
        return preciottoal;
    }
    public List<Plato> getPlatos(){return lista;}
    public void asignarPlato(Plato otropalto){
        if(lista.size()<3){lista.add(otropalto);}}
    }
