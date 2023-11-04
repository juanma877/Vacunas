
package equipo29.tema5.Data;


public class Laboratorio implements Comparable<Laboratorio>{
    private int idLaboratorio = -1;
    private String cuit;
    private String nombre;
    private String pais;
    private String Domicilio;

    public Laboratorio() {
        this.idLaboratorio = -1;
    }

    

    public Laboratorio(String cuit, String nombre, String pais, String Domicilio) {
       this.cuit = cuit;
        this.nombre = nombre;
        this.pais = pais;
        this.Domicilio = Domicilio;
    }
    
    public Laboratorio(int idLaboratorio, String cuit, String nombre, String pais, String Domicilio) {
        this.idLaboratorio = idLaboratorio;
        this.cuit = cuit;
        this.nombre = nombre;
        this.pais = pais;
        this.Domicilio = Domicilio;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }
    
    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "idLaboratorio=" + idLaboratorio + ", cuit=" + cuit + ", nombre=" + nombre + ", pais=" + pais + ", Domicilio=" + Domicilio + '}';
    }

    @Override
    public int compareTo(Laboratorio t) {
        if (idLaboratorio == t.idLaboratorio){
            return 0;
        }else if(idLaboratorio > t.idLaboratorio){
            return 1;
        }else{
            return -1;
        }
    }
    
}
