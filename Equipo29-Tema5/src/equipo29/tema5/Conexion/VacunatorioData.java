

package equipo29.tema5.Conexion;

import equipo29.tema5.Data.Vacunatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author 20352555674
 */
public class VacunatorioData {
    private Connection con = null;
    
    public VacunatorioData() {
        con = Conexion.buscarConexion();
    }
    
    public Vacunatorio buscarVacunatorioId(int id){

        String sql = "SELECT descripcion FROM vacunatorio WHERE idVacunatorio=? AND estado=1";
        Vacunatorio vacunatorio = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacunatorio = new Vacunatorio();
                vacunatorio.setIdVacunatorio(id);
                vacunatorio.setDescripcion(rs.getString("descripcion"));
                vacunatorio.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "Este Vacunatorio no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return vacunatorio;
    }
    
    public Vacunatorio buscarVacunatorioDescipcion(String descripcion){

        String sql = "SELECT idVacunatorio FROM vacunatorio WHERE descripcion=? AND estado=1";
        Vacunatorio vacunatorio = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, descripcion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacunatorio = new Vacunatorio();
                vacunatorio.setIdVacunatorio(rs.getInt("idVacunatorio"));
                vacunatorio.setDescripcion(descripcion);
                vacunatorio.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "Este Vacunatorio no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return vacunatorio;
    }
    
    public void guardarVacunatorio (Vacunatorio vacunatorio) throws SQLIntegrityConstraintViolationException, SQLException{
        String sql = "INSERT INTO vacunatorio(descripcion,estado) VALUES (?,1)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)){;
            ps.setString(1, vacunatorio.getDescripcion());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No se pudo insertar el registro.");
            } else {
                JOptionPane.showMessageDialog(null, "Vacunatorio registrado");
            }
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El nombre indicado ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
    }
    
    public void bajaVacunatorio(int idVacunatorio) throws SQLException {

        String sql = "UPDATE vacunatorio SET estado=0 WHERE idVacunatorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idVacunatorio);
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Vacunatorio dado de baja");
            }

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public void modificarVacunatorio (Vacunatorio vacunatorio, int id2) throws SQLIntegrityConstraintViolationException, SQLException {

        String sql = "UPDATE vacunatorio SET idVacunatorio=?,descripcion=? WHERE idVacunatorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, vacunatorio.getIdVacunatorio());
            ps.setString(2, vacunatorio.getDescripcion());
            ps.setInt(3, id2);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Vacunatorio modificado");
            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El ID o el nombre ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public List<Vacunatorio> listarVacunatorios() {

        String sql = "SELECT idVacunatorio, descripcion FROM vacunatorio WHERE estado=1";
        ArrayList<Vacunatorio> vacunatorios = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vacunatorio vacunatorio = new Vacunatorio();
                vacunatorio.setIdVacunatorio(rs.getInt("idVacunatorio"));
                vacunatorio.setDescripcion(rs.getString("descripcion"));
                vacunatorios.add(vacunatorio);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return vacunatorios;
    }
}
