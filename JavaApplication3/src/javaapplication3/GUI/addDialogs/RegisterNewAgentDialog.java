/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.addDialogs;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.panels.AgentPanel;
import javaapplication3.GUI.panels.AlienPanel;
import javaapplication3.utils.ObjectManager;
import static javaapplication3.utils.ObjectManager.db;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author aiham
 */
public class RegisterNewAgentDialog extends javax.swing.JDialog {
    
    int maxID = Integer.parseInt(db.fetchSingle("Select max(Agent_ID) from agent"))+1;
    private AgentPanel Parent;

    /**
     * Creates new form RegisterNewAgentDialog
     */
    public RegisterNewAgentDialog(java.awt.Frame parent, AgentPanel home, boolean modal) throws InfException {
        super(parent, modal);
        initComponents();
        getContentPane().setBackground(new Color(51,51,51));
        Parent = home;
        ObjectManager.Agents.LoadList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        abortButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        registerAlienLabel = new javax.swing.JLabel();
        adminTypeComboBox = new javax.swing.JComboBox<>();
        inputNameLabel = new javax.swing.JLabel();
        agentTypeComboBox = new javax.swing.JComboBox<>();
        inputPhoneLabel = new javax.swing.JLabel();
        areaComboBox = new javax.swing.JComboBox<>();
        inputEmailLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        inputAgentLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        inputAreaLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        inputSpeciesLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);

        abortButton.setBackground(new java.awt.Color(204, 204, 204));
        abortButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        abortButton.setForeground(new java.awt.Color(102, 102, 102));
        abortButton.setText("Avbryt");
        abortButton.setPreferredSize(new java.awt.Dimension(180, 55));
        abortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortButtonActionPerformed(evt);
            }
        });

        registerButton.setBackground(new java.awt.Color(204, 204, 204));
        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(102, 102, 102));
        registerButton.setText("Registrera");
        registerButton.setPreferredSize(new java.awt.Dimension(180, 55));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        registerAlienLabel.setBackground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registerAlienLabel.setForeground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setText("Registrera ny Agent");

        adminTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adminTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj:", "True", "False" }));
        adminTypeComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        inputNameLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setText("Ange fullständigt namn:");

        agentTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agentTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj typ av agent:", "Fältagent", "Kontorschef", "Områdeschef" }));
        agentTypeComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        inputPhoneLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPhoneLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setText("Ange telefonnummer:");

        areaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj område:", "1: Svealand", "2: Götaland", "3: Norrland" }));
        areaComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        inputEmailLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputEmailLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setText("Ange e-postadress:");

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        inputAgentLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputAgentLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputAgentLabel.setText("Administratör:");

        phoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneTextField.setPreferredSize(new java.awt.Dimension(180, 40));
        phoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneTextFieldKeyPressed(evt);
            }
        });

        inputAreaLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputAreaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputAreaLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputAreaLabel.setText("Ange områdeskod:");

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTextField.setPreferredSize(new java.awt.Dimension(180, 40));

        inputSpeciesLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputSpeciesLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setText("Ange typ av agent:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNameLabel)
                            .addComponent(inputEmailLabel)
                            .addComponent(inputAreaLabel)
                            .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPhoneLabel)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputAgentLabel)
                            .addComponent(adminTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputSpeciesLabel)
                            .addComponent(agentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(registerAlienLabel)))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(registerAlienLabel)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNameLabel)
                    .addComponent(inputPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmailLabel)
                    .addComponent(inputAgentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputAreaLabel)
                    .addComponent(inputSpeciesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        try {
            String password = ObjectManager.generatePassword();
            
            HashMap<String, String> map = new HashMap<>();
            map.put("Agent_ID", maxID + "");
            map.put("Anstallningsdatum", LocalDate.now().toString());
            map.put("Epost", emailTextField.getText());
            map.put("Losenord", password);
            map.put("Namn", nameTextField.getText());
            map.put("Telefon", phoneTextField.getText());
            
            int location = Integer.parseInt(areaComboBox.getSelectedItem().toString().split(":")[0].trim());
            map.put("Omrade", location + "");
            
            String type = agentTypeComboBox.getSelectedItem().toString();
           // map.put("Race", race);
            //map.put("Value", valueSpinner.getValue().toString());
            
           // ObjectManager.Aliens.addNew(map, ObjectManager.Locations.locationList.get(location), ObjectManager.Agents.agentList.get(agent), race);
            
            JOptionPane.showMessageDialog(this, "Registreringen av Agent:" + nameTextField.getText() + " med nytt \nagentidentifieringsnummer: " + maxID + " lyckades!");
            Parent.reload();
            this.dispose();
            
        } catch (Exception ex) {
            //Logger.getLogger(RegisterNewAlienDialogPopupV2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_abortButtonActionPerformed

    private void phoneTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextFieldKeyPressed

        String phoneNumber = phoneTextField.getText();
        int length = phoneNumber.length();
        char c = evt.getKeyChar();

        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
            if (length < 10) {
                phoneTextField.setEditable(true);
            } else {
                phoneTextField.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                phoneTextField.setEditable(true);
            } else {
                phoneTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_phoneTextFieldKeyPressed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortButton;
    private javax.swing.JComboBox<String> adminTypeComboBox;
    private javax.swing.JComboBox<String> agentTypeComboBox;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel inputAgentLabel;
    private javax.swing.JLabel inputAreaLabel;
    private javax.swing.JLabel inputEmailLabel;
    private javax.swing.JLabel inputNameLabel;
    private javax.swing.JLabel inputPhoneLabel;
    private javax.swing.JLabel inputSpeciesLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel registerAlienLabel;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
