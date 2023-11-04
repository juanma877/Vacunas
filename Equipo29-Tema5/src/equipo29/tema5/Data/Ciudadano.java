
package equipo29.tema5.Data;


public class Ciudadano implements Comparable<Ciudadano>{
    private int id = -1;
    private int dni;
    private String nombreCompleto;
    private String email;
    private String celular;
    private String patologia;
    private String ambitoTrabajo;

    public Ciudadano() {
        this.id = -1;
    }

    public Ciudadano(int id, int dni, String nombreCompleto, String email, String celular, String ambitoTrabajo) {
        this.id = id;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.celular = celular;
        this.patologia = null;
        this.ambitoTrabajo = ambitoTrabajo;
    }
    
    public Ciudadano(int dni, String nombreCompleto, String email, String celular, String ambitoTrabajo) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.celular = celular;
        this.patologia = null;
        this.ambitoTrabajo = ambitoTrabajo;
    }

    public Ciudadano(int id, int dni, String nombreCompleto, String email, String celular, String patologia, String ambitoTrabajo) {
        this.id = id;
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.celular = celular;
        this.patologia = patologia;
        this.ambitoTrabajo = ambitoTrabajo;
    }
    
    public Ciudadano(int dni, String nombreCompleto, String email, String celular, String patologia, String ambitoTrabajo) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.celular = celular;
        this.patologia = patologia;
        this.ambitoTrabajo = ambitoTrabajo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getAmbitoTrabajo() {
        return ambitoTrabajo;
    }

    public void setAmbitoTrabajo(String ambitoTrabajo) {
        this.ambitoTrabajo = ambitoTrabajo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
    @Override
    public String toString() {
         return dni + " - " + nombreCompleto;
    }

    @Override
    public int compareTo(Ciudadano t) {
        if (dni == t.dni){
            return 0;
        }else if(dni > t.dni){
            return 1;
        }else{
            return -1;
        }
    }
    
    
}
