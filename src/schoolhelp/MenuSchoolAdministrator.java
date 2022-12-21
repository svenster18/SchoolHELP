/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package schoolhelp;

/**
 *
 * @author risak
 */
public class MenuSchoolAdministrator extends javax.swing.JFrame {

    /**
     * Creates new form MenuSchoolAdministrator
     */
    public MenuSchoolAdministrator() {
        initComponents();
        initUI();
    }
    
    private void initUI() {
        SchoolAdmin schoolAdmin = SchoolHELPGUI.loggedInAdmin;
        jLabel1.setText(schoolAdmin.getFullname());
        jLabel3.setText(schoolAdmin.getPosition());
        jLabel4.setText(String.valueOf(schoolAdmin.getSchool().getSchoolID()));
        jLabel5.setText(schoolAdmin.getSchool().getSchoolName());
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
        btnChangePassword = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnUpdateAccount = new javax.swing.JButton();
        btnSubmitRequest = new javax.swing.JButton();
        btnViewRequest = new javax.swing.JButton();
        btnLogoutAccount = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnChangePassword.setBackground(new java.awt.Color(53, 94, 94));
        btnChangePassword.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Inter", 1, 44)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(53, 94, 94));
        jLabel2.setText("Menu School Administrator");

        btnUpdateAccount.setBackground(new java.awt.Color(53, 94, 94));
        btnUpdateAccount.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnUpdateAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateAccount.setText("Update Profile");
        btnUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAccountActionPerformed(evt);
            }
        });

        btnSubmitRequest.setBackground(new java.awt.Color(53, 94, 94));
        btnSubmitRequest.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnSubmitRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmitRequest.setText("Submit Request");
        btnSubmitRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitRequestActionPerformed(evt);
            }
        });

        btnViewRequest.setBackground(new java.awt.Color(53, 94, 94));
        btnViewRequest.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnViewRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnViewRequest.setText("View Request");
        btnViewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewRequestActionPerformed(evt);
            }
        });

        btnLogoutAccount.setBackground(new java.awt.Color(53, 94, 94));
        btnLogoutAccount.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        btnLogoutAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnLogoutAccount.setText("Logout Account");
        btnLogoutAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutAccountActionPerformed(evt);
            }
        });

        jLabel1.setText("School Admin Name   :");

        jLabel3.setText("Position                       :");

        jLabel4.setText("School ID                    :");

        jLabel5.setText("School Name              :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(129, 129, 129)
                        .addComponent(btnLogoutAccount)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 188, Short.MAX_VALUE)
                        .addComponent(btnSubmitRequest)
                        .addGap(92, 92, 92)
                        .addComponent(btnViewRequest)
                        .addGap(94, 94, 94)
                        .addComponent(btnChangePassword)
                        .addGap(88, 88, 88)
                        .addComponent(btnUpdateAccount)
                        .addGap(171, 171, 171))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btnLogoutAccount))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addGap(176, 176, 176)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(285, Short.MAX_VALUE))
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        // TODO add your handling code here:
        ChangePassword changePassword = new ChangePassword();
        changePassword.setVisible(true);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAccountActionPerformed
        // TODO add your handling code here:
        UpdateAccount updateAccount = new UpdateAccount();
        updateAccount.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUpdateAccountActionPerformed

    private void btnSubmitRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitRequestActionPerformed
        // TODO add your handling code here:
        SubmitRequest submitRequest = new SubmitRequest();
        submitRequest.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSubmitRequestActionPerformed

    private void btnViewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewRequestActionPerformed

    private void btnLogoutAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutAccountActionPerformed
        // TODO add your handling code here:
        SchoolHELPGUI.loggedInAdmin = null;
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutAccountActionPerformed

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
            java.util.logging.Logger.getLogger(MenuSchoolAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuSchoolAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuSchoolAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuSchoolAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuSchoolAdministrator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnLogoutAccount;
    private javax.swing.JButton btnSubmitRequest;
    private javax.swing.JButton btnUpdateAccount;
    private javax.swing.JButton btnViewRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
