/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo29.tema5.Vistas;

import equipo29.tema5.Conexion.CitaData;
import equipo29.tema5.Conexion.CiudadanoData;
import equipo29.tema5.Conexion.LaboratorioData;
import equipo29.tema5.Conexion.VacunaData;
import equipo29.tema5.Conexion.VacunatorioData;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Bruce
 */
public class PantallaPrincipal extends javax.swing.JFrame {

    private CiudadanoData cd;
    private CitaData citad;
    private LaboratorioData ld;
    private VacunaData vd;
    private VacunatorioData cvd;

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        cd = new CiudadanoData();
        citad = new CitaData();
        ld = new LaboratorioData();
        vd = new VacunaData();
        cvd = new VacunatorioData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/fondoApp.jpg"));
        Image image = icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        BotonPC = new javax.swing.JButton();
        BotonAdmin = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonPC.setText("PORTAL CIUDADANO");
        BotonPC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPCActionPerformed(evt);
            }
        });

        BotonAdmin.setText("ADMIN");
        BotonAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAdminActionPerformed(evt);
            }
        });

        salir.setText("SALIR");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salir)
                .addGap(55, 55, 55))
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonPC, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(294, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addComponent(BotonPC, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(BotonAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(salir)
                .addGap(31, 31, 31))
        );
        escritorio.setLayer(BotonPC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(BotonAdmin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(salir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonPCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPCActionPerformed
        // TODO add your handling code here:
        //escritorio.removeAll();
        escritorio.repaint();
        PortalCiudadano pc = new PortalCiudadano(cd, citad);
        pc.setLocation((escritorio.getWidth() - pc.getWidth())/2, (escritorio.getHeight() - pc.getHeight())/2);
        pc.setVisible(true);
        escritorio.add(pc);
        escritorio.moveToFront(pc);
    }//GEN-LAST:event_BotonPCActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void BotonAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAdminActionPerformed
        // TODO add your handling code here:
        escritorio.repaint();
        Contraseña pass = new Contraseña();
        pass.setLocation((escritorio.getWidth() - pass.getWidth())/2, (escritorio.getHeight() - pass.getHeight())/2);
        pass.setVisible(true);
        escritorio.add(pass);
        escritorio.moveToFront(pass);
    }//GEN-LAST:event_BotonAdminActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAdmin;
    private javax.swing.JButton BotonPC;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

    public void cargaPantallaAdmin() {
        escritorio.repaint();
        PortalAdministracion pa = new PortalAdministracion(ld, vd, citad, cd, cvd);
        pa.setVisible(true);
        escritorio.add(pa);
        escritorio.moveToFront(pa);
    }
    
}
