
package equipo29.tema5.Conexion;

import equipo29.tema5.Data.Vacuna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class VacunaData {
    private Connection con = null;
    private LaboratorioData ld = new LaboratorioData();
    private VacunatorioData cvd = new VacunatorioData();

    public VacunaData() {
        con = Conexion.buscarConexion();
    }
    
    public Vacuna buscarVacuna(int nroSerie) throws NullPointerException {

        String sql = "SELECT marca, medida, fechaCad, estado, idLaboratorio  FROM vacuna WHERE nroSerie=?";
        Vacuna vacuna = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, nroSerie);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacuna = new Vacuna();
                vacuna.setNroSerie(nroSerie);
                vacuna.setMarca(rs.getString("marca"));
                vacuna.setMedida(rs.getDouble("medida"));
                vacuna.setFechaCad(rs.getDate("fechaCad").toLocalDate());
                vacuna.setEstado(rs.getBoolean("estado"));
                vacuna.setLaboratorio(ld.buscarLaboratorioId(rs.getInt("idLaboratorio")));

            } else {
                JOptionPane.showMessageDialog(null, "Esta Vacuna no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos-Bruno");
        }
        return vacuna;
    }
    
    public void bajaVacuna(int nroserie) throws SQLException {

        String sql = "UPDATE vacuna SET estado=0 WHERE nroSerie=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, nroserie);
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Vacuna dada de baja");
            }else{
                JOptionPane.showMessageDialog(null, "NO SE PUDO");
            }

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public void guardarVacuna (Vacuna vacuna) throws SQLIntegrityConstraintViolationException, SQLException{
        String sql = "INSERT INTO vacuna(marca,medida,fechaCad,estado,idLaboratorio) VALUES (?,?,?,1,?)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)){;
            ps.setString(1, vacuna.getMarca());
            ps.setDouble(2, vacuna.getMedida());
            ps.setDate(3, Date.valueOf(vacuna.getFechaCad()));
            ps.setInt(4, vacuna.getLaboratorio().getIdLaboratorio());
            
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No se pudo insertar el registro.");
            } else {
                JOptionPane.showMessageDialog(null, "Vacuna registrada");
            }
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El Nro de Serie indicado ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
    }
    
    public void modificarVacuna(Vacuna vacuna) throws  SQLException {

        String sql = "UPDATE vacuna SET marca=?,medida=?,fechaCad=?, estado=?, idLaboratorio=? WHERE nroSerie=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setString(1, vacuna.getMarca());
            ps.setDouble(2, vacuna.getMedida());
            ps.setDate(3, Date.valueOf(vacuna.getFechaCad()));
            ps.setBoolean(4, vacuna.isEstado());
            ps.setInt(5, vacuna.getLaboratorio().getIdLaboratorio());
            ps.setInt(6, vacuna.getNroSerie());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Vacuna modificada");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public Vacuna buscarVacunaDisponible() throws NullPointerException {

        String sql = "SELECT MIN(nroSerie) as nroSerie, marca, medida, fechaCad, estado, idLaboratorio FROM vacuna WHERE estado=1";
        Vacuna vacuna = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacuna = new Vacuna();
                vacuna.setNroSerie(rs.getInt("nroSerie"));
                vacuna.setMarca(rs.getString("marca"));
                vacuna.setMedida(rs.getDouble("medida"));
                vacuna.setFechaCad(rs.getDate("fechaCad").toLocalDate());
                vacuna.setEstado(rs.getBoolean("estado"));
                vacuna.setLaboratorio(ld.buscarLaboratorioId(rs.getInt("idLaboratorio")));

            } else {
                JOptionPane.showMessageDialog(null, "No hay Vacunas disponibles para asignar");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos"+ex.getMessage());
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "No hay Vacunas disponibles para asignar");
        }
        return vacuna;
    }
    
}