import java.time.LocalDate;

public class Actividad {
    private String actividadflipante, ciudad, tipo;
    private LocalDate fechaActividad;
    private int nPersonas;

    public Actividad(String actividadflipante, String ciudad, String tipo, LocalDate fechaActividad, int nPersonas) {
        this.actividadflipante = actividadflipante;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.fechaActividad = fechaActividad;
        this.nPersonas = nPersonas;
    }

    //##################### SGetters ################
    public String getActividadflipante() {
        return actividadflipante;
    }
    public String getCiudad() {
        return ciudad;
    }
    public String getTipo() {
        return tipo;
    }
    public LocalDate getFechaActividad() {
        return fechaActividad;
    }
    public int getNPersonas() {
        return nPersonas;
    }

    //##################### Setters ################
    public void setActividadflipante(String actividadflipante) {
        this.actividadflipante = actividadflipante;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setFechaActividad(LocalDate fechaActividad) {
        this.fechaActividad = fechaActividad;
    }
    public void setNPersonas(int nPersonas) {
        this.nPersonas = nPersonas;
    }

}
