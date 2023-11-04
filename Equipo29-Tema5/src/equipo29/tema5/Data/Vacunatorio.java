

package equipo29.tema5.Data;

/**
 *
 * @author 20352555674
 */
public class Vacunatorio implements Comparable<Vacunatorio>{
    private int idVacunatorio;
    private String descripcion;
    private boolean estado;

    public Vacunatorio() {
        this.idVacunatorio = -1;
    }

    public Vacunatorio(String descripcion, boolean estado) {
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Vacunatorio(int idVacunatorio, String descripcion, boolean estado) {
        this.idVacunatorio = idVacunatorio;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdVacunatorio() {
        return idVacunatorio;
    }

    public void setIdVacunatorio(int idVacunatorio) {
        this.idVacunatorio = idVacunatorio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        //return idVacunatorio + " - " + descripcion;
        return descripcion;
    }

    @Override
    public int compareTo(Vacunatorio t) {
        if (idVacunatorio == t.idVacunatorio){
            return 0;
        }else if(idVacunatorio > t.idVacunatorio){
            return 1;
        }else{
            return -1;
        }
    }
    
}
