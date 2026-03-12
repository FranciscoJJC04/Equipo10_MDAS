

public class EmpresaCaqui extends Empresa{
    private final Taller tallerex;
    public EmpresaCaqui(Taller taller, Taller taller2)
    {
        super(taller);
        this.tallerex=taller2;
    }

    @Override
    public void crear()
    {
        System.out.print("\n Caqui ");
        taller1.crear();
        tallerex.crear();
    }
}
