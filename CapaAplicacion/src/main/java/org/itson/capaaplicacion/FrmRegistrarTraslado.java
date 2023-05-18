/**
 * Clase FrmRegistrarTraslado.java creada el 13/05/2023.
 */
package org.itson.capaaplicacion;


import java.awt.Font;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import org.itson.control.ControlAplicacion;
import org.itson.dominio.Destino;
import org.itson.dominio.OrdenTraslado;
import org.itson.dominio.Productor;
import org.itson.dominio.Residuo;
import org.itson.excepciones.PersistenciaException;

/**
 * Esta clase se encarga de simular el registrar traslado de la aplicación.
 * @author Equipo 3 
 * Luis Pablo Ayón Figueroa
 * Mario Díaz Padilla
 * Gabriel Alberto Mancinas Cota
 * Ángel de Jesús Valenzuela García
 */
public class FrmRegistrarTraslado extends javax.swing.JFrame {
    ControlAplicacion controlAplicacion;
    private Productor productor;
    
    /**
     * Método constructor que inicializa el frame.
     * @param controlAplicacion parámetro que controla la aplicación.
     */
    public FrmRegistrarTraslado(ControlAplicacion controlAplicacion) {
        initComponents();
        this.controlAplicacion = new ControlAplicacion();
        configurarDatePicker();
        productor = controlAplicacion.obtenerProductor(controlAplicacion.getProductor().getId());
        controlAplicacion.llenarComboBoxListaResiduos(productor.getId(),cbxResiduos);
        controlAplicacion.llenarComboBoxListaDestinos(productor.getId(),cbxDestinos);
        txtKM.setEditable(false);
        this.setLocationRelativeTo(null);
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
     * Método para validar números en un campo de texto.
     *
     * @param evt KeyEvent del textfield.
     * @param txt Textfield con el contenido.
     */
    private void validarNumeros(KeyEvent evt, JTextField txt) {
        char c = evt.getKeyChar();
        String text = txt.getText();

        if (!Character.isDigit(c) && c != '.' && c != evt.VK_BACK_SPACE) {
            evt.consume(); // Ignorar el carácter no válido
        } else if ((text.isEmpty() || text.equals("0")) && c == '0') {
            evt.consume(); // Ignorar el 0 como primer carácter
        } else if (c == '.' && (text.isEmpty() || text.equals("0"))) {
            evt.consume(); // Ignorar el punto como primer carácter
        } else if (text.length() >= 7) {
            evt.consume(); // Ignorar la entrada si se alcanza la longitud máxima de 10 caracteres
        } else if (c == '.' && text.contains(".")) {
            // Verificar que no haya más de un punto
            int dotIndex = text.indexOf('.');
            if (text.substring(dotIndex).contains(".")) {
                evt.consume(); // Ignorar el segundo punto
            }
        }
    }
    /**
     * Método para mostrar un mensaje en un JOptionPane.
     * @param mensaje Mensaje a mostrar.
     * @param titulo Titulo de JOPtionPane.
     */
    public void mostrarMensaje(String mensaje, String titulo) {
    UIManager.put("OptionPane.background", new ColorUIResource(20,174,92));
    UIManager.put("Panel.background", new ColorUIResource(20,174,92));
    UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Myanmar Text", Font.BOLD, 16)));
    JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.PLAIN_MESSAGE);
    }
    /**
     * Metodo que asigna la unidad de medida del residuo al texto para mostrarlo.
     * @param evt evento de cambio de item por parte del combobox.
     */
    public void asignarUnidad(java.awt.event.ItemEvent evt){
        Residuo residuo = (Residuo) evt.getItem();
        txtUnidadMedida.setText(residuo.getUnidadMedida().toString());
    }
    
    /**
     * Método de evento que inserta la distancia al campo de texto del destino que se elige en el combobox.
     * @param evt El objeto ItemEvent que representa el evento del combobox del destino.
     */
    public void asignarDistancia(java.awt.event.ItemEvent evt){
        Destino distancia = (Destino)evt.getItem();
        txtKM.setText(distancia.getDistancia()+"");
    }
    
    /**
     * Método que extrae los datos del formulario para crear la orden de traslado.
     * @return Orden de traslado.
     */
    public OrdenTraslado extraerDatos(){
        Residuo residuo = (Residuo) cbxResiduos.getSelectedItem();
        float cantidad = Float.parseFloat(txtCantidad.getText());
        LocalDateTime fechaOrden = LocalDateTime.now();
        LocalDateTime fechaLimite = LocalDateTime.of(dpFechaTraslado.getDate(), LocalTime.MIN);
        Destino destino = (Destino) cbxDestinos.getSelectedItem();
        float precio = Float.parseFloat(txtPresupuesto.getText());
        String tratamiento = txtTratamiento.getText();
       
        OrdenTraslado orden = new OrdenTraslado(tratamiento, fechaOrden, fechaLimite, cantidad, residuo.getId(), destino.getId(), productor.getId(), precio);
        return orden;
    }
    
    /**
     * Método que valida si algún campo del formulario está vacio.
     * @return Verdadero si hay algún campo vacio, falso en caso contrario.
     */
    private boolean esAlgunCampoVacio(){
        return     txtCantidad.getText().isEmpty() 
                || txtKM.getText().isEmpty() 
                || txtPresupuesto.getText().isEmpty() 
                || txtUnidadMedida.getText().isEmpty() 
                || dpFechaTraslado.getText().isEmpty()
                ||  txtTratamiento.getText().isEmpty();
    }
    
    /**
     * Método que configura el date picker para que tenga un rango de selección
     * de fechas.
     */
    private void configurarDatePicker() {
        LocalDate fechaActual = LocalDate.now();
        LocalDate minFecha = LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), fechaActual.getDayOfMonth());
        dpFechaTraslado.getSettings().setDateRangeLimits(minFecha, LocalDate.MAX);
        dpFechaTraslado.getComponentDateTextField().setEnabled(false);
        dpFechaTraslado.getComponentDateTextField().setEnabled(false);
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
        jplFondo1 = new javax.swing.JPanel();
        lblResiduoTrasladar = new javax.swing.JLabel();
        lblCantidadTrasladar = new javax.swing.JLabel();
        cbxResiduos = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        lblUnidadDeMedida = new javax.swing.JLabel();
        txtUnidadMedida = new javax.swing.JTextField();
        btnSolicitar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jplFondo2 = new javax.swing.JPanel();
        lblFechaTraslado = new javax.swing.JLabel();
        dpFechaTraslado = new com.github.lgooddatepicker.components.DatePicker();
        lblDestino = new javax.swing.JLabel();
        cbxDestinos = new javax.swing.JComboBox<>();
        lblKM = new javax.swing.JLabel();
        txtPresupuesto = new javax.swing.JTextField();
        lblPresupuesto1 = new javax.swing.JLabel();
        txtKM = new javax.swing.JTextField();
        lblTratamiento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTratamiento = new javax.swing.JTextArea();
        lblInformacionSolicitud = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú");
        setResizable(false);

        jplFondoGeneral.setBackground(new java.awt.Color(232, 233, 217));
        jplFondoGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplFondoSuperior.setBackground(new java.awt.Color(4, 80, 40));

        jLabel1.setText("Registrar traslado");
        jLabel1.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jplFondoSuperiorLayout = new javax.swing.GroupLayout(jplFondoSuperior);
        jplFondoSuperior.setLayout(jplFondoSuperiorLayout);
        jplFondoSuperiorLayout.setHorizontalGroup(
            jplFondoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplFondoSuperiorLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(139, 139, 139))
        );
        jplFondoSuperiorLayout.setVerticalGroup(
            jplFondoSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplFondoSuperiorLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );

        jplFondoGeneral.add(jplFondoSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 70));

        jplFondo1.setBackground(new java.awt.Color(20, 174, 92));

        lblResiduoTrasladar.setText("Residuo a trasladar");
        lblResiduoTrasladar.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        lblResiduoTrasladar.setForeground(new java.awt.Color(255, 255, 255));

        lblCantidadTrasladar.setText("Cantidad a trasladar");
        lblCantidadTrasladar.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        lblCantidadTrasladar.setForeground(new java.awt.Color(255, 255, 255));

        cbxResiduos.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        cbxResiduos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxResiduosItemStateChanged(evt);
            }
        });

        txtCantidad.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        lblUnidadDeMedida.setText("Unidad de medida");
        lblUnidadDeMedida.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        lblUnidadDeMedida.setForeground(new java.awt.Color(255, 255, 255));

        txtUnidadMedida.setEditable(false);

        javax.swing.GroupLayout jplFondo1Layout = new javax.swing.GroupLayout(jplFondo1);
        jplFondo1.setLayout(jplFondo1Layout);
        jplFondo1Layout.setHorizontalGroup(
            jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblCantidadTrasladar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblResiduoTrasladar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblUnidadDeMedida, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxResiduos, 0, 211, Short.MAX_VALUE)
                    .addComponent(txtCantidad)
                    .addComponent(txtUnidadMedida))
                .addContainerGap())
        );
        jplFondo1Layout.setVerticalGroup(
            jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResiduoTrasladar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxResiduos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadTrasladar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jplFondo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUnidadDeMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jplFondoGeneral.add(jplFondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 420, 110));

        btnSolicitar.setText("Solicitar");
        btnSolicitar.setBorder(null);
        btnSolicitar.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });
        jplFondoGeneral.add(btnSolicitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 70, 30));

        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jplFondoGeneral.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 80, 30));

        jplFondo2.setBackground(new java.awt.Color(175, 244, 198));

        lblFechaTraslado.setText("Fecha del traslado");
        lblFechaTraslado.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N

        dpFechaTraslado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dpFechaTrasladoKeyTyped(evt);
            }
        });

        lblDestino.setText("Destino");
        lblDestino.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N

        cbxDestinos.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        cbxDestinos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxDestinosItemStateChanged(evt);
            }
        });

        lblKM.setText("Cantidad de KM");
        lblKM.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N

        txtPresupuesto.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txtPresupuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresupuestoKeyTyped(evt);
            }
        });

        lblPresupuesto1.setText("Presupuesto base");
        lblPresupuesto1.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N

        lblTratamiento.setText("Tratamiento");
        lblTratamiento.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N

        txtTratamiento.setColumns(20);
        txtTratamiento.setRows(5);
        txtTratamiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTratamientoKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtTratamiento);

        javax.swing.GroupLayout jplFondo2Layout = new javax.swing.GroupLayout(jplFondo2);
        jplFondo2.setLayout(jplFondo2Layout);
        jplFondo2Layout.setHorizontalGroup(
            jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jplFondo2Layout.createSequentialGroup()
                        .addComponent(lblTratamiento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(jplFondo2Layout.createSequentialGroup()
                        .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDestino)
                            .addComponent(lblPresupuesto1)
                            .addComponent(lblKM))
                        .addGap(54, 54, 54)
                        .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPresupuesto)
                            .addComponent(txtKM)
                            .addComponent(cbxDestinos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jplFondo2Layout.createSequentialGroup()
                        .addComponent(lblFechaTraslado)
                        .addGap(49, 49, 49)
                        .addComponent(dpFechaTraslado, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jplFondo2Layout.setVerticalGroup(
            jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jplFondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpFechaTraslado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxDestinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKM, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPresupuesto1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jplFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplFondo2Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(lblTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)))
                .addContainerGap())
        );

        jplFondoGeneral.add(jplFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 420, 220));

        lblInformacionSolicitud.setText("Información de solicitud");
        lblInformacionSolicitud.setFont(new java.awt.Font("Myanmar Text", 1, 18)); // NOI18N
        jplFondoGeneral.add(lblInformacionSolicitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 220, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplFondoGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jplFondoGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de solicitar.
     * Valida genera el orden de traslado.
     * @param evt El objeto ActionEvent que representa el evento del botón de solicitar.
     */
    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        if (esAlgunCampoVacio()) {
            JOptionPane.showMessageDialog(null, "No deje ningún campo vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (controlAplicacion.registrarOrdenTraslado(extraerDatos())) {
                    mostrarMensaje("Registro éxitoso", "éxito");
                    regresarMenu();
                }else{
                    mostrarMensaje("No se pudo registrar el traslado", "info");
                    regresarMenu();
                }
            } catch (PersistenciaException ex) {
                this.mostrarMensaje(ex.getMessage(), "info");
            }
        }
    }//GEN-LAST:event_btnSolicitarActionPerformed

    /**
     * Método de evento que se ejecuta cuando el usuario presiona el botón de volver.
     * Manda a llamar un método para regresar al menú.
     * @param evt El objeto ActionEvent que representa el evento del botón de volver.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * Método de evento que se ejecuta cuando el usuario presiona teclas.
     * Manda a llamar un método para validar el campo de texto.
     * @param evt El objeto KeyTyped que valida la escritura.
     */
    private void txtPresupuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresupuestoKeyTyped
       validarNumeros(evt,txtPresupuesto);
    }//GEN-LAST:event_txtPresupuestoKeyTyped

    /**
     * Método de evento que se ejecuta cuando el usuario presiona teclas.
     * Manda a llamar un método para validar el campo de texto.
     * @param evt El objeto KeyTyped que valida la escritura.
     */
    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
      validarNumeros(evt,txtCantidad);
    }//GEN-LAST:event_txtCantidadKeyTyped

    /**
     * Método de evento que actualiza el campo de texto de unidad de medida del valor que se elige en el combobox.
     * @param evt El objeto ItemEvent que representa el evento del combobox.
     */
    private void cbxResiduosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxResiduosItemStateChanged
        asignarUnidad(evt);
    }//GEN-LAST:event_cbxResiduosItemStateChanged

    /**
     * Método de evento que se ejecuta cuando el usuario presiona teclas.
     * Manda a llamar un método para validar el campo de texto.
     * @param evt El objeto KeyTyped que valida la escritura.
     */
    private void dpFechaTrasladoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dpFechaTrasladoKeyTyped
        evt.consume();
    }//GEN-LAST:event_dpFechaTrasladoKeyTyped

    /**
     * Método de evento que se ejecuta cuando el usuario presiona teclas.
     * Manda a llamar un método para validar el campo de texto.
     * @param evt El objeto KeyTyped que valida la escritura.
     */
    private void txtTratamientoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTratamientoKeyTyped
        char c = evt.getKeyChar();
        if (txtTratamiento.getText().length() >= 100 || !Character.isLetterOrDigit(c) && c != ',' && c != '.' && !Character.isWhitespace(c)) {
            evt.consume(); // Ignorar el evento si se alcanzó el límite de 100 caracteres o el carácter no es válido
        }
    }//GEN-LAST:event_txtTratamientoKeyTyped

    /**
     * Método de evento que actualiza el campo de texto de distancia del valor que se elige en el combobox.
     * @param evt El objeto ItemEvent que representa el evento del combobox.
     */
    private void cbxDestinosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxDestinosItemStateChanged
        asignarDistancia(evt);
    }//GEN-LAST:event_cbxDestinosItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxDestinos;
    private javax.swing.JComboBox<Residuo> cbxResiduos;
    private com.github.lgooddatepicker.components.DatePicker dpFechaTraslado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jplFondo1;
    private javax.swing.JPanel jplFondo2;
    private javax.swing.JPanel jplFondoGeneral;
    private javax.swing.JPanel jplFondoSuperior;
    private javax.swing.JLabel lblCantidadTrasladar;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblFechaTraslado;
    private javax.swing.JLabel lblInformacionSolicitud;
    private javax.swing.JLabel lblKM;
    private javax.swing.JLabel lblPresupuesto1;
    private javax.swing.JLabel lblResiduoTrasladar;
    private javax.swing.JLabel lblTratamiento;
    private javax.swing.JLabel lblUnidadDeMedida;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtKM;
    private javax.swing.JTextField txtPresupuesto;
    private javax.swing.JTextArea txtTratamiento;
    private javax.swing.JTextField txtUnidadMedida;
    // End of variables declaration//GEN-END:variables
}
