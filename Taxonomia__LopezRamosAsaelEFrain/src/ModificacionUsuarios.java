
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.UUID;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author roscr
 */
public class ModificacionUsuarios extends javax.swing.JFrame {
    private InfoCurrentUser infoUsuarioActual;//usuario actual
    
    public ModificacionUsuarios(InfoCurrentUser infoUsuarioActual) {
        this.infoUsuarioActual = infoUsuarioActual; //usuario actual
        initComponents();
        this.setLocationRelativeTo(null);
        
        mostrarRoles();
        mostrarUsuarios();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        agregarButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        idPersonaDelete = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idPersonaText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        idRolText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cancelDelete = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRoles = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MODIFICAR PRODUCTOS");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setName("frmModificarProducto"); // NOI18N
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBackground(new java.awt.Color(197, 217, 192));

        tablaUsuarios.setBackground(new java.awt.Color(128, 167, 191));
        tablaUsuarios.setForeground(new java.awt.Color(0, 0, 51));
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Usuario", "Nombre", "ID Persona", "Email", "Rol", "ID Rol"
            }
        ));
        tablaUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        tablaUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaUsuarios.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tablaUsuarios.setFocusable(false);
        tablaUsuarios.setOpaque(false);
        tablaUsuarios.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tablaUsuarios = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        tablaUsuarios.getTableHeader().setResizingAllowed(false);
        tablaUsuarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaUsuarios);
        if (tablaUsuarios.getColumnModel().getColumnCount() > 0) {
            tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(400);
            tablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(2);
        }

        jButton1.setBackground(new java.awt.Color(0, 0, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Actualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        agregarButton.setBackground(new java.awt.Color(0, 204, 51));
        agregarButton.setForeground(new java.awt.Color(0, 0, 0));
        agregarButton.setText("Agregar Usuario");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nuevo rol");

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nueva Contraseña");

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nuevo email");

        btnModificar.setBackground(new java.awt.Color(0, 0, 204));
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Actualizar");
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(255, 0, 51));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Eliminar Usuario");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Persona");

        idPersonaDelete.setBackground(new java.awt.Color(179, 185, 192));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Editar Usuario");

        idPersonaText.setBackground(new java.awt.Color(179, 185, 192));
        idPersonaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idPersonaTextActionPerformed(evt);
            }
        });

        emailText.setBackground(new java.awt.Color(179, 185, 192));

        idRolText.setBackground(new java.awt.Color(179, 185, 192));

        passwordText.setBackground(new java.awt.Color(179, 185, 192));

        Eliminar.setBackground(new java.awt.Color(255, 0, 51));
        Eliminar.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nuevo nombre");

        cancelDelete.setBackground(new java.awt.Color(255, 153, 0));
        cancelDelete.setForeground(new java.awt.Color(255, 255, 255));
        cancelDelete.setText("Cancelar");
        cancelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDeleteActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 0, 51));
        backButton.setForeground(new java.awt.Color(255, 255, 255));
        backButton.setText("Atras");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID Persona");

        nombreText.setBackground(new java.awt.Color(179, 185, 192));
        nombreText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idRolText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159)
                        .addComponent(btnModificar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(60, 60, 60)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idPersonaText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cancelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(idPersonaDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(idPersonaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idRolText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(btnModificar))
                .addGap(45, 45, 45)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idPersonaDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelDelete)
                    .addComponent(Eliminar))
                .addGap(24, 24, 24))
        );

        tablaRoles.setBackground(new java.awt.Color(128, 167, 191));
        tablaRoles.setForeground(new java.awt.Color(0, 0, 51));
        tablaRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Rol", "Nombre Rol"
            }
        ));
        tablaRoles.getTableHeader().setResizingAllowed(false);
        tablaRoles.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tablaRoles);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(195, 195, 195))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idPersonaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idPersonaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idPersonaTextActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        modificarUsuario();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        eliminarUsuario();
    }//GEN-LAST:event_EliminarActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        Menu newframe = new Menu(infoUsuarioActual);
        newframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        idPersonaText.setText("");
        passwordText.setText("");
        emailText.setText("");
        idRolText.setText("");
        idPersonaDelete.setText("");
        nombreText.setText("");
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cancelDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDeleteActionPerformed
        // TODO add your handling code here:
        idPersonaText.setText("");
        passwordText.setText("");
        emailText.setText("");
        idRolText.setText("");
        idPersonaDelete.setText("");
        nombreText.setText("");
    }//GEN-LAST:event_cancelDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        mostrarUsuarios();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        AgregarUsuario frameActual = new AgregarUsuario();
        frameActual.setVisible(true);
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void nombreTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextActionPerformed
    
    private void eliminarUsuario() {
        String idPersona = idPersonaDelete.getText(); 

        if (idPersona.equals("")) {
            JOptionPane.showMessageDialog(this, "ID incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        int intIdPersona = 0;
        intIdPersona = Integer.parseInt(idPersona);
        
        try {
            intIdPersona = Integer.parseInt(idPersona);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        //System.out.println("user actual: "+infoUsuarioActual.getCorreo()+","+infoUsuarioActual.getIdPersona());
        
        if (intIdPersona == infoUsuarioActual.getIdPersona()) {
            JOptionPane.showMessageDialog(this, "No puedes eliminar tu propia cuenta.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // mostrar mensaje para confirmar la eliminacion del usuario
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            //consulta para contar registros donde exista id
            String checkSql = "SELECT COUNT(*) FROM usuario WHERE id_persona = ?";

            try (Connection conexion = new ConexionBD().getConnection(); 
            
            //ejecutar consulta con prepared statement para verificar si hay coincidencias con id
            PreparedStatement checkStatement = conexion.prepareStatement(checkSql)) {
                
                //Guardar en el result set los resultados de la consulta usando el id ingresado
                checkStatement.setInt(1, intIdPersona);
                ResultSet rs = checkStatement.executeQuery();
                
                //verificar si el conteo en la consulta es mayor a cero, si es mayor existe el id y se elimina
                if (rs.next() && rs.getInt(1) > 0) {
                    
                    String sql = "CALL eliminar_usuario(?)";

                    try (CallableStatement callableStatement = conexion.prepareCall(sql)) {
                        callableStatement.setInt(1, intIdPersona);
                        callableStatement.execute();
                        JOptionPane.showMessageDialog(this, "Usuario eliminado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    //la consulto no conto ninguna coincidencia
                    JOptionPane.showMessageDialog(this, "El ID no existe en la base de datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        idPersonaText.setText("");
        passwordText.setText("");
        emailText.setText("");
        idRolText.setText("");
        idPersonaDelete.setText("");
        nombreText.setText("");
    }


    private void modificarUsuario() {
        //obtener los campos de entrada
        String nombre = nombreText.getText().trim();
        String idPersonaStr = idPersonaText.getText().trim();
        String email = emailText.getText().trim();
        String idRolStr = idRolText.getText().trim();
        String contrasenia = new String(passwordText.getPassword()).trim();

        if (nombre.isEmpty() || idPersonaStr.isEmpty() || email.isEmpty() || idRolStr.isEmpty() || contrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sql = "CALL actualizar_usuario(?, ?, ?, ?, ?)";//procedimiento
        
        //convertir estos campos a enteros
        int idPersona = Integer.parseInt(idPersonaStr);
        int idRol = Integer.parseInt(idRolStr);

        try (Connection conexion = new ConexionBD().getConnection(); 
            
            //variable para hacer consulta ejecutable
            CallableStatement callableStatement = conexion.prepareCall(sql)) {

            callableStatement.setInt(1,idPersona); 
            callableStatement.setString(2, nombre);
            callableStatement.setString(3, contrasenia);
            callableStatement.setString(4, email);
            callableStatement.setInt(5, idRol);
            callableStatement.execute();

            JOptionPane.showMessageDialog(this, "Usuario actualizado", "Exito", JOptionPane.INFORMATION_MESSAGE);
            idPersonaText.setText("");
            passwordText.setText("");
            emailText.setText("");
            idRolText.setText("");
            idPersonaDelete.setText("");
            nombreText.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al modificar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarInsectos().setVisible(true);
            }
        });
    }
    
    public void mostrarUsuarios(){
        //System.out.println("Entrando mostrarProductos");
        String sql = "SELECT * FROM consultar_todos_usuarios_return()"; //consuta para obtener el procedimiento 
        CallableStatement callableStatement; // variable para almacenar el resultado del procedimiento
        
        //conexion
        ConexionBD conectar = new ConexionBD();
        Connection conexion = conectar.getConnection();
        DefaultTableModel model = new DefaultTableModel(); // hacer la tabla un modelo para poder modificar las filas y columnas

        model.addColumn("ID Usuario");
        model.addColumn("Nombre");
        model.addColumn("ID Persona");
        model.addColumn("Email");
        model.addColumn("Rol");
        model.addColumn("ID Rol");

        tablaUsuarios.setModel(model);
        tablaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(220);
        tablaUsuarios.getColumnModel().getColumn(0).setResizable(false);
        tablaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(45);
        tablaUsuarios.getColumnModel().getColumn(2).setResizable(false);
        tablaUsuarios.getColumnModel().getColumn(5).setPreferredWidth(2);
        tablaUsuarios.getColumnModel().getColumn(5).setResizable(false);

        try {
            //usar prepared statement y guardar los resultados
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(); 

            while (resultSet.next()) { 
                String[] infoTablas = new String[6]; 
                infoTablas[0] = resultSet.getString(1);
                infoTablas[1] = resultSet.getString(2); 
                infoTablas[2] = resultSet.getString(3); 
                infoTablas[3] = resultSet.getString(4); 
                infoTablas[4] = resultSet.getString(5); 
                infoTablas[5] = resultSet.getString(6); 

                model.addRow(infoTablas);
            }

            resultSet.close(); 
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        
    }
    
    public void mostrarRoles(){
        //consulta
        String sql = "{CALL obtener_roles()}";
        
        //conexion
        ConexionBD conectar = new ConexionBD();
        Connection conexion = conectar.getConnection();
        
        //crear modelo crear las columnas y aignar modelo a la tabla
        DefaultTableModel modelRoles = new DefaultTableModel();
        modelRoles.addColumn("ID Rol");
        modelRoles.addColumn("Nombre Rol");

        tablaRoles.setModel(modelRoles);

        try {
            //ejecutar y guardar en result set
            CallableStatement callableStatement = conexion.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String[] infoRoles = new String[2];
                infoRoles[0] = resultSet.getString("ID_Rol");
                infoRoles[1] = resultSet.getString("nombre_rol");
                modelRoles.addRow(infoRoles);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelDelete;
    private javax.swing.JTextField emailText;
    private javax.swing.JTextField idPersonaDelete;
    private javax.swing.JTextField idPersonaText;
    private javax.swing.JTextField idRolText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombreText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTable tablaRoles;
    public javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
