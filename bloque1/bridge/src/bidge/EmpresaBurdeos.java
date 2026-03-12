
public class EmpresaBurdeos extends Empresa {
    public EmpresaBurdeos(Taller taller)
    {
        super(taller);
    }

    @Override
    public void crear()
    {
        System.out.print("\n Burdeos ");
        taller1.crear();

    }
}
