/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.addDialogs;

import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.panels.AlienPanel;
import javaapplication3.models.Agent;
import javaapplication3.models.Location;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.ObjectManager.Agents;
import static javaapplication3.utils.ObjectManager.db;
import javax.swing.JOptionPane;
import oru.inf.InfException;



/**
 *
 * @author vilso
 */
public class RegisterNewAlienDialogPopupV2 extends javax.swing.JDialog {

    private AlienPanel Parent;
    /**
     * Creates new form RegisterNewAlienDialogPopupV2
     * @param parent
     * @param modal
     */
    public RegisterNewAlienDialogPopupV2(java.awt.Frame parent, AlienPanel home, boolean modal) {
        super(parent, modal);
        Parent = home;
        initComponents();
        dynamicLabel.setVisible(false);
        valueSpinner.setVisible(false);
        fillComboBoxes();
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
        registerAlienLabel = new javax.swing.JLabel();
        inputNameLabel = new javax.swing.JLabel();
        inputPhoneLabel = new javax.swing.JLabel();
        inputEmailLabel = new javax.swing.JLabel();
        inputAgentLabel = new javax.swing.JLabel();
        inputAreaLabel = new javax.swing.JLabel();
        inputSpeciesLabel = new javax.swing.JLabel();
        dynamicLabel = new javax.swing.JLabel();
        valueSpinner = new javax.swing.JSpinner();
        abortButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        agentComboBox = new javax.swing.JComboBox<>();
        speciesComboBox = new javax.swing.JComboBox<>();
        areaComboBox = new javax.swing.JComboBox<>();
        nameTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setForeground(new java.awt.Color(25, 22, 22));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 650));

        registerAlienLabel.setBackground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registerAlienLabel.setForeground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setText("Registrera ny Alien");

        inputNameLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setText("Ange fullständigt namn:");

        inputPhoneLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPhoneLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setText("Ange telefonnummer:");

        inputEmailLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputEmailLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setText("Ange e-postadress:");

        inputAgentLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputAgentLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputAgentLabel.setText("Ange ansvarig agent:");

        inputAreaLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputAreaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputAreaLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputAreaLabel.setText("Ange områdeskod:");

        inputSpeciesLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputSpeciesLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setText("Ange art av alien:");

        dynamicLabel.setBackground(new java.awt.Color(204, 204, 204));
        dynamicLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dynamicLabel.setForeground(new java.awt.Color(204, 204, 204));
        dynamicLabel.setText("Dynamic Text");

        valueSpinner.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

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

        agentComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        agentComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        speciesComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        speciesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boglodite", "Squid", "Worm" }));
        speciesComboBox.setSelectedIndex(-1);
        speciesComboBox.setPreferredSize(new java.awt.Dimension(180, 40));
        speciesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speciesComboBoxActionPerformed(evt);
            }
        });

        areaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        areaComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        nameTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        phoneTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneTextField.setPreferredSize(new java.awt.Dimension(180, 40));
        phoneTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneTextFieldKeyPressed(evt);
            }
        });

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTextField.setPreferredSize(new java.awt.Dimension(180, 40));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNameLabel)
                    .addComponent(inputEmailLabel)
                    .addComponent(inputAreaLabel)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dynamicLabel)
                        .addGap(18, 18, 18)
                        .addComponent(valueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(inputPhoneLabel)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputAgentLabel)
                    .addComponent(agentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputSpeciesLabel)
                    .addComponent(speciesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerAlienLabel)
                .addGap(143, 143, 143))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(registerAlienLabel)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNameLabel)
                    .addComponent(inputPhoneLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputEmailLabel)
                    .addComponent(inputAgentLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputAreaLabel)
                    .addComponent(inputSpeciesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speciesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valueSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dynamicLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fillComboBoxes() {
        for (HashMap.Entry<Integer, Agent> entry : Agents.agentList.entrySet()) {
            int key = entry.getKey();
            String name = entry.getValue().getName(); // Assuming YourObjectClass has a getName() method
            agentComboBox.addItem(key + ": " + name);
        }
        for (Map.Entry<Integer, Location> entry : ObjectManager.Locations.locationList.entrySet()) {
            int key = entry.getKey();
            String name = entry.getValue().getName(); // Assuming YourObjectClass has a getName() method
            areaComboBox.addItem(key + ": " + name);
        }
    }
    
    private void speciesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speciesComboBoxActionPerformed
        
        if(evt.getSource() == speciesComboBox){
            if(speciesComboBox.getSelectedIndex() == 0){
                dynamicLabel.setText("Antal Boogies:");
                dynamicLabel.setVisible(true);
                valueSpinner.setVisible(true);
                valueSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 20.0d, 1d));
            }
            if(speciesComboBox.getSelectedIndex() == 1){
                dynamicLabel.setText("Antal Armar:");
                dynamicLabel.setVisible(true);
                valueSpinner.setVisible(true);
                valueSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 20.0d, 1d));
            }
            if(speciesComboBox.getSelectedIndex() == 2){
                dynamicLabel.setText("Ange längd (m):");
                dynamicLabel.setVisible(true);
                valueSpinner.setVisible(true);
                valueSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 20.0d, 0.1d));
            }
        }
    }//GEN-LAST:event_speciesComboBoxActionPerformed

    private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_abortButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        String email = emailTextField.getText();
        if(ObjectManager.Aliens.emailList.contains(email.toLowerCase())){
            JOptionPane.showMessageDialog(this, "Alien finns redan med epost: "+email);
        }
        else{
        try {
            String password = ObjectManager.generatePassword();
            
            HashMap<String, String> map = new HashMap<>();
            int newID = Integer.parseInt(db.fetchSingle("Select max(Alien_ID) from alien"))+1;
            map.put("Alien_ID",newID+"");
            map.put("Registreringsdatum", LocalDate.now().toString());
            map.put("Epost", email);
            map.put("Losenord", password);
            map.put("Namn", nameTextField.getText());
            map.put("Telefon", phoneTextField.getText());
            
            int location = Integer.parseInt(areaComboBox.getSelectedItem().toString().split(":")[0].trim());
            map.put("Plats", location+"");
            
            int agent = Integer.parseInt(agentComboBox.getSelectedItem().toString().split(":")[0].trim());
            map.put("Ansvarig_Agent", agent+"");
            
            String race = speciesComboBox.getSelectedItem().toString();
            map.put("Race", race);
            map.put("Value", valueSpinner.getValue().toString());
            
            ObjectManager.Aliens.addNew(map, ObjectManager.Locations.locationList.get(location), ObjectManager.Agents.agentList.get(agent), race);
            
            JOptionPane.showMessageDialog(this, "Registreringen av Alien "+newID+" lyckades!");
            Parent.reload();
            this.dispose();
            
        } catch (InfException ex) {
            Logger.getLogger(RegisterNewAlienDialogPopupV2.class.getName()).log(Level.SEVERE, null, ex);
        }}
        
    }//GEN-LAST:event_registerButtonActionPerformed

    
    private void phoneTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneTextFieldKeyPressed
        String phoneNumber = phoneTextField.getText();
        int length = phoneNumber.length();
        char c = evt.getKeyChar();
        
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9'){
            if (length < 10){
                phoneTextField.setEditable(true);
            }else{
                phoneTextField.setEditable(false);
            }
        }else{
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE){
                phoneTextField.setEditable(true);
            }else{
                phoneTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_phoneTextFieldKeyPressed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortButton;
    private javax.swing.JComboBox<String> agentComboBox;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JLabel dynamicLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel inputAgentLabel;
    private javax.swing.JLabel inputAreaLabel;
    private javax.swing.JLabel inputEmailLabel;
    private javax.swing.JLabel inputNameLabel;
    private javax.swing.JLabel inputPhoneLabel;
    private javax.swing.JLabel inputSpeciesLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel registerAlienLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JComboBox<String> speciesComboBox;
    private javax.swing.JSpinner valueSpinner;
    // End of variables declaration//GEN-END:variables
}
