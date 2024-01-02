/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import javaapplication3.GUI.MainPage;
import javaapplication3.models.Area;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.ObjectManager.Areas;
import static javaapplication3.utils.ObjectManager.db;
import javaapplication3.utils.PopupHandler;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfException;

/**
 *
 * @author aiham
 */
public class AreaPanel extends javax.swing.JPanel {

    private MainPage Parent;
    public static DefaultTableModel areaTableModel;

    /**
     * Creates new form OmradePanel
     */
    public AreaPanel() throws NumberFormatException, InfException {
        initComponents();
        ObjectManager.Areas.loadList();
        areaTableModel = (DefaultTableModel) jTable2.getModel();
        loadTable();      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        searchOmradeTextField = new javax.swing.JTextField();
        updateInfo = new javax.swing.JButton();
        deleteArea = new javax.swing.JButton();
        addArea = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 200, 200));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Område");

        jTable2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jTable2.setForeground(new java.awt.Color(40, 40, 40));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Namn på område", "Antal agenter", "Antal Aliens"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setAlignmentX(1.5F);
        jTable2.setAlignmentY(1.5F);
        jTable2.setName(""); // NOI18N
        jTable2.setRowHeight(80);
        jTable2.setRowMargin(1);
        jTable2.setRowSelectionAllowed(false);
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        searchOmradeTextField.setText("Sök här!");
        searchOmradeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchOmradeTextFieldActionPerformed(evt);
            }
        });

        updateInfo.setText("Uppdatera information");

        deleteArea.setLabel("Ta bort område");

        addArea.setText("Lägg till område");
        addArea.setToolTipText("");
        addArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchOmradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addArea, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(deleteArea, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(512, 512, 512))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(searchOmradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addArea, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteArea, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchOmradeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchOmradeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchOmradeTextFieldActionPerformed

    private void addAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAreaActionPerformed
        PopupHandler.addNewAreaPopup(Parent);

    }//GEN-LAST:event_addAreaActionPerformed
    
   
    private static void loadTable() throws InfException {
        areaTableModel.setRowCount(0);
        for (Area i : ObjectManager.Areas.areaList.values()) {
            String[] row = {
                i.getName(),
                db.fetchSingle("SELECT COUNT(Agent_ID) FROM agent WHERE Omrade = " + i.getId()),
                db.fetchSingle("SELECT count(DISTINCT Alien_ID) FROM alien JOIN plats ON alien.Plats = plats.Plats_ID join omrade on plats.Finns_I =" + i.getId())
            };
            areaTableModel.addRow(row);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addArea;
    private javax.swing.JButton deleteArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField searchOmradeTextField;
    private javax.swing.JButton updateInfo;
    // End of variables declaration//GEN-END:variables
}
