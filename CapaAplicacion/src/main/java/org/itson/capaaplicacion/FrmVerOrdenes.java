/**
 * Clase FrmVerOrdenes.java creada el 13/05/2023.
 */
package org.itson.capaaplicacion;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.itson.control.ControlAplicacion;
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Residuo;

/**
 * Esta clase se encarga de simular el ver ordenes traslado de la aplicación.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class FrmVerOrdenes extends javax.swing.JFrame {

    ControlAplicacion controlAplicacion;
   
    /**
     * Método constructor que inicializa el frame.
     */
    public FrmVerOrdenes() {
        initComponents();
        this.controlAplicacion = new ControlAplicacion();
        this.setLocationRelativeTo(null);
        cargarTablaOrdenes();
    }
    /**
     * Método que cierra el frame y te manda al frame del menú.
     */
    private void regresarMenu(){
        FrmMenu frm = new FrmMenu();
        frm.setVisible(true);
        this.setVisible(false);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplFondoSuperior = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jplFondoGeneral = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrdenesTraslado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSalir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jplFondoSuperior.setBackground(new java.awt.Color(4, 80, 40));

        jLabel2.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ver ordenes de traslado");

        javax.swing.GroupLayout jplFondoSuperiorLayout = new javax.swing.GroupLayout(jplFondoSuperior);
        jplFondoSuperior.setLayout(jplFondoSuperiorLayout);
        jplFondoSuperiorLayout.setHorizontalGroup(
            jplFondoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplFondoSuperiorLayout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(262, 262, 262))
        );
        jplFondoSuperiorLayout.setVerticalGroup(
            jplFondoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondoSuperiorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jplFondoGeneral.setBackground(new java.awt.Color(232, 233, 217));
        jplFondoGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSalir.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnSalir.setText("Filtrar");
        btnSalir.setBorder(null);
        btnSalir.setEnabled(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jplFondoGeneral.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 110, 30));

        tblOrdenesTraslado.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 12)); // NOI18N
        tblOrdenesTraslado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Residuo", "Cantidad", "Unidad", "Precio base", "Destino"
            }
        ));
        jScrollPane1.setViewportView(tblOrdenesTraslado);

        jplFondoGeneral.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 600, 230));

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        jLabel1.setText("Residuo");
        jplFondoGeneral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 110, 30));

        jTextField1.setEnabled(false);
        jplFondoGeneral.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 110, -1));

        jLabel3.setBackground(new java.awt.Color(4, 80, 40));
        jLabel3.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(4, 80, 40));
        jLabel3.setText("Filtrar por");
        jplFondoGeneral.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        btnSalir1.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnSalir1.setText("Volver");
        btnSalir1.setBorder(null);
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jplFondoGeneral.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplFondoSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jplFondoGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jplFondoSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 254, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jplFondoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de salir.
     * Manda a llamar un método para regresar al salir.
     * @param evt El objeto ActionEvent que representa el evento del botón de salir.
     */
    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
       regresarMenu();
    }//GEN-LAST:event_btnSalir1ActionPerformed
    
    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de salir.
     * Manda a llamar un método para regresar al salir.
     * @param evt El objeto ActionEvent que representa el evento del botón de salir.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed
    
    /**
     * Este método carga la tabla de las ordenes de traslado.
     */
    private void cargarTablaOrdenes(){
        List<OrdenTraslado> datos = controlAplicacion.consultarOrdenesTraslado();
        
        DefaultTableModel modelo = (DefaultTableModel) tblOrdenesTraslado.getModel();
        modelo.setRowCount(0);
        Residuo residuo;
        Destino destino;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (OrdenTraslado ot : datos) {
            residuo = controlAplicacion.consultarResiduo(ot.getIdResiduo());
            destino = controlAplicacion.consultarDestino(ot.getIdDestino());
            String fechaLimite = ot.getFecha_limite().format(formatter); 
            Object[] fila = {fechaLimite,residuo.getNombre(),ot.getCantidad(),residuo.getUnidadMedida(),ot.getPrecio(),destino.getCiudad()};
            modelo.addRow(fila);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel jplFondoGeneral;
    private javax.swing.JPanel jplFondoSuperior;
    private javax.swing.JTable tblOrdenesTraslado;
    // End of variables declaration//GEN-END:variables
}
