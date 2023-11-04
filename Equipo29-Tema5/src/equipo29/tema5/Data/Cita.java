
package equipo29.tema5.Data;

import java.time.LocalDate;


public class Cita implements Comparable<Cita>{
    private int codCita;
    private Ciudadano ciudadano;
    private int codRefuerzo;
    private String fechaHoraCita;
    private LocalDate fechaHoraColoca;
    private Vacuna vacuna;
    private boolean cancelada;
    private Vacunatorio vacunatorio;
    private int cantDosis;

    public Cita() {
        this.codCita = -1;
    }

    public Cita(Ciudadano ciudadano, int codRefuerzo, String fechaHoraCita, Vacuna vacuna, Vacunatorio vacunatorio) {
        this.codCita = -1;
        this.ciudadano = ciudadano;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.fechaHoraColoca = null;
        this.vacuna = vacuna;
        this.vacunatorio = vacunatorio;
    }

    public Cita(int codCita, Ciudadano ciudadano, int codRefuerzo, String fechaHoraCita, Vacuna vacuna, Vacunatorio vacunatorio) {
        this.codCita = codCita;
        this.ciudadano = ciudadano;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.fechaHoraColoca =null;
        this.vacuna = vacuna;
        this.vacunatorio = vacunatorio;
    }

    public Cita(int codCita, int codRefuerzo, String fechaHoraCita, Vacunatorio vacunatorio) {
        this.codCita = codCita;
        this.codRefuerzo = codRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.vacunatorio = vacunatorio;
    }
    
    
    
    public int getCodCita() {
        return codCita;
    }

    public void setCodCita(int codCita) {
        this.codCita = codCita;
    }

    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    public int getCodRefuerzo() {
        return codRefuerzo;
    }

    public void setCodRefuerzo(int codRefuerzo) {
        this.codRefuerzo = codRefuerzo;
    }

    public String getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(String fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public LocalDate getFechaHoraColoca() {
        return fechaHoraColoca;
    }

    public void setFechaHoraColoca(LocalDate fechaHoraColoca) {
        this.fechaHoraColoca = fechaHoraColoca;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Vacunatorio getVacunatorio() {
        return vacunatorio;
    }

    public void setVacunatorio(Vacunatorio vacunatorio) {
        this.vacunatorio = vacunatorio;
    }

    public int getCantDosis() {
        return cantDosis;
    }

    public void setCantDosis(int cantDosis) {
        this.cantDosis = cantDosis;
    }
    
    

    @Override
    public String toString() {
        return "Cita{" + "codCita=" + codCita + ", ciudadano=" + ciudadano + ", codRefuerzo=" + codRefuerzo + ", fechaHoraCita=" + fechaHoraCita + ", fechaHoraColoca=" + fechaHoraColoca + ", vacuna=" + vacuna + ", cancelada=" + cancelada + ", vacunatorio=" + vacunatorio + '}';
    }

    @Override
    public int compareTo(Cita t) {
         if (codCita == t.codCita){
            return 0;
        }else if(codCita > t.codCita){
            return 1;
        }else{
            return -1;
        }
    }

    
    
    
    
}
