/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.editDialogs;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.panels.LocationPanel;
import javaapplication3.models.Area;
import javaapplication3.models.Location;
import javaapplication3.utils.DatabaseConnection;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.inputValidation;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;


public class editLocationDialog extends javax.swing.JDialog {
    private static InfDB db = DatabaseConnection.getInstance();
    private Location location;
    private LocationPanel home;
    /**
     * Skapar ett nytt dialogfönster för att redigera en plats
     */
    public editLocationDialog(java.awt.Frame parent, boolean modal,LocationPanel home, Location location) throws NumberFormatException, InfException {
        super(parent, modal);
        this.location = location;
        this.home = home;
        initComponents();
        getContentPane().setBackground(new Color(51,51,51));
        fillAreaComboBox();
        fillComponents(location);

    }

    //Fyller områdesCombobox med befintliga områden. 
    private void fillAreaComboBox() {
        DefaultComboBoxModel<String> model2 = new DefaultComboBoxModel<>();
        model2.addElement("Välj område");
        for (Area item: ObjectManager.Areas.areaList.values()) {
            model2.addElement(item.getId()+": "+item.getName());
        }
        areaComboBox.setModel(model2);
    }
    
    // Fyller formuläret med befintliga värden för platsen 
    private void fillComponents(Location location) {
        IDField.setText(Integer.toString(location.getId()));
        NameField.setText(location.getName());
        String sel = location.getArea().getId()+": "+location.getArea().getName();
        areaComboBox.setSelectedItem(sel);
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
        inputNameLabel = new javax.swing.JLabel();
        inputPhoneLabel = new javax.swing.JLabel();
        inputEmailLabel = new javax.swing.JLabel();
        IDField = new javax.swing.JTextField();
        NameField = new javax.swing.JTextField();
        areaComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        registerButton.setBackground(new java.awt.Color(204, 204, 204));
        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerButton.setForeground(new java.awt.Color(51, 51, 51));
        registerButton.setText("Spara");
        registerButton.setPreferredSize(new java.awt.Dimension(180, 55));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        registerAlienLabel.setBackground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        registerAlienLabel.setForeground(new java.awt.Color(204, 204, 204));
        registerAlienLabel.setText("Redigera Plats");

        inputNameLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        inputNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputNameLabel.setText("ID:");

        inputPhoneLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputPhoneLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputPhoneLabel.setText("Ange Namn:");

        inputEmailLabel.setBackground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inputEmailLabel.setForeground(new java.awt.Color(204, 204, 204));
        inputEmailLabel.setText("TIllhör:");

        IDField.setEditable(false);
        IDField.setBackground(new java.awt.Color(204, 204, 204));
        IDField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        IDField.setForeground(new java.awt.Color(51, 51, 51));

        NameField.setBackground(new java.awt.Color(204, 204, 204));
        NameField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NameField.setForeground(new java.awt.Color(51, 51, 51));
        NameField.setPreferredSize(new java.awt.Dimension(180, 40));

        areaComboBox.setBackground(new java.awt.Color(204, 204, 204));
        areaComboBox.setForeground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(inputEmailLabel)
                                    .addComponent(abortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(areaComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(inputNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPhoneLabel)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(registerAlienLabel)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(registerAlienLabel)
                .addGap(31, 31, 31)
                .addComponent(inputPhoneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputNameLabel))
                .addGap(18, 18, 18)
                .addComponent(inputEmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abortButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Metoden körs när man trycker på registrera knappen och sparar den nya informationen 
    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        if (inputValidation.fieldValidation(NameField) && inputValidation.comboBoxValidation(areaComboBox)) {

            Location temp = new Location();
            temp.cloneObject(location);
            if (!NameField.getText().isEmpty()) {
                String newName = NameField.getText();
                int areaID = Integer.parseInt(areaComboBox.getSelectedItem().toString().split(":")[0].trim());
                Area newArea = ObjectManager.Areas.areaList.get(areaID);
                temp.setName(newName);
                temp.setArea(newArea);

                try {
                    ObjectManager.updateObject(temp);
                    location = temp;

                    JOptionPane.showMessageDialog(this, "Redigeringen av plats " + location.getId() + " lyckades!");
                    home.reload();
                    this.dispose();
                } catch (InfException ex) {
                    Logger.getLogger(editLocationDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_registerButtonActionPerformed
    
    //Metoden körs närman trycker på Avbryt knappen
    private void abortButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_abortButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDField;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton abortButton;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JLabel inputEmailLabel;
    private javax.swing.JLabel inputNameLabel;
    private javax.swing.JLabel inputPhoneLabel;
    private javax.swing.JLabel registerAlienLabel;
    private javax.swing.JButton registerButton;
    // End of variables declaration//GEN-END:variables
}
