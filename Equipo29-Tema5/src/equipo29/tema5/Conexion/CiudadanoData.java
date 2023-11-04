
package equipo29.tema5.Conexion;

import equipo29.tema5.Data.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CiudadanoData {
    private Connection con = null;

    public CiudadanoData() {
        con = Conexion.buscarConexion();
    }
    
    public void guardarCiudadano (Ciudadano ciudadano) throws SQLIntegrityConstraintViolationException, SQLException{
        String sql = "INSERT INTO ciudadano(dni, nombreCompleto, email, celular, patologia, ambitoTrabajo, estado) VALUES (?,?,?,?,?,?,1)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)){;
            ps.setInt(1, ciudadano.getDni());
            ps.setString(2, ciudadano.getNombreCompleto());
            ps.setString(3, ciudadano.getEmail());
            ps.setString(4, ciudadano.getCelular());
            ps.setString(5, ciudadano.getPatologia());
            ps.setString(6, ciudadano.getAmbitoTrabajo());
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No se pudo insertar el registro.");
            } else {
                JOptionPane.showMessageDialog(null, "Ciudadano registrado");
            }
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El email o el celular indicado ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
    }
    
    public void modificarCiudadano(Ciudadano ciudadano) throws SQLIntegrityConstraintViolationException, SQLException {

        String sql = "UPDATE ciudadano SET dni=?, nombreCompleto=?, email=?, celular=?, patologia=?, ambitoTrabajo=? WHERE idCiudadano=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, ciudadano.getDni());
            ps.setString(2, ciudadano.getNombreCompleto());
            ps.setString(3, ciudadano.getEmail());
            ps.setString(4, ciudadano.getCelular());
            ps.setString(5, ciudadano.getPatologia());
            ps.setString(6, ciudadano.getAmbitoTrabajo());
            ps.setInt(7, ciudadano.getId());

            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Ciudadano modificado");
            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El email o el celular indicado ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public void bajaCiudadano(int dni) throws SQLException {

        String sql = "UPDATE ciudadano SET estado=0 WHERE dni=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, dni);
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Ciudadano dado de baja");
            }

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public Ciudadano buscarCiudadanoDni(int dni) throws NullPointerException {

        String sql = "SELECT idCiudadano, dni, nombreCompleto, email, celular, patologia, ambitoTrabajo FROM ciudadano WHERE dni=?";
        Ciudadano ciudadano = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ciudadano = new Ciudadano();
                ciudadano.setId(rs.getInt("idCiudadano"));
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
                ciudadano.setEmail(rs.getString("email"));
                ciudadano.setCelular(rs.getString("celular"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));

            } else {
                JOptionPane.showMessageDialog(null, "Este Ciudadano no existe en la base de datos");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return ciudadano;
    }
    
    public Ciudadano buscarCiudadanoEmail(String email) throws NullPointerException {

        String sql = "SELECT idCiudadano, dni, nombreCompleto, email, celular, patologia, ambitoTrabajo FROM ciudadano WHERE email=?";
        Ciudadano ciudadano = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ciudadano = new Ciudadano();
                ciudadano.setId(rs.getInt("idCiudadano"));
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
                ciudadano.setEmail(rs.getString("email"));
                ciudadano.setCelular(rs.getString("celular"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));

            } else {
                JOptionPane.showMessageDialog(null, "Este Ciudadano no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return ciudadano;
    }
    
    public Ciudadano buscarCiudadanoCelular(String celular) throws NullPointerException {

        String sql = "SELECT idCiudadano, dni, nombreCompleto, email, celular, patologia, ambitoTrabajo FROM ciudadano WHERE celular=?";
        Ciudadano ciudadano = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, celular);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ciudadano = new Ciudadano();
                ciudadano.setId(rs.getInt("idCiudadano"));
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
                ciudadano.setEmail(rs.getString("email"));
                ciudadano.setCelular(rs.getString("celular"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));

            } else {
                JOptionPane.showMessageDialog(null, "Este Ciudadano no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return ciudadano;
    }
    
     public List<Ciudadano> listarCiudadanos() {

        String sql = "SELECT idCiudadano,dni ,nombreCompleto, email, celular, patologia, ambitoTrabajo FROM ciudadano WHERE estado=1";
        ArrayList<Ciudadano> ciudadanos = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ciudadano ciudadano = new Ciudadano();
                ciudadano.setId(rs.getInt("idCiudadano"));
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
                ciudadano.setEmail(rs.getString("email"));
                ciudadano.setCelular(rs.getString("celular"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                ciudadanos.add(ciudadano);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return ciudadanos;
    }
    
    public List<Ciudadano> listarCiudadanosPatologia() {

        String sql = "SELECT idCiudadano,dni ,nombreCompleto, email, celular, patologia, ambitoTrabajo FROM ciudadano WHERE estado=1 AND patologia is not null";
        ArrayList<Ciudadano> ciudadanos = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ciudadano ciudadano = new Ciudadano();
                ciudadano.setId(rs.getInt("idCiudadano"));
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
                ciudadano.setEmail(rs.getString("email"));
                ciudadano.setCelular(rs.getString("celular"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                ciudadanos.add(ciudadano);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return ciudadanos;
    } 
    
     public List<Ciudadano> listarCiudadanosEsenciales() {

        String sql = "SELECT idCiudadano,dni ,nombreCompleto, email, celular, patologia, ambitoTrabajo FROM ciudadano WHERE estado=1 AND ambitoTrabajo LIKE 'salud' OR ambitoTrabajo LIKE 'educacion' OR ambitoTrabajo LIKE 'seguridad'";
        ArrayList<Ciudadano> ciudadanos = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ciudadano ciudadano = new Ciudadano();
                ciudadano.setId(rs.getInt("idCiudadano"));
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
                ciudadano.setEmail(rs.getString("email"));
                ciudadano.setCelular(rs.getString("celular"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                ciudadanos.add(ciudadano);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return ciudadanos;
    } 
     
    public List<Ciudadano> listarCiudadanosPatologiaEsenciales() {

        String sql = "SELECT * FROM ciudadano WHERE estado=1 AND patologia is not null AND ambitoTrabajo LIKE 'salud' OR ambitoTrabajo LIKE 'educacion' OR ambitoTrabajo LIKE 'seguridad'";
        ArrayList<Ciudadano> ciudadanos = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ciudadano ciudadano = new Ciudadano();
                ciudadano.setId(rs.getInt("idCiudadano"));
                ciudadano.setDni(rs.getInt("dni"));
                ciudadano.setNombreCompleto(rs.getString("nombreCompleto"));
                ciudadano.setEmail(rs.getString("email"));
                ciudadano.setCelular(rs.getString("celular"));
                ciudadano.setPatologia(rs.getString("patologia"));
                ciudadano.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                ciudadanos.add(ciudadano);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return ciudadanos;
    } 
     
}