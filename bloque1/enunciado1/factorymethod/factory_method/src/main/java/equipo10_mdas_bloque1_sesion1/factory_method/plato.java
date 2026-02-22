package equipo10_mdas_bloque1_sesion1.factory_method;

public class Plato {




    private String nombre;
    private float precio;
    private TipoPlato tipo;
    private TipoAcompanamiento acompanamiento;
    

    public Plato(String nombre, float precio, TipoPlato tipo, TipoAcompanamiento acompanamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.acompanamiento = acompanamiento;
    }

    public void asignarPrecio(Plato origen) {  //Asigna el precio de un plato a otro.
        this.precio = origen.getPrecio();
    }


    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoPlato getTipo() {
        return tipo;
    }
    
    public TipoAcompanamiento getAcompanamiento() {
        return acompanamiento;
    }


    //SETTERS
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public void setAcompanamiento(TipoAcompanamiento acompanamiento) {
        this.acompanamiento = acompanamiento;
    }
}
