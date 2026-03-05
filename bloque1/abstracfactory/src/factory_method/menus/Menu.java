package factory_method.menus;
import factory_method.Plato;
import java.util.List;

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


    public void getPlatos(){
        for(Plato p:lista){
            System.out.println("Nombre: " + p.getNombre() + " | Precio: " + p.getPrecio());
        }
    System.out.println("Precio total: " + CalcularPrecio());

}


    public void asignarPlato(Plato otroplato){
        if(lista.size()<3){ //3= entrante, principal y postre
            lista.add(otroplato);
        }
    }
}
