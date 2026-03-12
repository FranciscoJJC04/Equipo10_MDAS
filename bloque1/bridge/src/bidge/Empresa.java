

public abstract  class Empresa {
    protected Taller taller1;
    protected Taller taller2;

    protected empresa(Taller workShop1, Taller workShop2)
    {
        this.taller1 = workShop1;
        this.taller1 = workShop2;
    }

    abstract public void crear();
}
