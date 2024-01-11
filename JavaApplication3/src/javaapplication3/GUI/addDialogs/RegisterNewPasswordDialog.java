/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.addDialogs;

import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.models.Agent;
import javaapplication3.utils.ObjectManager;
import javax.swing.JOptionPane;
import oru.inf.InfException;
import java.awt.Color;
import javaapplication3.GUI.panels.AlienProfilePanel;
import javaapplication3.GUI.panels.ProfilePanel;
import javaapplication3.models.Alien;
import javaapplication3.utils.inputValidation;

/**
 *
 * @author albin
 */
public class RegisterNewPasswordDialog extends javax.swing.JDialog {

    Agent agentProfile;
    Alien alienProfile;
    Object profile;
    ProfilePanel agentHome;
    AlienProfilePanel alienHome;

    /**
     * Creates new form RegisterNewLocationDialog2
     */
    public RegisterNewPasswordDialog(java.awt.Frame parent, Agent profile, boolean modal, ProfilePanel home) {
        super(parent, modal);
        initComponents();
        this.agentProfile = profile;
        this.profile = (Agent) profile;
        agentHome = home;
        getContentPane().setBackground(new Color(51, 51, 51));
    }

    public RegisterNewPasswordDialog(java.awt.Frame parent, Alien profile, boolean modal, AlienProfilePanel home) {
        super(parent, modal);
        initComponents();
        this.alienProfile = profile;
        this.profile = (Alien) profile;
        alienHome = home;
        getContentPane().setBackground(new Color(51, 51, 51));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerNewPasswordText = new javax.swing.JLabel();
        inputCurrentPasswordText = new javax.swing.JLabel();
        inputNewPasswordText = new javax.swing.JLabel();
        abortButton = new javax.swing.JButton();
        registerButton1 = new javax.swing.JButton();
        newPasswordField = new javax.swing.JPasswordField();
        currentPasswordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(221, 221, 221));
        setForeground(new java.awt.Color(221, 221, 221));

        registerNewPasswordText.setBackground(new java.awt.Color(204, 204, 204));
        registerNewPasswordText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registerNewPasswordText.setForeground(new java.awt.Color(204, 204, 204));
        registerNewPasswordText.setText("Registrera nytt Lösenord ");
        registerNewPasswordText.setToolTipText("");

        inputCurrentPasswordText.setBackground(new java.awt.Color(204, 204, 204));
        inputCurrentPasswordText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputCurrentPasswordText.setForeground(new java.awt.Color(204, 204, 204));
        inputCurrentPasswordText.setText("Ange nuvarande lösenord:");

        inputNewPasswordText.setBackground(new java.awt.Color(204, 204, 204));
        inputNewPasswordText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNewPasswordText.setForeground(new java.awt.Color(204, 204, 204));
        inputNewPasswordText.setText("Ange nytt lösenord:");

        abortButton.setBackground(new java.awt.Color(204, 204, 204));
        abortButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        abortButton.setForeground(new java.awt.Color(51, 51, 51));
        abortButton.setText("Avbryt");
        abortButton.setPreferredSize(new java.awt.Dimension(180, 55));
        abortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortButtonActionPerformed(evt);
            }
        });

        registerButton1.setBackground(new java.awt.Color(204, 204, 204));
        registerButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerButton1.setForeground(new java.awt.Color(51, 51, 51));
        registerButton1.setText("Registrera");
        registerButton1.setPreferredSize(new java.awt.Dimension(180, 55));
        registerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNewPasswordText)
                    .addComponent(inputCurrentPasswordText)
                    .addComponent(registerNewPasswordText))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(registerNewPasswordText)
                .addGap(26, 26, 26)
                .addComponent(inputCurrentPasswordText)
                .addGap(8, 8, 8)
                .addComponent(currentPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(inputNewPasswordText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_abortButtonActionPerformed

    private void registerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButton1ActionPerformed
        boolean passwordMatch;
        String newPassword = String.valueOf(currentPasswordField.getPassword());

        if (agentProfile == null) {
            passwordMatch = alienProfile.getPassword().equals(newPassword);
        } else {
            passwordMatch = agentProfile.getPassword().equals(newPassword);
        }

        if (passwordMatch) {
            try {
                if (inputValidation.passwordValidaton(newPasswordField)) {
                    if (profile instanceof Alien) {
                        alienProfile.setPassword(newPassword);
                        profile = alienProfile;
                        alienHome.refresh();
                    } else if (profile instanceof Agent) {
                        agentProfile.setPassword(newPassword);
                        profile = agentProfile;
                        agentHome.refresh();
                    }

                    JOptionPane.showMessageDialog(null, "Lösenordet ändrades!");
                    ObjectManager.updateObject(profile);
                    
                    this.dispose();
                }
            } catch (InfException ex) {
                Logger.getLogger(RegisterNewPasswordDialog.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Ändring av lösenord misslyckades");
            }
        } else {
            JOptionPane.showMessageDialog(null, "du dum");
            System.out.println("Misslyckad");
        }
    }//GEN-LAST:event_registerButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortButton;
    private javax.swing.JPasswordField currentPasswordField;
    private javax.swing.JLabel inputCurrentPasswordText;
    private javax.swing.JLabel inputNewPasswordText;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JButton registerButton1;
    private javax.swing.JLabel registerNewPasswordText;
    // End of variables declaration//GEN-END:variables
}
