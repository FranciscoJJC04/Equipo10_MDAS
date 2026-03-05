package equipo10_mdas_bloque1_sesion1.factory_method;
public class Plato {




    private String nombre;
    private float precio;
    private TipoPlato tipoPlato;
    private TipoAcompanamiento tipoAcompanamiento;
    

    public Plato(String nombre, float precio, TipoPlato tipo, TipoAcompanamiento acompanamiento) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipoPlato = tipo;
        
        if(acompanamiento == null)
        {
            this.tipoAcompanamiento = TipoAcompanamiento.SIN_ACOMPANAMIENTO;
        } 
        else 
        {
            this.tipoAcompanamiento = acompanamiento;
        }
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
        return tipoPlato;
    }
    
    public TipoAcompanamiento getAcompanamiento() {
        return tipoAcompanamiento;
        
    }


    //SETTERS
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipoPlato = tipo;
    }

    public void setAcompanamiento(TipoAcompanamiento acompanamiento) {
        this.tipoAcompanamiento = acompanamiento;
    }
}
