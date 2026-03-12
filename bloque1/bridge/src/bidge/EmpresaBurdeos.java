
public class EmpresaBurdeos extends Empresa {
    public EmpresaBurdeos(Taller workShop1, Taller workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void crear()
    {
        System.out.print("Amarillo ");
        workShop1.work();
        workShop2.work();
    }
}
