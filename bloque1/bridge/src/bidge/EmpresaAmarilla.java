
public class EmpresaAmarilla extends Empresa {
    public EmpresaAmarilla(Taller workShop1, Taller workShop2)
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
