

public abstract  class Empresa {
    protected Taller taller1;
    protected  Taller taller2;

    protected Empresa(Taller taller)
    {
        this.taller1 = taller;
        
    }

    abstract public void crear();
}
