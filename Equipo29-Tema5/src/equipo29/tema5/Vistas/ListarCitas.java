/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equipo29.tema5.Vistas;

import equipo29.tema5.Conexion.CitaData;
import equipo29.tema5.Data.Cita;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juanma
 */
public class ListarCitas extends javax.swing.JInternalFrame {
    private List<Cita> citas = new ArrayList<>();
    private CitaData citad;
    private Cita cita;
    private DefaultTableModel modelo = new DefaultTableModel() { //Sobreescribimos un método de DefaultTableModel para que las celdas no sean editables
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    /**
     * Creates new form ListarCitas
     */
    public ListarCitas(CitaData citad) {
        initComponents();
        this.citad=citad;
        this.cita = cita;
        armarComboMes();
        armarCabecera();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cumplidas = new javax.swing.JCheckBox();
        canceladas = new javax.swing.JCheckBox();
        vencidas = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        salir = new javax.swing.JButton();
        buscar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();

        setTitle("Reporte de citas segun mes");

        jLabel1.setText("Mes");

        cumplidas.setText("Cumplidas");

        canceladas.setText("Canceladas");

        vencidas.setText("Vencidas");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        limpiar.setText("Limpiar ");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buscar)
                .addGap(38, 38, 38)
                .addComponent(limpiar)
                .addGap(51, 51, 51)
                .addComponent(salir)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(cumplidas)
                .addGap(27, 27, 27)
                .addComponent(canceladas)
                .addGap(18, 18, 18)
                .addComponent(vencidas)
                .addContainerGap(242, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cumplidas)
                    .addComponent(canceladas)
                    .addComponent(vencidas)
                    .addComponent(jLabel1)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salir)
                    .addComponent(buscar)
                    .addComponent(limpiar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        // TODO add your handling code here:
        if((cumplidas.isSelected() && canceladas.isSelected()) || (cumplidas.isSelected() && vencidas.isSelected()) || (canceladas.isSelected() && vencidas.isSelected())){
               JOptionPane.showMessageDialog(null, "Seleccione 1 solo tipo de listado a consultar"); 
            }else if (!mes.getSelectedItem().toString().isEmpty()) {
            if(cumplidas.isSelected()){
                citas = citad.buscarCitasCumplidas(mes.getSelectedItem().toString());
                borrarFilas();
                Collections.sort(citas);
                cargarDatos(citas);
            }else if(canceladas.isSelected()){
                citas = citad.buscarCitasCanceladas(mes.getSelectedItem().toString());
                borrarFilas();
                Collections.sort(citas);
                cargarDatos(citas);
            }else{
                citas = citad.buscarCitasVencidas(mes.getSelectedItem().toString());
                borrarFilas();
                Collections.sort(citas);
                cargarDatos(citas);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un mes para realizar una busqueda");
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        // TODO add your handling code here:
        armarComboMes();
        borrarFilas();
        cumplidas.setSelected(false);
        canceladas.setSelected(false);
        vencidas.setSelected(false);
    }//GEN-LAST:event_limpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JCheckBox canceladas;
    private javax.swing.JCheckBox cumplidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla;
    private javax.swing.JCheckBox vencidas;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("C. Cita");
        modelo.addColumn("C. Refuerzo");
        modelo.addColumn("F. Cita");
        modelo.addColumn("Vacunatorio");
        modelo.addColumn("F. Colocada");
        modelo.addColumn("Ciudadano");
        modelo.addColumn("N. Serie");
        modelo.addColumn("Cancelada");
        tabla.setModel(modelo);
//        tabla.getColumnModel().getColumn(1).setMaxWidth(0);
//        tabla.getColumnModel().getColumn(1).setMinWidth(0);
//        tabla.getColumnModel().getColumn(1).setPreferredWidth(0);
//        tabla.getColumnModel().getColumn(1).setResizable(false);
//        tabla.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(1).setResizable(false);
//        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
//        tabla.getColumnModel().getColumn(4).setMinWidth(0);
//        tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
//        tabla.getColumnModel().getColumn(4).setResizable(false);
//        tabla.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(4).setResizable(false);
//        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
//        tabla.getColumnModel().getColumn(5).setMinWidth(0);
//        tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
//        tabla.getColumnModel().getColumn(5).setResizable(false);
//        tabla.getTableHeader().getColumnModel().getColumn(5).setMaxWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(5).setMinWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(5).setResizable(false);
//        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
//        tabla.getColumnModel().getColumn(6).setMinWidth(0);
//        tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
//        tabla.getColumnModel().getColumn(6).setResizable(false);
//        tabla.getTableHeader().getColumnModel().getColumn(6).setMaxWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(6).setMinWidth(0);
//        tabla.getTableHeader().getColumnModel().getColumn(6).setResizable(false);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(7).setResizable(false);
        tabla.getTableHeader().getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getTableHeader().getColumnModel().getColumn(7).setResizable(false);
    }
    
     private void borrarFilas() {
        int f = tabla.getRowCount() - 1;
        for (; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void cargarDatos(List<Cita> citas) { //Esta lista de alumnos puede provenir de la BD o cargada por parámetros
        for (Cita cita : citas) {
            modelo.addRow(new Object[]{cita.getCodCita(), cita.getCodRefuerzo(), cita.getFechaHoraCita(), cita.getVacunatorio().getDescripcion(), cita.getFechaHoraColoca(), cita.getCiudadano().getDni()+"-"+cita.getCiudadano().getNombreCompleto(), cita.getVacuna().getNroSerie()});
        }
    }
    
    private void armarComboMes() {
        mes.removeAllItems();
        mes.addItem("");
        mes.addItem("01");
        mes.addItem("02");
        mes.addItem("03");
        mes.addItem("04");
        mes.addItem("05");
        mes.addItem("06");
        mes.addItem("07");
        mes.addItem("08");
        mes.addItem("09");
        mes.addItem("10");
        mes.addItem("11");
        mes.addItem("12");
    }
}
