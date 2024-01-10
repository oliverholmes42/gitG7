/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.MainPage;
import javaapplication3.models.Utilities;
import javaapplication3.models.utilitySubClasses.Kommunikation;
import javaapplication3.models.utilitySubClasses.Teknik;
import javaapplication3.models.utilitySubClasses.Vapen;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.PopupHandler;
import javaapplication3.utils.UserSession;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfException;

/**
 *
 * @author mopaj
 */
public class EquipmentPanel extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
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
        addListener();
        
        if(UserSession.getInstance().getType() < 5){
            raderaButton.setVisible(false);
        }
    }
    
    private void loadTable(){
        tableModel.setRowCount(0);
        for(Utilities item : ObjectManager.UtilitiesHandler.utilitiesList.values()){
            addRow(item);
        }
    }

    private void addRow(Utilities item){
        HashMap<String,String> itemMap = ObjectManager.AgentUtilityHandler.getUtilityInfo(item);
        String[] row = {
            Integer.toString(item.getID()),
            item.getName(),
            item.getClass().getSimpleName(),
            getSubValue(item),
            itemMap.get("Status"),
            itemMap.get("Date"),
            itemMap.get("Borrower")
        };
        tableModel.addRow(row);
    }
    
    public void reload(){
        loadTable();
    }
    

    private String getSubValue(Utilities utility) {
                String uniqueValue;
         if (utility instanceof Vapen) {
             Vapen weapon = (Vapen) utility;
             uniqueValue = "Kaliber: " + weapon.getCaliber(); // Replace getCaliber() with the actual method name
         } else if (utility instanceof Kommunikation) {
             Kommunikation commsDevice = (Kommunikation) utility;
             uniqueValue = "Överföringsteknik: " + commsDevice.getTransmissionTech(); // Replace getTransmissionTech() with the actual method name
         } else if (utility instanceof Teknik) {
             Teknik tech = (Teknik) utility;
             uniqueValue = "Kraftkälla: " + tech.getPowersource(); // Replace getPowersource() with the actual method name
         } else {
             // Handle the generic Utilities case or unknown subclass
             uniqueValue = "Unknown Utility Type";
         }
         return uniqueValue;
       }
    
    private void addListener() {
        utilityTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Single click
                    int[] rows = utilityTable.getSelectedRows();
                    boolean free = isFree(rows);
                            
                    if (rows.length >= 0&& free) {
                        lånaButton.setEnabled(true);
                        raderaButton.setEnabled(true);
                        
                        
                    }else{
                        lånaButton.setEnabled(false);
                        raderaButton.setEnabled(true);
                    }
                }
            }
        }); }
    
    private boolean isFree(int[] rows){
        for(int i : rows){
            if(utilityTable.getValueAt(i, 5)!=null){
                return false;
            }
        }
        return true;
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
        searchButton = new javax.swing.JButton();
        sökUtrusningRubrik = new javax.swing.JLabel();
        laggTillButton = new javax.swing.JButton();
        raderaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        utilityTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lånaButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();

        setBackground(new java.awt.Color(200, 200, 200));
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        utrustningTitel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        utrustningTitel.setForeground(new java.awt.Color(51, 51, 51));
        utrustningTitel.setText("Utrustning");

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        utilityTable.setRowHeight(60);
        jScrollPane1.setViewportView(utilityTable);

        jButton1.setText("Återlämna utrustning");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(utrustningTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(laggTillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(raderaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lånaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(sökUtrusningRubrik)))
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(utrustningTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(sökUtrusningRubrik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(laggTillButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(raderaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lånaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(225, 225, 225))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        tableModel.setRowCount(0);
        String searched = searchField.getText().toLowerCase();
        for(Utilities item : ObjectManager.UtilitiesHandler.utilitiesList.values()){
            boolean nameMatch = item.getName().toLowerCase().contains(searched);
            boolean typeMatch = item.getClass().getSimpleName().toLowerCase().contains(searched);
            
            if(nameMatch||typeMatch){addRow(item);}
        }
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void laggTillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laggTillButtonActionPerformed
        try {
            PopupHandler.addNewUtilitiesPopup(Parent, this);
        } catch (InfException ex) {
            Logger.getLogger(EquipmentPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_laggTillButtonActionPerformed

    private void raderaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raderaButtonActionPerformed
        ArrayList<Integer> selectedID = new ArrayList<Integer>();
        for (int item : utilityTable.getSelectedRows()) {
            selectedID.add(Integer.parseInt((String) utilityTable.getValueAt(item, 0)));
        }
        int selectedUtilityCount = selectedID.size(); // Replace with your method
        String message = "Ta bort " + selectedUtilityCount + " redskap" + (selectedUtilityCount > 1 ? "s" : "") + " från systemet?";

        int response = JOptionPane.showConfirmDialog(null, message, "Bekräfta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            // Logic to delete the selected aliens
            ObjectManager.UtilitiesHandler.delete(selectedID);
            loadTable();
        }
    }//GEN-LAST:event_raderaButtonActionPerformed

    private void lånaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lånaButtonActionPerformed
         ArrayList<Utilities> selectedUtils = new ArrayList<>();
    for (int i = 0; i < utilityTable.getSelectedRows().length; i++) {
        int rowIndex = utilityTable.getSelectedRows()[i];
        int id = Integer.parseInt(utilityTable.getValueAt(rowIndex, 0).toString());
        Utilities util = ObjectManager.UtilitiesHandler.utilitiesList.get(id);
        if (util != null) {
            selectedUtils.add(util);
        }
    }
        int selectedUtilCount = selectedUtils.size();
        String confirmMessage = "Låna " + selectedUtilCount + " redskap?";

        int response = JOptionPane.showConfirmDialog(null, confirmMessage, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try {
                ObjectManager.AgentUtilityHandler.addNew(selectedUtils);
                loadTable();

                // After successful loan processing, show the completion dialog
                String completionMessage = selectedUtilCount + " redskap lånade";
                JOptionPane.showMessageDialog(null, completionMessage, "Loan Completed", JOptionPane.INFORMATION_MESSAGE);
            } catch (InfException ex) {
                Logger.getLogger(EquipmentPanel.class.getName()).log(Level.SEVERE, null, ex);
                // Optionally, show an error dialog
                JOptionPane.showMessageDialog(null, "An error occurred during the loan process.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_lånaButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        PopupHandler.returnUtilityPopup(Parent, this);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton laggTillButton;
    private javax.swing.JButton lånaButton;
    private javax.swing.JButton raderaButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel sökUtrusningRubrik;
    private javax.swing.JTable utilityTable;
    private javax.swing.JLabel utrustningTitel;
    // End of variables declaration//GEN-END:variables
}
