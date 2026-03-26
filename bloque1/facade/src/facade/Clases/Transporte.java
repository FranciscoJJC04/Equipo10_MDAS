package Clases;
import java.time.LocalDate;

// Modelo simple: representa una opcion de transporte entre dos ciudades.
public class Transporte {
    private String proveedor, ciudadOrigen, ciudadDestino;
    private LocalDate fechaSalida, fechaLlegada;
    private int plazas;
    
    public Transporte(String proveedor, String ciudadOrigen, String ciudadDestino, LocalDate fechaSalida, LocalDate fechaLlegada, int plazas) {
        this.proveedor = proveedor;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.plazas = plazas;
    }

    // Getters: lectura de propiedades de transporte.
    public String getProveedor() {
        return proveedor;
    }
    public String getCiudadOrigen() {
        return ciudadOrigen;
    }
    public String getCiudadDestino() {
        return ciudadDestino;
    }
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }
    public int getPlazas() {
        return plazas;
    }

    // Alias para compatibilidad con codigo previo de la practica.
    public int getSitiosVacis() {
        return plazas;
    }

    // Setters: actualizacion de datos de transporte.
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }
    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }
    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public void setSitiosVacis(int sitiosvacis) {
        this.plazas = sitiosvacis;
    }

}
