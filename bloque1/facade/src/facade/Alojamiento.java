import java.time.LocalDate;

public class Alojamiento {
    private String nombre, ciudad;
    private LocalDate fechaEntrada, fechaSalida;
    
    public Alojamiento(String nombre, String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }
    


    //##################### SGetters ################
    public String getNombre() {
        return nombre;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    //##################### Setters ################
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
    
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}