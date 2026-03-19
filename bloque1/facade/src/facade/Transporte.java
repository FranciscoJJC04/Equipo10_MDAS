import java.time.LocalDate;
public class Transporte {
    private String proveedor, ciudadOrigen, ciudadDestino;
    private LocalDate fechaSalida, fechaLlegada;
    private int sitiosvacis;
    
    public Transporte(String proveedor, String ciudadOrigen, String ciudadDestino, LocalDate fechaSalida, LocalDate fechaLlegada, int sitiosvacis) {
        this.proveedor = proveedor;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
        this.sitiosvacis = sitiosvacis;
    }

    //##################### SGetters ################
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
    public int getSitiosVacis() {
        return sitiosvacis;
    }

    //##################### Setters ################
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
    public void setSitiosVacis(int sitiosvacis) {
        this.sitiosvacis = sitiosvacis;
    }

}
