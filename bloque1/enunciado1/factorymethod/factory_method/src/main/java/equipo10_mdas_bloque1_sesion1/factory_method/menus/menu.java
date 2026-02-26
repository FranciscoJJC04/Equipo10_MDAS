package equipo10_mdas_bloque1_sesion1.factory_method.menus;
import java.util.List;

import equipo10_mdas_bloque1_sesion1.factory_method.Plato;

public abstract class Menu {
    public List<Plato> lista;
    
    public Menu(){ //constructor vacio
        this.lista = new java.util.ArrayList<>(); //inicializamos apra que no de NUllPointerException
    }

    public float CalcularPrecio(){
        float preciottoal=0;
        for(int i=0; i<lista.size();i++){
            preciottoal=preciottoal+lista.get(i).getPrecio();
        }
        return preciottoal;
    }



    public List<Plato> getPlatos(){return lista;}


    public void asignarPlato(Plato otroplato){
        if(lista.size()<3){ //3= entrante, principal y postre
            lista.add(otroplato);
        }
    }
}
