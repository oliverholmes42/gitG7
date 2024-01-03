/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import java.util.HashMap;
import javaapplication3.GUI.MainPage;
import static javaapplication3.GUI.panels.AlienPanel.tableModel;
import javaapplication3.models.Utilities;
import javaapplication3.models.utilitySubClasses.CommunicationsDevice;
import javaapplication3.models.utilitySubClasses.Tech;
import javaapplication3.models.utilitySubClasses.Weapon;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.PopupHandler;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfException;

/**
 *
 * @author mopaj
 */
public class EquipmentPanel extends javax.swing.JPanel {

    private final MainPage Parent;
    /**
     * Creates new form AgentPanel
     * @param Parent
     */
    public EquipmentPanel(MainPage Parent) throws NumberFormatException, InfException {
        initComponents();
        this.Parent = Parent;
        ObjectManager.UtilitiesHandler.loadList();
        ObjectManager.AgentUtilityHandler.loadList();
        tableModel = (DefaultTableModel) utilityTable.getModel();
        loadTable();
    }
    
    private void loadTable(){
        tableModel.setRowCount(0);
        for(Utilities item : ObjectManager.UtilitiesHandler.utilitiesList.values()){
            HashMap<String,String> itemMap = ObjectManager.AgentUtilityHandler.checkUtilityStatus(item);
            String[] row = {
                Integer.toString(item.getID()),
                item.getName(),
                item.getClass().getSimpleName(),
                getSubValue(item),
                itemMap.get("Status"),
                itemMap.get("Borrower"),
                itemMap.get("Date")
            };
            tableModel.addRow(row);
        }
    }

    private String getSubValue(Utilities utility) {
                String uniqueValue;
         if (utility instanceof Weapon) {
             Weapon weapon = (Weapon) utility;
             uniqueValue = "Kaliber: " + weapon.getCaliber(); // Replace getCaliber() with the actual method name
         } else if (utility instanceof CommunicationsDevice) {
             CommunicationsDevice commsDevice = (CommunicationsDevice) utility;
             uniqueValue = "Överföringsteknik: " + commsDevice.getTransmissionTech(); // Replace getTransmissionTech() with the actual method name
         } else if (utility instanceof Tech) {
             Tech tech = (Tech) utility;
             uniqueValue = "Kraftkälla: " + tech.getPowersource(); // Replace getPowersource() with the actual method name
         } else {
             // Handle the generic Utilities case or unknown subclass
             uniqueValue = "Unknown Utility Type";
         }
         return uniqueValue;
       }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        utrustningTitel = new javax.swing.JLabel();
        searchPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        sökUtrusningRubrik = new javax.swing.JLabel();
        laggTillButton = new javax.swing.JButton();
        raderaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        utilityTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lånaButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 200, 200));
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        utrustningTitel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        utrustningTitel.setForeground(new java.awt.Color(51, 51, 51));
        utrustningTitel.setText("Utrustning");

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        searchPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 2));
        searchPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        searchButton.setText("Sök");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        sökUtrusningRubrik.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sökUtrusningRubrik.setForeground(new java.awt.Color(51, 51, 51));
        sökUtrusningRubrik.setText("Sök utrustning:");

        laggTillButton.setText("Lägg till utrustning");
        laggTillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laggTillButtonActionPerformed(evt);
            }
        });

        raderaButton.setText("Radera utrustning");
        raderaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raderaButtonActionPerformed(evt);
            }
        });

        utilityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Utrustning ID", "Benämning ", "Typ", "Unikt Värde", "Status", "Datum för lån", "Lånad av "
            }
        ));
        utilityTable.setRowHeight(60);
        jScrollPane1.setViewportView(utilityTable);

        jButton1.setText("Återlämna utrustning");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lånaButton.setText("Låna utrustning");
        lånaButton.setEnabled(false);
        lånaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lånaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(168, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sökUtrusningRubrik)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(utrustningTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(laggTillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(raderaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6))
                                .addComponent(searchPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(35, 35, 35)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lånaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(utrustningTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(laggTillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(raderaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addComponent(sökUtrusningRubrik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lånaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(225, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchButtonActionPerformed

    private void laggTillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laggTillButtonActionPerformed
        PopupHandler.addNewUtilitiesPopup(Parent);

    }//GEN-LAST:event_laggTillButtonActionPerformed

    private void raderaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raderaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raderaButtonActionPerformed

    private void lånaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lånaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lånaButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laggTillButton;
    private javax.swing.JButton lånaButton;
    private javax.swing.JButton raderaButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JLabel sökUtrusningRubrik;
    private javax.swing.JTable utilityTable;
    private javax.swing.JLabel utrustningTitel;
    // End of variables declaration//GEN-END:variables
}
