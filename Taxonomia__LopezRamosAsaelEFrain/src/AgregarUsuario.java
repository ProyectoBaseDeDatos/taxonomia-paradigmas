/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.CallableStatement;
import java.util.ArrayList;
/**
 *
 * @author asael
 */
public class AgregarUsuario extends javax.swing.JFrame {
    private InfoCurrentUser infoUsuarioActual;
    private ArrayList<String> arrayRoles = new ArrayList<>();
    /**
     * Creates new form agregarUsuario
     */
    public AgregarUsuario(InfoCurrentUser infoUsuarioActual) {
        this.infoUsuarioActual = infoUsuarioActual;
        initComponents();
        this.setLocationRelativeTo(null);
        labelError.setVisible(false);
        idPersona.setEditable(false);
        mostrarRoles();
        mostrarPersonas();
    }

    private AgregarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        correoField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idPersona = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        agregarButton = new javax.swing.JButton();
        cancelDelete = new javax.swing.JButton();
        listRoles = new javax.swing.JComboBox<>();
        labelError = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPersonas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        correoField.setBackground(new java.awt.Color(179, 185, 192));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(197, 217, 192));

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID Persona");

        idPersona.setBackground(new java.awt.Color(179, 185, 192));

        passwordField.setBackground(new java.awt.Color(179, 185, 192));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Agregar Usuario");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID_Rol");

        emailField.setBackground(new java.awt.Color(179, 185, 192));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        agregarButton.setBackground(new java.awt.Color(0, 0, 204));
        agregarButton.setForeground(new java.awt.Color(255, 255, 255));
        agregarButton.setText("Agregar");
        agregarButton.setName("agregarButton"); // NOI18N
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        cancelDelete.setBackground(new java.awt.Color(255, 153, 0));
        cancelDelete.setForeground(new java.awt.Color(255, 255, 255));
        cancelDelete.setText("Cancelar");
        cancelDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelDeleteActionPerformed(evt);
            }
        });

        listRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelError.setForeground(new java.awt.Color(255, 0, 0));
        labelError.setText("Error");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idPersona, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField)
                            .addComponent(passwordField)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(cancelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(listRoles, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelError))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        tablaPersonas.setBackground(new java.awt.Color(128, 167, 191));
        tablaPersonas.setForeground(new java.awt.Color(0, 0, 51));
        tablaPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Persona", "Nombre Persona"
            }
        ));
        tablaPersonas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        tablaPersonas.getTableHeader().setResizingAllowed(false);
        tablaPersonas.getTableHeader().setReorderingAllowed(false);
        tablaPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPersonasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPersonas);

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Personas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        
        // validamos los inputs
        String id = idPersona.getText();
        String pass = new String(passwordField.getPassword()).trim();
        String email = emailField.getText();
        String rol = (String) listRoles.getSelectedItem();
        labelError.setVisible(true);
        
        if(id.equalsIgnoreCase("")){
            labelError.setText("No has seleccionado a ninguna persona");
            return ;
        }
        
        if(pass.length()< 8 ){
            labelError.setText("La contraseña de tener 8 o mas caracteres");
            return ;
        }
 
        if(!email.matches("^[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            labelError.setText("El email no es válido");
            return;
        }
        
        if(rol.equalsIgnoreCase("selecciona el rol")){
            labelError.setText("Debe de seleccionar un rol");
            return ;
        }
        
        labelError.setVisible(false);
        agregarUsuario();
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void cancelDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelDeleteActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ModificacionUsuarios  newFrame = new ModificacionUsuarios(infoUsuarioActual);
        newFrame.setVisible(true);
    }//GEN-LAST:event_cancelDeleteActionPerformed

    private void tablaPersonasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPersonasMouseClicked
        // TODO add your handling code here:
        
        int filaSeleccionada = tablaPersonas.getSelectedRow();
        if(filaSeleccionada != -1){
            String id = (String) tablaPersonas.getValueAt(filaSeleccionada,0);
            idPersona.setText(id);
            
        }
        
    }//GEN-LAST:event_tablaPersonasMouseClicked

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
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarUsuario().setVisible(true);
            }
        });
    }
    
    public void mostrarRoles(){
        //consulta
        String sql = "{CALL obtener_roles()}";
        
        //conexion
        ConexionBD conectar = new ConexionBD();
        Connection conexion = conectar.getConnection();
        listRoles.removeAllItems();
        listRoles.addItem("selecciona el rol");
        //crear modelo crear las columnas y aignar modelo a la tabla
        try {
            //ejecutar y guardar en result set
            CallableStatement callableStatement = conexion.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();

            while (resultSet.next()) {
                String[] infoRoles = new String[2];
                infoRoles[0] = resultSet.getString("ID_Rol");
                infoRoles[1] = resultSet.getString("nombre_rol");
                listRoles.addItem(infoRoles[1]);
                arrayRoles.add(infoRoles[1]);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public void mostrarPersonas() {
        //consulta
        //String sql = "{CALL obtener_personas()}";
        String sql = "{CALL get_personas_sin_rol()}";
        //conexion
        ConexionBD conectar = new ConexionBD();
        Connection conexion = conectar.getConnection();
        
        //crear modelo, asignar nombres y asignar modelo a tabla
        DefaultTableModel modelPersonas = new DefaultTableModel();
        modelPersonas.addColumn("ID Persona");
        modelPersonas.addColumn("Nombre Persona");

        tablaPersonas.setModel(modelPersonas);

        try {
            //ejecutar consulta y guardarlo
            CallableStatement callableStatement = conexion.prepareCall(sql);
            ResultSet resultSet = callableStatement.executeQuery();
            
            //iterar sobre los resultados
            while (resultSet.next()) {
                String[] infoPersonas = new String[2];
                //infoPersonas[0] = resultSet.getString("ID_Persona");
                //infoPersonas[1] = resultSet.getString("nombre_persona");
                infoPersonas[0] = resultSet.getString("id_persona");
                infoPersonas[1] = resultSet.getString("nombre");
                
                modelPersonas.addRow(infoPersonas);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    public void agregarUsuario() {
        //int idPersona = Integer.parseInt(idPersona.getText());
        
        if(idPersona.getText().equals("") || passwordField == null || emailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }
        
        //obtener la informacion de los campos de entrada
        int idPersona = Integer.parseInt(this.idPersona.getText());
        String contrasena = new String(passwordField.getPassword());
        String email = emailField.getText();
        String rol = (String) listRoles.getSelectedItem();
        int idRol = arrayRoles.indexOf(rol)+1;
        
        

        String sql = "CALL crear_usuario(?, ?, ?, ?)"; //procedimiento

        try (Connection conexion = new ConexionBD().getConnection(); 
            //realizar procedimiento
             CallableStatement callableStatement = conexion.prepareCall(sql)) {

            callableStatement.setInt(1, idPersona); 
            callableStatement.setString(2, contrasena); 
            callableStatement.setString(3, email); 
            callableStatement.setInt(4, idRol); 

            callableStatement.executeUpdate(); 

            JOptionPane.showMessageDialog(null, "Usuario creado con exito.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            ModificacionUsuarios  newFrame = new ModificacionUsuarios(infoUsuarioActual);

        } catch (SQLException e) {
            System.out.println("Error"+e);
            JOptionPane.showMessageDialog(null, "Error al crear el usuario: ", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en el formato", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        this.dispose();
        ModificacionUsuarios newFrame = new ModificacionUsuarios(infoUsuarioActual);
        newFrame.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JButton cancelDelete;
    private javax.swing.JTextField correoField;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField idPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelError;
    private javax.swing.JComboBox<String> listRoles;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTable tablaPersonas;
    // End of variables declaration//GEN-END:variables
}
