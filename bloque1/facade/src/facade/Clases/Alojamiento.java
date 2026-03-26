package Clases;
import java.time.LocalDate;

// Modelo simple: representa un alojamiento disponible para reservar.
public class Alojamiento {
    private String nombre, ciudad;
    private LocalDate fechaEntrada, fechaSalida;
    private int plazas;
    
    public Alojamiento(String nombre, String ciudad, LocalDate fechaEntrada, LocalDate fechaSalida, int plazas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.plazas = plazas;
    }
    


    // Getters: lectura de propiedades del alojamiento.
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

    public int getPlazas() {
        return plazas;
    }

    // Alias para que los sistemas puedan usar una nomenclatura mas explicita.
    public LocalDate getFechaInicioDisponible() {
        return fechaEntrada;
    }

    public LocalDate getFechaFinDisponible() {
        return fechaSalida;
    }

    // Setters: actualizacion de datos del alojamiento.
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

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
}