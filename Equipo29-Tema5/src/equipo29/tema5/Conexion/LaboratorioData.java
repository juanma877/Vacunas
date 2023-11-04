package equipo29.tema5.Conexion;

import equipo29.tema5.Data.Laboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class LaboratorioData {
    private Connection con = null;

    public LaboratorioData() {
        con = Conexion.buscarConexion();
    }
    
    public Laboratorio buscarLaboratorioCuit(String cuit){

        String sql = "SELECT idLaboratorio,cuit, nombre, pais, domicilio FROM laboratorio WHERE cuit=? AND estado=1";
        Laboratorio laboratorio = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cuit);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(rs.getInt("idLaboratorio"));
                laboratorio.setCuit(rs.getString("cuit"));
                laboratorio.setNombre(rs.getString("nombre"));
                laboratorio.setPais(rs.getString("pais"));
                laboratorio.setDomicilio(rs.getString("domicilio"));

            } else {
                JOptionPane.showMessageDialog(null, "Este Laboratorio no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return laboratorio;
    }
    
    public Laboratorio buscarLaboratorioNombre(String nombre){

        String sql = "SELECT idLaboratorio,cuit, nombre, pais, domicilio FROM laboratorio WHERE nombre=? AND estado=1";
        Laboratorio laboratorio = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(rs.getInt("idLaboratorio"));
                laboratorio.setCuit(rs.getString("cuit"));
                laboratorio.setNombre(rs.getString("nombre"));
                laboratorio.setPais(rs.getString("pais"));
                laboratorio.setDomicilio(rs.getString("domicilio"));

            } else {
                JOptionPane.showMessageDialog(null, "Este Laboratorio no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return laboratorio;
    }
    
    public Laboratorio buscarLaboratorioId(int idLaboratorio ){

        String sql = "SELECT idLaboratorio,cuit, nombre, pais, domicilio FROM laboratorio WHERE idLaboratorio=? AND estado=1";
        Laboratorio laboratorio = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idLaboratorio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(idLaboratorio);
                laboratorio.setCuit(rs.getString("cuit"));
                laboratorio.setNombre(rs.getString("nombre"));
                laboratorio.setPais(rs.getString("pais"));
                laboratorio.setDomicilio(rs.getString("domicilio"));

            } else {
                JOptionPane.showMessageDialog(null, "Este Laboratorio no existe en la base de datos ");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return laboratorio;
    }
    
    public void modificarLaboratorio(Laboratorio laboratorio) throws SQLIntegrityConstraintViolationException, SQLException {

        String sql = "UPDATE laboratorio SET cuit=?,nombre=?,pais=?,domicilio=? WHERE idLaboratorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setString(1, laboratorio.getCuit());
            ps.setString(2, laboratorio.getNombre());
            ps.setString(3, laboratorio.getPais());
            ps.setString(4, laboratorio.getDomicilio());
            ps.setInt(5, laboratorio.getIdLaboratorio());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Laboratorio modificado");
            }

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El cuit o el nombre ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public void guardarLaboratorio (Laboratorio laboratorio) throws SQLIntegrityConstraintViolationException, SQLException{
        String sql = "INSERT INTO laboratorio(cuit,nombre,pais,domicilio,estado) VALUES (?,?,?,?,1)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)){;
            ps.setString(1, laboratorio.getCuit());
            ps.setString(2, laboratorio.getNombre());
            ps.setString(3, laboratorio.getPais());
            ps.setString(4, laboratorio.getDomicilio());
            
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No se pudo insertar el registro.");
            } else {
                JOptionPane.showMessageDialog(null, "Laboratorio registrado");
            }
            
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "El cuit o nombre indicado ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
    }
    
    public void bajaLaboratorio(int idLaboratorio) throws SQLException {

        String sql = "UPDATE laboratorio SET estado=0 WHERE idLaboratorio=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idLaboratorio);
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                JOptionPane.showMessageDialog(null, "Laboratorio dado de baja");
            }

        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }

    }
    
    public List<Laboratorio> listarLaboratorios() {

        String sql = "SELECT idLaboratorio, cuit, nombre, pais, domicilio, estado FROM laboratorio WHERE estado=1";
        ArrayList<Laboratorio> laboratorios = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Laboratorio laboratorio = new Laboratorio();
                laboratorio.setIdLaboratorio(rs.getInt("idLaboratorio"));
                laboratorio.setCuit(rs.getString("cuit"));
                laboratorio.setNombre(rs.getString("nombre"));
                laboratorio.setPais(rs.getString("pais"));
                laboratorio.setDomicilio(rs.getString("domicilio"));
                laboratorios.add(laboratorio);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return laboratorios;
    }
    
}