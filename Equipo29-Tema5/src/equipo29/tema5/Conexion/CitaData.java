package equipo29.tema5.Conexion;

import equipo29.tema5.Data.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


public class CitaData {
    private Connection con = null;
    private CiudadanoData ciudata = new CiudadanoData();
    private VacunaData vacudata = new VacunaData();
    private VacunatorioData cvd = new VacunatorioData();

    public CitaData() {
        con = Conexion.buscarConexion();
    }
    
    public List<Cita> buscarCitas(int dni) throws NullPointerException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT codCita, codRefuerzo, fechaHoraCita, idVacunatorio, fechaHoraColoca, dni, nroSerie, cancelada FROM cita WHERE dni=? AND cancelada=1 AND fechaHoraColoca IS NULL";
        Cita cita = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cita = new Cita();
                cita.setCodCita(rs.getInt("codCita"));
                cita.setCodRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getString("fechaHoraCita"));
                cita.setVacunatorio(cvd.buscarVacunatorioId(rs.getInt("idVacunatorio")));
//                cita.setFechaHoraColoca(rs.getDate("fechaHoraColoca").toLocalDate());
                cita.setCiudadano(ciudata.buscarCiudadanoDni(rs.getInt("dni")));
                cita.setVacuna(vacudata.buscarVacuna(rs.getInt("nroSerie")));
                citas.add(cita);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos "+ex.getMessage());
        }
        return citas;
    }
    
    public List<Cita> buscarCitasCumplidas(String mes) throws NullPointerException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT codCita, codRefuerzo, fechaHoraCita, idVacunatorio, fechaHoraColoca, dni, nroSerie, cancelada FROM cita WHERE MONTH(STR_TO_DATE(fechaHoraCita, '%Y-%m-%d %H:%i')) = ? AND cancelada=1 AND fechaHoraColoca IS NOT NULL";
        Cita cita = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mes);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cita = new Cita();
                cita.setCodCita(rs.getInt("codCita"));
                cita.setCodRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getString("fechaHoraCita"));
                cita.setVacunatorio(cvd.buscarVacunatorioId(rs.getInt("idVacunatorio")));
                cita.setFechaHoraColoca(rs.getDate("fechaHoraColoca").toLocalDate());
                cita.setCiudadano(ciudata.buscarCiudadanoDni(rs.getInt("dni")));
                cita.setVacuna(vacudata.buscarVacuna(rs.getInt("nroSerie")));
                citas.add(cita);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos "+ex.getMessage());
        }
        return citas;
    }
    
    public List<Cita> buscarCitasCanceladas(String mes) throws NullPointerException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT codCita, codRefuerzo, fechaHoraCita, idVacunatorio, fechaHoraColoca, dni, nroSerie, cancelada FROM cita WHERE MONTH(STR_TO_DATE(fechaHoraCita, '%Y-%m-%d %H:%i')) = ? AND cancelada=0";
        Cita cita = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mes);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cita = new Cita();
                cita.setCodCita(rs.getInt("codCita"));
                cita.setCodRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getString("fechaHoraCita"));
                cita.setVacunatorio(cvd.buscarVacunatorioId(rs.getInt("idVacunatorio")));
                cita.setFechaHoraColoca(null);
                cita.setCiudadano(ciudata.buscarCiudadanoDni(rs.getInt("dni")));
                cita.setVacuna(vacudata.buscarVacuna(rs.getInt("nroSerie")));
                citas.add(cita);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos "+ex.getMessage());
        }
        return citas;
    }
    
    public List<Cita> buscarCitasVencidas(String mes) throws NullPointerException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT codCita, codRefuerzo, fechaHoraCita, idVacunatorio, fechaHoraColoca, dni, nroSerie, cancelada FROM cita "
                + "WHERE MONTH(STR_TO_DATE(fechaHoraCita, '%Y-%m-%d %H:%i')) = ? AND STR_TO_DATE(fechaHoraCita, '%Y-%m-%d %H:%i') <= ? "
                + "AND cancelada=1 AND fechaHoraColoca IS NULL";
        Cita cita = null;
        
        Date fechaHoraActual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String fechaHoraActualFormateada = sdf.format(fechaHoraActual);
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, mes);
            ps.setString(2, fechaHoraActualFormateada);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cita = new Cita();
                cita.setCodCita(rs.getInt("codCita"));
                cita.setCodRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getString("fechaHoraCita"));
                cita.setVacunatorio(cvd.buscarVacunatorioId(rs.getInt("idVacunatorio")));
                cita.setFechaHoraColoca(null);
                cita.setCiudadano(ciudata.buscarCiudadanoDni(rs.getInt("dni")));
                cita.setVacuna(vacudata.buscarVacuna(rs.getInt("nroSerie")));
                citas.add(cita);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos "+ex.getMessage());
        }
        return citas;
    }
    
    public void cancelarCita(int codCita){
        String upd = "UPDATE cita SET cancelada = 0 WHERE codCita = ?";
         
        try {
            PreparedStatement ps = con.prepareStatement(upd);
            ps.setInt(1, codCita);
            int registro = ps.executeUpdate();
            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Cita cancelada, se generara una nueva cita");
            }
//            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cancelar la cita " + ex.getMessage());
        }
    }
    
    public String sumar2Semanas(String fechaHoraCita){
        //creamos formateador
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
        //lo convertimos a objeto
        LocalDateTime fhc = LocalDateTime.parse(fechaHoraCita, formateador);
        //sumamos 2 semanas
        fhc = fhc.plusWeeks(2);
        //formateamos nuevamente y retornamos como cadena
        return fhc.format(formateador).toString();
    }
    
    public String sumar4Semanas(String fechaHoraCita){
        //creamos formateador
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm");
        //lo convertimos a objeto
        LocalDateTime fhc = LocalDateTime.parse(fechaHoraCita, formateador);
        //sumamos 2 semanas
        fhc = fhc.plusWeeks(4);
        //formateamos nuevamente y retornamos como cadena
        return fhc.format(formateador).toString();
    }
    
    public void reprogramarCita(int codRefuerzo, String fechaHoraCita, int idVacunatorio, int dni, int nroSerie){
        String insert = "INSERT INTO cita(codRefuerzo, fechaHoraCita, idVacunatorio, fechaHoraColoca, dni, nroSerie, cancelada) VALUES (?,?,?,?,?,?,1)";
      
        try(PreparedStatement ps = con.prepareStatement(insert)){
        ps.setInt(1, codRefuerzo);
        ps.setString(2, sumar2Semanas(fechaHoraCita)); // aca hay que ver como calcular la nueva fecha
        ps.setInt(3, idVacunatorio);
        ps.setDate(4, null);
        ps.setInt(5, dni);
        ps.setInt(6, nroSerie);
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
                    JOptionPane.showMessageDialog(null, "No se pudo agendar una nueva cita");
                } else {
                    JOptionPane.showMessageDialog(null, "Nueva cita agendada");
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos"+ex.getMessage());
        }
    }
    
    public String buscarFechaCita(int dni){
        String sql = "SELECT fechaHoraCita FROM cita WHERE dni=? AND cancelada = 1";
        String cita = "";
        try(PreparedStatement ps = con.prepareStatement(sql)){
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cita = rs.getString("fechaHoraCita");
                
            }else{
                JOptionPane.showMessageDialog(null, "El ciudadano seleccionado no cuenta con Cita");
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos"+ex.getMessage());
        }
        return cita;
    }
    
    public void guardarCita (Cita cita) throws SQLIntegrityConstraintViolationException, SQLException{
        String sql = "INSERT INTO cita(codRefuerzo, fechaHoraCita, idVacunatorio, fechaHoraColoca, dni, nroSerie, cancelada) VALUES (?,?,?,null,?,?,1)";
        
        try (PreparedStatement ps = con.prepareStatement(sql)){;
            ps.setInt(1, cita.getCodRefuerzo());
            ps.setString(2, cita.getFechaHoraCita());
            ps.setInt(3, cita.getVacunatorio().getIdVacunatorio());
            ps.setInt(4, cita.getCiudadano().getDni());
            ps.setInt(5, cita.getVacuna().getNroSerie());
            
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                System.out.println("No se pudo insertar el registro.");
            } else {
                JOptionPane.showMessageDialog(null, "Nueva cita registrada");
            }
            
        } catch (SQLIntegrityConstraintViolationException ex) {
//            JOptionPane.showMessageDialog(null, "El Nro de Serie indicado ya se encuentra registrado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
    }
    
    public Cita buscarCita(int dni){

        String sql = "Select codCita, codRefuerzo, fechaHoraCita, idVacunatorio from cita where codCita = (SELECT MAX(codCita) FROM cita WHERE dni=? AND cancelada=1);";
        Cita cita = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cita = new Cita();
                cita.setCodCita(rs.getInt("codCita"));
                cita.setCodRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getString("fechaHoraCita"));
                cita.setVacunatorio(cvd.buscarVacunatorioId(rs.getInt("idVacunatorio")));
            } else {
                JOptionPane.showMessageDialog(null, "El ciudadano seleccionado no cuenta con Cita");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return cita;
    }
    
    public void confirmarAplicacion(int codCita){
        String upd = "UPDATE cita SET fechaHoraColoca = ? WHERE codCita = ?";
            Date fechaHoraActual = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHoraActualFormateada = sdf.format(fechaHoraActual);
            
        try {
            PreparedStatement ps = con.prepareStatement(upd);
            ps.setString(1, fechaHoraActualFormateada);
            ps.setInt(2, codCita);
            int registro = ps.executeUpdate();
            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Aplicacion confirmada");
            }
//            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cancelar la cita " + ex.getMessage());
        }
    }
    
   public String fechaHoraActual(){
       Date fechaHoraActual = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String fechaFormateada = sdf.format(fechaHoraActual);
       return fechaFormateada;
   }
    
    public void modificarCita(Cita cita){
        String upd = "UPDATE cita SET codRefuerzo=?, fechaHoraCita=?, idVacunatorio=? WHERE codCita = ?";
            
        try {
            PreparedStatement ps = con.prepareStatement(upd);
            ps.setInt(1, cita.getCodRefuerzo());
            ps.setString(2, cita.getFechaHoraCita());
            ps.setInt(3, cita.getVacunatorio().getIdVacunatorio());
            ps.setInt(4, cita.getCodCita());
            int registro = ps.executeUpdate();
            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "Cita modificada");
            }
//            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modifcar la cita " + ex.getMessage());
        }
    }
    
    public boolean verificarRefuerzo(int dni){
        String sql = "SELECT * FROM cita WHERE dni = ? AND codRefuerzo = 3 AND fechaHoraColoca IS NOT NULL";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos");
        }
        return true;
    }
    
    public List<Cita> DosisAplicadasXCentroXDia(String fecha) throws NullPointerException {
        List<Cita> citas = new ArrayList<>();
        String sql = "Select idVacunatorio, COUNT(fechaHoraColoca) as cantidad from cita WHERE STR_TO_DATE(fechaHoraCita, '%Y-%m-%d') = ? GROUP by idVacunatorio";
        Cita cita = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fecha);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cita = new Cita();
                cita.setVacunatorio(cvd.buscarVacunatorioId(rs.getInt("idVacunatorio")));
                cita.setCantDosis(rs.getInt("cantidad"));
                citas.add(cita);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos "+ex.getMessage());
        }
        return citas;
    }
    
    public List<Cita> consultaXCentroX(int IdVacunatorio) throws NullPointerException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT codCita, nroSerie, dni FROM cita WHERE idVacunatorio=? AND fechaHoraColoca IS NOT NULL";
        Cita cita = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, IdVacunatorio);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cita = new Cita();
                cita.setCodCita(rs.getInt("codCita"));
                cita.setVacuna(vacudata.buscarVacuna(rs.getInt("nroSerie")));
                cita.setCiudadano(ciudata.buscarCiudadanoDni(rs.getInt("dni")));
                citas.add(cita);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectase a la base de datos "+ex.getMessage());
        }
        return citas;
    }
}
