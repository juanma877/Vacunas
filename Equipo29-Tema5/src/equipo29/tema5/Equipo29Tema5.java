
package equipo29.tema5;

import equipo29.tema5.Conexion.CiudadanoData;
import equipo29.tema5.Data.Ciudadano;
import java.sql.SQLException;


public class Equipo29Tema5 {

    
    public static void main(String[] args) throws SQLException {
        Ciudadano raul = new Ciudadano(32555666, "Raul Lopez", "rlopez@gmail.oom", "1152356699", "", "administrativo");
        CiudadanoData cd = new CiudadanoData();
        
        cd.guardarCiudadano(raul);
        
    }
    
}
