
public class Buscador {
    public static void main(String[] args){
            Empresa empresa1 = new EmpresaAmarilla(new Sofas());
        empresa1.crear();
        Empresa Empresa2 = new EmpresaBurdeos(new Mesas());
        Empresa2.crear();
        Empresa Empresa3 = new EmpresaCaqui(new Sofas(), Mesas());
        Empresa3.crear();
    }
}
