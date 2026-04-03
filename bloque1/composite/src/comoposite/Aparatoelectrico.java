package comoposite;

public class Aparatoelectrico implements Contador{
        //Aparato eléctrico individual (elemento hoja del patrón Composite)
        //https://www.geeksforgeeks.org/system-design/composite-method-software-design-pattern/
        //https://www.geeksforgeeks.org/java/composite-design-pattern-in-java/
        private static final float PRECIO_KWH = 0.14f; // Precio medio en España: 0,14€/kWh
        private String nombre;
        private float TotalHoras;
        private int Consumo; // en vatios
        
        public Aparatoelectrico(String nombre, float Totalhoras, int consumo){
                this.nombre = nombre;
                this.TotalHoras=Totalhoras;
                this.Consumo=consumo; //En vatios
        }
        @Override
        public float getConsumoGlobal(){
                // Consumo en kWh = (Horas * Vatios) / 1000
                return (this.TotalHoras * this.Consumo) / 1000f;
        }

        @Override
        public float getCoste(){
                // Coste = consumo en kWh * precio por kWh
                return getConsumoGlobal() * PRECIO_KWH;
        }
        
        public String getNombre(){
                return nombre;
        }
        
        public float getTotalHoras(){
                return TotalHoras;
        }
        
        public int getConsumoWatios(){
                return Consumo;
        }

}