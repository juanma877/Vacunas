
package equipo29.tema5.Data;

import java.time.LocalDate;


public class Vacuna {
   private int nroSerie;
   private String marca;
   private double medida;
   private LocalDate fechaCad;
   private boolean estado;
   private Laboratorio laboratorio;

    public Vacuna() {
        this.nroSerie = -1;
    }

    public Vacuna(String marca, double medida, LocalDate fechaCad, boolean estado, Laboratorio laboratorio) {
        this.nroSerie = -1;
        this.marca = marca;
        this.medida = medida;
        this.fechaCad = fechaCad;
        this.estado = estado;
        this.laboratorio = laboratorio;
    }

    public Vacuna(int nroSerie, String marca, double medida, LocalDate fechaCad, boolean estado, Laboratorio laboratorio) {
        this.nroSerie = nroSerie;
        this.marca = marca;
        this.medida = medida;
        this.fechaCad = fechaCad;
        this.estado = estado;
        this.laboratorio = laboratorio;
    }
    
    public int getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(int nroSerie) {
        this.nroSerie = nroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public LocalDate getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(LocalDate fechaCad) {
        this.fechaCad = fechaCad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }


    @Override
    public String toString() {
        return "Vacuna{" + "nroSerie=" + nroSerie + ", marca=" + marca + ", medida=" + medida + ", fechaCad=" + fechaCad + ", estado=" + estado + ", laboratorio=" + laboratorio + '}';
    }

    
   
   
}
