/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.addDialogs;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.HashMap;
import javaapplication3.GUI.panels.AgentPanel;
import javaapplication3.models.Area;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.ObjectManager.Areas;
import static javaapplication3.utils.ObjectManager.db;
import javax.swing.DefaultComboBoxModel;
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
        dynamiOfficeLabel.setVisible(false);
        dynamicControlLabel.setVisible(false);
        controlComboBox.setVisible(false);
        officeTextField.setVisible(false);
    }
    
    private void fillComboBox() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement("Välj område:");
        for (HashMap.Entry<Integer, Area> entry : Areas.areaList.entrySet()) {
            int key = entry.getKey();
            String name = entry.getValue().getName(); // Assuming YourObjectClass has a getName() method
            dcbm.addElement(key + ": " + name);
            
            controlComboBox.setModel(dcbm);
        }
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
        controlComboBox = new javax.swing.JComboBox<>();
        dynamicControlLabel = new javax.swing.JLabel();
        dynamiOfficeLabel = new javax.swing.JLabel();
        officeTextField = new javax.swing.JTextField();

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
        adminTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj:", "Ja", "Nej" }));
        adminTypeComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        inputNameLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setText("Ange fullständigt namn:");

        agentTypeComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agentTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj typ av agent:", "Fältagent", "Kontorschef", "Områdeschef" }));
        agentTypeComboBox.setPreferredSize(new java.awt.Dimension(180, 40));
        agentTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agentTypeComboBoxActionPerformed(evt);
            }
        });

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
        inputAreaLabel.setText("Ange utplacering:");

        emailTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTextField.setPreferredSize(new java.awt.Dimension(180, 40));

        inputSpeciesLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputSpeciesLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputSpeciesLabel.setText("Ange typ av agent:");

        controlComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        controlComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj område:", "1: Svealand", "2: Götaland", "4: Norrland" }));
        controlComboBox.setPreferredSize(new java.awt.Dimension(180, 40));

        dynamicControlLabel.setBackground(new java.awt.Color(204, 204, 204));
        dynamicControlLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dynamicControlLabel.setForeground(new java.awt.Color(204, 204, 204));
        dynamicControlLabel.setText("Dynamic control");

        dynamiOfficeLabel.setBackground(new java.awt.Color(204, 204, 204));
        dynamiOfficeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dynamiOfficeLabel.setForeground(new java.awt.Color(204, 204, 204));
        dynamiOfficeLabel.setText("Dynamic Office");

        officeTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        officeTextField.setPreferredSize(new java.awt.Dimension(180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(registerAlienLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNameLabel)
                            .addComponent(inputEmailLabel)
                            .addComponent(inputAreaLabel)
                            .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dynamicControlLabel)
                            .addComponent(controlComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dynamiOfficeLabel)
                            .addComponent(inputPhoneLabel)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputAgentLabel)
                            .addComponent(adminTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputSpeciesLabel)
                            .addComponent(agentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(officeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputSpeciesLabel)
                    .addComponent(inputAreaLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dynamicControlLabel)
                    .addComponent(dynamiOfficeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(controlComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(officeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        
        if (!emailTextField.getText().isEmpty() && !nameTextField.getText().isEmpty() && !phoneTextField.getText().isEmpty() && areaComboBox.getSelectedIndex() > 0 && agentTypeComboBox.getSelectedIndex() > 0 && checkDynamic()) {
            try {
                String password = ObjectManager.generatePassword();

                HashMap<String, String> map = new HashMap<>();
                map.put("Agent_ID", maxID + "");
                map.put("Anstallningsdatum", LocalDate.now().toString());
                map.put("Epost", emailTextField.getText());
                map.put("Losenord", password);
                map.put("Namn", nameTextField.getText());
                map.put("Telefon", phoneTextField.getText());
                map.put("Administrator", boolToChar());

                int area = Integer.parseInt(areaComboBox.getSelectedItem().toString().split(":")[0].trim());
                map.put("Omrade", area + "");

                String type = agentTypeComboBox.getSelectedItem().toString();
                map.put("Type", type);
                map.put("Value", getUniqueValue());

                ObjectManager.Agents.addNew(map, ObjectManager.Areas.areaList.get(area), type);

                JOptionPane.showMessageDialog(this, "Registreringen av Agent: " + nameTextField.getText() + " med nytt \nagentidentifieringsnummer: " + maxID + " lyckades!");
                Parent.reload();
                this.dispose();

            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private String getUniqueValue() {
        int index = agentTypeComboBox.getSelectedIndex();

        switch (index) {
            case 2:
                return officeTextField.getText();
            case 3:
                return controlComboBox.getSelectedItem().toString().split(":")[0].trim();
            default:
                return "";
        }
    }
    
    private String boolToChar(){
        String string = adminTypeComboBox.getSelectedItem().toString();
        if(string.equals("Ja")){
            return "J";
        }
        return "N";
    }
    
    private boolean checkDynamic(){
        int index = agentTypeComboBox.getSelectedIndex();

        return switch (index) {
            case 0 -> false;
            case 2 -> !officeTextField.getText().isEmpty();
            case 3 -> controlComboBox.getSelectedIndex()>0;
            default -> true;
        };
        
    }
    
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

    private void agentTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agentTypeComboBoxActionPerformed
        if(evt.getSource() == agentTypeComboBox){
            if(agentTypeComboBox.getSelectedIndex() == 1){
                dynamicControlLabel.setVisible(false);
                dynamiOfficeLabel.setVisible(false);
                controlComboBox.setVisible(false);
                officeTextField.setVisible(false);
            }
            if(agentTypeComboBox.getSelectedIndex() == 2){
                dynamicControlLabel.setVisible(false);
                dynamiOfficeLabel.setText("Ange kontorsnamn:");
                dynamiOfficeLabel.setVisible(true);
                officeTextField.setVisible(true);
                controlComboBox.setVisible(false);
            }
            if(agentTypeComboBox.getSelectedIndex() == 3){
                dynamiOfficeLabel.setVisible(false);
                dynamicControlLabel.setText("Välj chefsområde:");
                dynamicControlLabel.setVisible(true);
                controlComboBox.setVisible(true);
                officeTextField.setVisible(false);
            }
        }
    }//GEN-LAST:event_agentTypeComboBoxActionPerformed

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortButton;
    private javax.swing.JComboBox<String> adminTypeComboBox;
    private javax.swing.JComboBox<String> agentTypeComboBox;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JComboBox<String> controlComboBox;
    private javax.swing.JLabel dynamiOfficeLabel;
    private javax.swing.JLabel dynamicControlLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel inputAgentLabel;
    private javax.swing.JLabel inputAreaLabel;
    private javax.swing.JLabel inputEmailLabel;
    private javax.swing.JLabel inputNameLabel;
    private javax.swing.JLabel inputPhoneLabel;
    private javax.swing.JLabel inputSpeciesLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField officeTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JLabel registerAlienLabel;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
