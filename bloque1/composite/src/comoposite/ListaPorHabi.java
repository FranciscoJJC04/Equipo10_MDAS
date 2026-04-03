package comoposite;

import java.util.ArrayList;
import java.util.List;

public class ListaPorHabi implements Contador {
    //Composite que agrupa espacios y aparatos (edificios, salas, etc.)
    private String nombre;
    private List<Contador> componentes = new ArrayList<>();
    
    public ListaPorHabi(String nombre){
        this.nombre = nombre;
    }
    
    public void adherir(Contador cont){
        componentes.add(cont);
    }
    
    @Override
    public float getConsumoGlobal(){
        float total=0;
        for(Contador cont : componentes){
            total += cont.getConsumoGlobal();
        }
        return total;
    }
    
    @Override
    public float getCoste(){
        float total=0;
        for(Contador cont : componentes){
            total += cont.getCoste();
        }    
        return total;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void mostrarDetalles(String indentacion){
        System.out.println(indentacion + "[ESPACIO] " + nombre + ": " + String.format("%.2f", getConsumoGlobal()) + " kWh | Coste: " + String.format("%.2f EUR", getCoste()));
        for(Contador cont : componentes){
            if(cont instanceof Aparatoelectrico){
                Aparatoelectrico aparato = (Aparatoelectrico) cont;
                System.out.println(indentacion + "  [APARATO] " + aparato.getNombre() + ": " + String.format("%.2f", aparato.getConsumoGlobal()) + " kWh | Coste: " + String.format("%.2f EUR", aparato.getCoste()));
            } else if(cont instanceof ListaPorHabi){
                ListaPorHabi espacio = (ListaPorHabi) cont;
                espacio.mostrarDetalles(indentacion + "  ");
            }
        }
    }



}
