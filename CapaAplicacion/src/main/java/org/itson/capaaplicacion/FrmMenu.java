/**
 * FrmMenu.java creado el 13/05/2023.
 */
package org.itson.capaaplicacion;

import org.itson.control.ControlAplicacion;

/**
 * Esta clase se encarga de simular el menú de la aplicación.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class FrmMenu extends javax.swing.JFrame {

    ControlAplicacion controlAplicacion;
    
    /**
     * Método constructor que inicializa el frame.
     */
    public FrmMenu() {
        initComponents();
        controlAplicacion = new ControlAplicacion();
        this.setLocationRelativeTo(null);
        this.btnVerOfertas.setEnabled(false);
    }
    
    /**
     * Método que abre la ventana para registrar una orden de traslado.
     */
    private void abrirVentanaRegistrarTraslado(){
        FrmRegistrarTraslado frm = new FrmRegistrarTraslado(controlAplicacion);
        frm.setVisible(true);
        this.setVisible(false);
    }
    
    /**
     * Método que abre la ventana para ver las ordenes de traslado.
     */
    private void abrirVentanaVerOrdenes(){
        FrmVerOrdenes frm = new FrmVerOrdenes();
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

        jplFondoGeneral = new javax.swing.JPanel();
        jplFondoSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jplFondoMenu = new javax.swing.JPanel();
        btnRegistrarTraslado = new javax.swing.JButton();
        btnOrdenes = new javax.swing.JButton();
        btnVerOfertas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");
        setResizable(false);

        jplFondoGeneral.setBackground(new java.awt.Color(232, 233, 217));
        jplFondoGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplFondoSuperior.setBackground(new java.awt.Color(4, 80, 40));

        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productor");

        javax.swing.GroupLayout jplFondoSuperiorLayout = new javax.swing.GroupLayout(jplFondoSuperior);
        jplFondoSuperior.setLayout(jplFondoSuperiorLayout);
        jplFondoSuperiorLayout.setHorizontalGroup(
            jplFondoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplFondoSuperiorLayout.createSequentialGroup()
                .addContainerGap(156, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(159, 159, 159))
        );
        jplFondoSuperiorLayout.setVerticalGroup(
            jplFondoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplFondoSuperiorLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(16, 16, 16))
        );

        jplFondoGeneral.add(jplFondoSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 70));

        jplFondoMenu.setBackground(new java.awt.Color(20, 174, 92));

        btnRegistrarTraslado.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnRegistrarTraslado.setText("Registrar traslado");
        btnRegistrarTraslado.setBorder(null);
        btnRegistrarTraslado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarTrasladoActionPerformed(evt);
            }
        });

        btnOrdenes.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnOrdenes.setText("Ver ordenes de traslado solicitadas");
        btnOrdenes.setBorder(null);
        btnOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenesActionPerformed(evt);
            }
        });

        btnVerOfertas.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnVerOfertas.setText("Ver ofertas traslado");
        btnVerOfertas.setBorder(null);

        javax.swing.GroupLayout jplFondoMenuLayout = new javax.swing.GroupLayout(jplFondoMenu);
        jplFondoMenu.setLayout(jplFondoMenuLayout);
        jplFondoMenuLayout.setHorizontalGroup(
            jplFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondoMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jplFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVerOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jplFondoMenuLayout.setVerticalGroup(
            jplFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondoMenuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnRegistrarTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jplFondoGeneral.add(jplFondoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 340, 160));

        btnSalir.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jplFondoGeneral.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 279, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplFondoGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jplFondoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de salir.
     * @param evt El objeto ActionEvent que representa el evento del botón de salir.
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de registrar traslado.
     * Llama un método para abrir la ventana de registrar traslado.
     * @param evt El objeto ActionEvent que representa el evento del botón de registrar traslado.
     */
    private void btnRegistrarTrasladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarTrasladoActionPerformed
      abrirVentanaRegistrarTraslado();
    }//GEN-LAST:event_btnRegistrarTrasladoActionPerformed

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de ver ordenes de traslado.
     * Llama un método para abrir la ventana de ver ordenes de traslado.
     * @param evt El objeto ActionEvent que representa el evento del botón de ver ordenes de traslado.
     */
    private void btnOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenesActionPerformed
        abrirVentanaVerOrdenes();
    }//GEN-LAST:event_btnOrdenesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrdenes;
    private javax.swing.JButton btnRegistrarTraslado;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerOfertas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jplFondoGeneral;
    private javax.swing.JPanel jplFondoMenu;
    private javax.swing.JPanel jplFondoSuperior;
    // End of variables declaration//GEN-END:variables
}
