/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.addDialogs;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.panels.EquipmentPanel;
import javaapplication3.models.Utilities;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.ObjectManager.UtilitiesHandler;
import static javaapplication3.utils.ObjectManager.db;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oru.inf.InfException;

/**
 *
 * @author aiham
 */
public class RegisterNewUtilitiesDialog extends javax.swing.JDialog {
    
    int maxID = Integer.parseInt(db.fetchSingle("Select max(Utrustnings_ID) from utrustning"))+1;
    private EquipmentPanel Parent;
    /**
     * Creates new form RegisterNewUtilities
     */
    public RegisterNewUtilitiesDialog(java.awt.Frame parent, EquipmentPanel home, boolean modal) throws InfException {
        super(parent, modal);
        Parent = home;
        initComponents();
        getContentPane().setBackground(new Color(51,51,51));
        areaID.setText(String.valueOf(maxID));
        ObjectManager.UtilitiesHandler.loadList();
        dynamicTextLabel.setVisible(false);
        valueTextField.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDlabel = new javax.swing.JLabel();
        abortButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        utilityNameTextField = new javax.swing.JTextField();
        areaID = new javax.swing.JTextField();
        addAreaText = new javax.swing.JLabel();
        comfirmButton = new javax.swing.JButton();
        utilityTypeLabel = new javax.swing.JLabel();
        equipmentTypeComboBox = new javax.swing.JComboBox<>();
        dynamicTextLabel = new javax.swing.JLabel();
        valueTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        IDlabel.setBackground(new java.awt.Color(221, 221, 221));
        IDlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        IDlabel.setForeground(new java.awt.Color(221, 221, 221));
        IDlabel.setText("Nytt ID:");

        abortButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        abortButton.setText("Avbryt");
        abortButton.setToolTipText("");
        abortButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortButtonActionPerformed(evt);
            }
        });

        nameLabel.setBackground(new java.awt.Color(221, 221, 221));
        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(221, 221, 221));
        nameLabel.setText("Benämning på Utrustning:");

        utilityNameTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        utilityNameTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        utilityNameTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        areaID.setEditable(false);
        areaID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        areaID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        areaID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));

        addAreaText.setBackground(new java.awt.Color(221, 221, 221));
        addAreaText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        addAreaText.setForeground(new java.awt.Color(221, 221, 221));
        addAreaText.setText("Lägg till Utrustning");

        comfirmButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        comfirmButton.setText("Bekräfta");
        comfirmButton.setToolTipText("");
        comfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comfirmButtonActionPerformed(evt);
            }
        });

        utilityTypeLabel.setBackground(new java.awt.Color(221, 221, 221));
        utilityTypeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        utilityTypeLabel.setForeground(new java.awt.Color(221, 221, 221));
        utilityTypeLabel.setText("Välj typ av utrustning:");

        equipmentTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Välj en typ:", "Vapen", "Kommunikation", "Teknik" }));
        equipmentTypeComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        equipmentTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentTypeComboBoxActionPerformed(evt);
            }
        });

        dynamicTextLabel.setBackground(new java.awt.Color(221, 221, 221));
        dynamicTextLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        dynamicTextLabel.setForeground(new java.awt.Color(221, 221, 221));
        dynamicTextLabel.setText("Dynamic text");

        valueTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        valueTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        valueTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valueTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(areaID, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(IDlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(utilityNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(equipmentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(utilityTypeLabel))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dynamicTextLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(valueTextField)
                            .addComponent(comfirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addAreaText)
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(addAreaText)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(IDlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(areaID)
                    .addComponent(utilityNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(utilityTypeLabel)
                    .addComponent(dynamicTextLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipmentTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_abortButtonActionPerformed

    private void comfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comfirmButtonActionPerformed
        if (!utilityNameTextField.getText().isEmpty() || !valueTextField.getText().isEmpty() || equipmentTypeComboBox.getSelectedIndex() < 1) {
            try {
                HashMap<String, String> map = new HashMap<>();
                map.put("Utrustnings_ID", maxID + "");
                map.put("Type", equipmentTypeComboBox.getSelectedItem().toString());
                map.put("Benamning", utilityNameTextField.getText());
                map.put("Value", valueTextField.getText());

                ObjectManager.UtilitiesHandler.addNew(map);

                JOptionPane.showMessageDialog(this, "Registreringen av utrustningen: " + utilityNameTextField.getText() + " lyckades!");
                Parent.reload();
                this.dispose();

            } catch (InfException ex) {
                Logger.getLogger(RegisterNewAlienDialogPopupV2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ange värden för ny utrustning");
        }
    }//GEN-LAST:event_comfirmButtonActionPerformed

    private void equipmentTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentTypeComboBoxActionPerformed
        
        if(evt.getSource() == equipmentTypeComboBox){
            if(equipmentTypeComboBox.getSelectedIndex() == 1){
                dynamicTextLabel.setText("Ange kaliber:");
                dynamicTextLabel.setVisible(true);
                valueTextField.setVisible(true);
            }
            if(equipmentTypeComboBox.getSelectedIndex() == 2){
                dynamicTextLabel.setText("Ange överföringsteknik:");
                dynamicTextLabel.setVisible(true);
                valueTextField.setVisible(true);
            }
            if(equipmentTypeComboBox.getSelectedIndex() == 3){
                dynamicTextLabel.setText("Ange kraftkälla:");
                dynamicTextLabel.setVisible(true);
                valueTextField.setVisible(true);
            }
        }
    }//GEN-LAST:event_equipmentTypeComboBoxActionPerformed

    private void valueTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valueTextFieldKeyPressed
        if (equipmentTypeComboBox.getSelectedIndex() == 1) {
            String phoneNumber = valueTextField.getText();
            int length = phoneNumber.length();
            char c = evt.getKeyChar();

            if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9') {
                if (length < 10) {
                    valueTextField.setEditable(true);
                } else {
                    valueTextField.setEditable(false);
                }
            } else {
                if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                    valueTextField.setEditable(true);
                } else {
                    valueTextField.setEditable(false);
                }
            }
        }
    }//GEN-LAST:event_valueTextFieldKeyPressed
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IDlabel;
    private javax.swing.JButton abortButton;
    private javax.swing.JLabel addAreaText;
    private javax.swing.JTextField areaID;
    private javax.swing.JButton comfirmButton;
    private javax.swing.JLabel dynamicTextLabel;
    private javax.swing.JComboBox<String> equipmentTypeComboBox;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField utilityNameTextField;
    private javax.swing.JLabel utilityTypeLabel;
    private javax.swing.JTextField valueTextField;
    // End of variables declaration//GEN-END:variables
}
