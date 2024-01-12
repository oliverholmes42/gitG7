/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI.editDialogs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javaapplication3.GUI.panels.EquipmentPanel;
import javaapplication3.models.Utilities;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.UserSession;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import oru.inf.InfException;


public class returnEquipmentDialog extends javax.swing.JDialog {

    private int shownLayers = 1;
    private HashMap<Integer, Utilities> available = ObjectManager.AgentUtilityHandler.getAgentUtils(ObjectManager.Agents.agentList.get(UserSession.getInstance().getUserId()));
    private EquipmentPanel home;
    
    
    /**
     * Skapar en ny instans av ReturnEquipmentDialog 
     */
    public returnEquipmentDialog(java.awt.Frame parent,EquipmentPanel home, boolean modal) {
        super(parent, modal);
        this.home = home;
        initComponents();
        getContentPane().setBackground(new Color(51,51,51));
        setComponentsVisible(false);
        setModel();
        setupComboBoxListeners();
    }

    // Gömmer eller visar komponenter beroende på omde ska vara synliga eller inte
    private void setComponentsVisible(boolean visible) {
        // För JComboBoxes
        U2Box.setVisible(visible);
        U3Box.setVisible(visible);
        U4Box.setVisible(visible);
        U5Box.setVisible(visible);
        U6Box.setVisible(visible);
        U7Box.setVisible(visible);
        U8Box.setVisible(visible);
        U9Box.setVisible(visible);
        U10Box.setVisible(visible);

        // För JLabels
        U2Label.setVisible(visible);
        U3Label.setVisible(visible);
        U4Label.setVisible(visible);
        U5Label.setVisible(visible);
        U6Label.setVisible(visible);
        U7Label.setVisible(visible);
        U8Label.setVisible(visible);
        U9Label.setVisible(visible);
        U10Label.setVisible(visible);
    }

    //Visar lager av utrustningsval
    private void showNextLayer() {
        shownLayers++;

        // Visar nästa lager baserat på värdet av shownLAyers
        switch (shownLayers) {
            case 2:
                U2Box.setVisible(true);
                U2Label.setVisible(true);
                break;
            case 3:
                U3Box.setVisible(true);
                U3Label.setVisible(true);
                break;
            case 4:
                U4Box.setVisible(true);
                U4Label.setVisible(true);
                break;
            case 5:
                U5Box.setVisible(true);
                U5Label.setVisible(true);
                break;
            case 6:
                U6Box.setVisible(true);
                U6Label.setVisible(true);
                break;
            case 7:
                U7Box.setVisible(true);
                U7Label.setVisible(true);
                break;
            case 8:
                U8Box.setVisible(true);
                U8Label.setVisible(true);
                break;
            case 9:
                U9Box.setVisible(true);
                U9Label.setVisible(true);
                break;
            case 10:
                U10Box.setVisible(true);
                U10Label.setVisible(true);
                addLayerButton.setVisible(false);
                break;
            default:
                // Hanterar fallet när alla lager har visats 
                // Återställ räknaren till 2 eller implementera annan logik vid behov 
                shownLayers = 1; // Återställer till 1, så nästa ökning sätter den till 2
                break;
        }
    }

    //Sätter modellen för ComboBoxes baserat på tillgänglig utrustning
    private void setModel() {
        for (int i = 0; i < 10; i++) {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Välj Utrustning");
            for (Utilities item : available.values()) {
                model.addElement(item.getID() + ": " + item.getName());
            }
            getComboBoxByIndex(i).setModel(model);
        }
    }

    //Metoden skapar en Action listner för Combobox 
    private ActionListener createComboBoxListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> sourceComboBox = (JComboBox<String>) e.getSource();
                String selectedItem = (String) sourceComboBox.getSelectedItem();
                if (sourceComboBox.getSelectedIndex() != 0) {
                    if (selectedItem != null && !selectedItem.isEmpty()) {
                        updateOtherComboBoxModels(sourceComboBox, selectedItem);
                    }
                }
            }
        };
    }

    //Metoden uppdaterar modellerna för andra ComboBoxes när en väljs 
    private void updateOtherComboBoxModels(JComboBox<String> sourceComboBox, String selectedItem) {
        for (int i = 0; i < 10; i++) {
            JComboBox<String> currentBox = getComboBoxByIndex(i);
            if (currentBox != sourceComboBox) {
                DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) currentBox.getModel();
                model.removeElement(selectedItem);
            }
        }
    }

    // Hämtar rätt ComboBox baserat på index
    private JComboBox<String> getComboBoxByIndex(int index) {
        switch (index) {
            case 0:
                return U1Box;
            case 1:
                return U2Box;
            case 2:
                return U3Box;
            case 3:
                return U4Box;
            case 4:
                return U5Box;
            case 5:
                return U6Box;
            case 6:
                return U7Box;
            case 7:
                return U8Box;
            case 8:
                return U9Box;
            case 9:
                return U10Box;
            default:
                return null; 
        }
    }

    //Ställer in ActionListner för ComboBoxes
    private void setupComboBoxListeners() {
        ActionListener comboBoxListener = createComboBoxListener();

        U1Box.addActionListener(comboBoxListener);
        U2Box.addActionListener(comboBoxListener);
        U3Box.addActionListener(comboBoxListener);
        U4Box.addActionListener(comboBoxListener);
        U5Box.addActionListener(comboBoxListener);
        U6Box.addActionListener(comboBoxListener);
        U7Box.addActionListener(comboBoxListener);
        U8Box.addActionListener(comboBoxListener);
        U9Box.addActionListener(comboBoxListener);
        U10Box.addActionListener(comboBoxListener);
    }
    
    //Hämtar ID för valda utrustningar från ComboBoxes
    private ArrayList<Integer> getSelectedID() {
    ArrayList<Integer> selectedIDs = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
        JComboBox<String> comboBox = getComboBoxByIndex(i);

        if (comboBox.getSelectedIndex()!=0) {
            String selectedItem = (String) comboBox.getSelectedItem();
            try {
                int id = Integer.parseInt(selectedItem.split(":")[0].trim());
                selectedIDs.add(id);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing ID from selected item: " + selectedItem);
                // Handle the error appropriately
            }
        }
    }

    return selectedIDs;
}

    @SuppressWarnings("unchecked")
    //Initialisering av komponenter
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        U1Box = new javax.swing.JComboBox<>();
        U3Box = new javax.swing.JComboBox<>();
        U2Box = new javax.swing.JComboBox<>();
        U6Box = new javax.swing.JComboBox<>();
        U5Box = new javax.swing.JComboBox<>();
        U4Box = new javax.swing.JComboBox<>();
        U7Box = new javax.swing.JComboBox<>();
        U10Box = new javax.swing.JComboBox<>();
        U9Box = new javax.swing.JComboBox<>();
        U8Box = new javax.swing.JComboBox<>();
        titleLabel = new javax.swing.JLabel();
        U2Label = new javax.swing.JLabel();
        U1Label = new javax.swing.JLabel();
        U3Label = new javax.swing.JLabel();
        U9Label = new javax.swing.JLabel();
        U5Label = new javax.swing.JLabel();
        U4Label = new javax.swing.JLabel();
        U6Label = new javax.swing.JLabel();
        U7Label = new javax.swing.JLabel();
        U8Label = new javax.swing.JLabel();
        U10Label = new javax.swing.JLabel();
        addLayerButton = new javax.swing.JButton();
        returnItemsButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        U1Box.setBackground(new java.awt.Color(200, 200, 200));
        U1Box.setForeground(new java.awt.Color(51, 51, 51));
        U1Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U3Box.setBackground(new java.awt.Color(200, 200, 200));
        U3Box.setForeground(new java.awt.Color(51, 51, 51));
        U3Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U2Box.setBackground(new java.awt.Color(200, 200, 200));
        U2Box.setForeground(new java.awt.Color(51, 51, 51));
        U2Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U6Box.setBackground(new java.awt.Color(200, 200, 200));
        U6Box.setForeground(new java.awt.Color(51, 51, 51));
        U6Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U5Box.setBackground(new java.awt.Color(200, 200, 200));
        U5Box.setForeground(new java.awt.Color(51, 51, 51));
        U5Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U4Box.setBackground(new java.awt.Color(200, 200, 200));
        U4Box.setForeground(new java.awt.Color(51, 51, 51));
        U4Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U7Box.setBackground(new java.awt.Color(200, 200, 200));
        U7Box.setForeground(new java.awt.Color(51, 51, 51));
        U7Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U10Box.setBackground(new java.awt.Color(200, 200, 200));
        U10Box.setForeground(new java.awt.Color(51, 51, 51));
        U10Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U9Box.setBackground(new java.awt.Color(200, 200, 200));
        U9Box.setForeground(new java.awt.Color(51, 51, 51));
        U9Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        U8Box.setBackground(new java.awt.Color(200, 200, 200));
        U8Box.setForeground(new java.awt.Color(51, 51, 51));
        U8Box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        titleLabel.setBackground(new java.awt.Color(221, 221, 221));
        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Returnera Utrustning");

        U2Label.setBackground(new java.awt.Color(221, 221, 221));
        U2Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U2Label.setForeground(new java.awt.Color(255, 255, 255));
        U2Label.setText("Utrustning 2");

        U1Label.setBackground(new java.awt.Color(221, 221, 221));
        U1Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U1Label.setForeground(new java.awt.Color(255, 255, 255));
        U1Label.setText("Utrustning 1");

        U3Label.setBackground(new java.awt.Color(221, 221, 221));
        U3Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U3Label.setForeground(new java.awt.Color(255, 255, 255));
        U3Label.setText("Utrustning 3");

        U9Label.setBackground(new java.awt.Color(221, 221, 221));
        U9Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U9Label.setForeground(new java.awt.Color(255, 255, 255));
        U9Label.setText("Utrustning 9");

        U5Label.setBackground(new java.awt.Color(221, 221, 221));
        U5Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U5Label.setForeground(new java.awt.Color(255, 255, 255));
        U5Label.setText("Utrustning 5");

        U4Label.setBackground(new java.awt.Color(221, 221, 221));
        U4Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U4Label.setForeground(new java.awt.Color(255, 255, 255));
        U4Label.setText("Utrustning 4");

        U6Label.setBackground(new java.awt.Color(221, 221, 221));
        U6Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U6Label.setForeground(new java.awt.Color(255, 255, 255));
        U6Label.setText("Utrustning 6");

        U7Label.setBackground(new java.awt.Color(221, 221, 221));
        U7Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U7Label.setForeground(new java.awt.Color(255, 255, 255));
        U7Label.setText("Utrustning 7");

        U8Label.setBackground(new java.awt.Color(221, 221, 221));
        U8Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U8Label.setForeground(new java.awt.Color(255, 255, 255));
        U8Label.setText("Utrustning 8");

        U10Label.setBackground(new java.awt.Color(0, 255, 51));
        U10Label.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        U10Label.setForeground(new java.awt.Color(255, 255, 255));
        U10Label.setText("Utrustning 10");

        addLayerButton.setBackground(new java.awt.Color(200, 200, 200));
        addLayerButton.setForeground(new java.awt.Color(51, 51, 51));
        addLayerButton.setText("+");
        addLayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLayerButtonActionPerformed(evt);
            }
        });

        returnItemsButton.setBackground(new java.awt.Color(200, 200, 200));
        returnItemsButton.setForeground(new java.awt.Color(51, 51, 51));
        returnItemsButton.setText("Returnera");
        returnItemsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnItemsButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(200, 200, 200));
        cancelButton.setForeground(new java.awt.Color(51, 51, 51));
        cancelButton.setText("Avbryt");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(addLayerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(U10Label)
                                    .addComponent(U9Label)
                                    .addComponent(U8Label)
                                    .addComponent(U7Label)
                                    .addComponent(U6Label)
                                    .addComponent(U5Label)
                                    .addComponent(U4Label)
                                    .addComponent(U3Label)
                                    .addComponent(U2Label)
                                    .addComponent(U1Label))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(U1Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U2Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U3Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U4Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U8Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U5Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U6Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U7Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U9Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(U10Box, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleLabel)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(returnItemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 20, Short.MAX_VALUE)))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U1Label)
                    .addComponent(U1Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U2Label)
                    .addComponent(U2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U3Label)
                    .addComponent(U3Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U4Label)
                    .addComponent(U4Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U5Label)
                    .addComponent(U5Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U6Label)
                    .addComponent(U6Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U7Label)
                    .addComponent(U7Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U8Label)
                    .addComponent(U8Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U9Label)
                    .addComponent(U9Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(U10Label)
                    .addComponent(U10Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addLayerButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnItemsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Återgärd när knappen klickas
    private void addLayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLayerButtonActionPerformed

        showNextLayer();
    }//GEN-LAST:event_addLayerButtonActionPerformed

    // Metoden körs när returnera vapen klickas
    private void returnItemsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnItemsButtonActionPerformed
        try{
            ArrayList<Integer> items = getSelectedID();
        ObjectManager.AgentUtilityHandler.remove(items);
        JOptionPane.showMessageDialog(this, items.size()+" Redskap returnerades.", "Success", JOptionPane.INFORMATION_MESSAGE);
        home.reload();
        this.dispose();
        }
        catch(InfException ex) {
            JOptionPane.showMessageDialog(this, 
                                      "Retur Misslyckades", 
                                      "Error", 
                                      JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_returnItemsButtonActionPerformed
    //Metoden körs när knappen "avbryt" klickas 
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> U10Box;
    private javax.swing.JLabel U10Label;
    private javax.swing.JComboBox<String> U1Box;
    private javax.swing.JLabel U1Label;
    private javax.swing.JComboBox<String> U2Box;
    private javax.swing.JLabel U2Label;
    private javax.swing.JComboBox<String> U3Box;
    private javax.swing.JLabel U3Label;
    private javax.swing.JComboBox<String> U4Box;
    private javax.swing.JLabel U4Label;
    private javax.swing.JComboBox<String> U5Box;
    private javax.swing.JLabel U5Label;
    private javax.swing.JComboBox<String> U6Box;
    private javax.swing.JLabel U6Label;
    private javax.swing.JComboBox<String> U7Box;
    private javax.swing.JLabel U7Label;
    private javax.swing.JComboBox<String> U8Box;
    private javax.swing.JLabel U8Label;
    private javax.swing.JComboBox<String> U9Box;
    private javax.swing.JLabel U9Label;
    private javax.swing.JButton addLayerButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton returnItemsButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
