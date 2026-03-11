import java.util.ArrayList;
import java.util.List;

public class ListaPorHabi implements Contador {
    //Esto tendra una sera un conjunto de coasas a tener en cuenta
    //pwro no por elloes una lista List<AparatoElectrico> para medir su consumo
    private List<Contador> listacacharros=new ArrayList<>();
    //no se pude poner añadir aaaaaaaaaaaaaaa
    public void adherir(Contador cont){listacacharros.add(cont);}
    
    @Override
    public float getCoste(){
        float total=0;
        for(Contador cont : listacacharros){
            total=cont.getCoste()+total;
        }    
        return total;
    }



}
