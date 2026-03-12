
public class EmpresaAmarilla extends Empresa {
    public EmpresaAmarilla(Taller taller)
    {
        super(taller);
    }

    @Override
    public void crear()
    {
        System.out.print("\n Amarillo ");
        taller1.crear();
        
    }
}
