

public class EmpresaCaqui extends Empresa{
    public EmpresaCaqui(Taller workShop1, Taller workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void crear()
    {
        System.out.print("Caqui ");
        workShop1.work();
        workShop2.work();
    }
}
