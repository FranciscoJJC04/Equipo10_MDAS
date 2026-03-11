import java.util.Random;
public class Aparatoelectrico implements Contador{
        //Esto sera una tarea indiviual como lo pueden ser maquinas en mitad de unn pasillo
        //https://www.geeksforgeeks.org/system-design/composite-method-software-design-pattern/
        //https://www.geeksforgeeks.org/java/composite-design-pattern-in-java/
        private float TotalHoras;
        private float TotalCoste;
        private int Consumo;
        public Aparatoelectrico(float Totalhoras, int consumo){
                this.TotalHoras=Totalhoras;
                this.Consumo=consumo; //En vatios
                //Precio del kilovatio hora n españa oscila entre el 0,13€ y l 0,15€
                //por eso esto es así:
                Random random= new Random();
                int selectorprecio=random.nextInt(300);
                if(selectorprecio>=0 && selectorprecio<100){
                this.TotalCoste=this.TotalHoras*this.Consumo*0.13f;
                }
                if(selectorprecio>=100 && selectorprecio<200){
                this.TotalCoste=this.TotalHoras*this.Consumo*0.14f;
                }
                if(selectorprecio>200 && selectorprecio<=300){
                this.TotalCoste=this.TotalHoras*this.Consumo*0.15f;
                }  
        }
        @Override
        public float getCoste(){return this.TotalCoste;}

}