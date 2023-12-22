/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package javaapplication3.GUI;

/**
 *
 * @author aiham
 */
public class RegisterNewUtilitiesDialog extends javax.swing.JDialog {

    /**
     * Creates new form RegisterNewUtilities
     */
    public RegisterNewUtilitiesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valueOfId = new javax.swing.JLabel();
        abortAddUtilities = new javax.swing.JButton();
        nameOfUtilites = new javax.swing.JLabel();
        nameOfNewArea = new javax.swing.JTextField();
        areaID = new javax.swing.JTextField();
        addAreaText = new javax.swing.JLabel();
        confirmAddUtilities = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        valueOfId.setBackground(new java.awt.Color(221, 221, 221));
        valueOfId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        valueOfId.setText("ID:");

        abortAddUtilities.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        abortAddUtilities.setText("Avbryt");
        abortAddUtilities.setToolTipText("");
        abortAddUtilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abortAddUtilitiesActionPerformed(evt);
            }
        });

        nameOfUtilites.setBackground(new java.awt.Color(221, 221, 221));
        nameOfUtilites.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameOfUtilites.setText("Benämning på Utrustning:");

        areaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaIDActionPerformed(evt);
            }
        });

        addAreaText.setBackground(new java.awt.Color(221, 221, 221));
        addAreaText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        addAreaText.setText("Lägg till Utrustning");

        confirmAddUtilities.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        confirmAddUtilities.setText("Bekräfta");
        confirmAddUtilities.setToolTipText("");
        confirmAddUtilities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAddUtilitiesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(valueOfId)
                        .addGap(55, 55, 55)
                        .addComponent(nameOfUtilites))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(addAreaText))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(areaID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nameOfNewArea, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(abortAddUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(261, 261, 261)
                    .addComponent(confirmAddUtilities, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(85, 85, 85)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(addAreaText)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(valueOfId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(areaID))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameOfUtilites)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameOfNewArea, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addComponent(abortAddUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(262, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(331, Short.MAX_VALUE)
                    .addComponent(confirmAddUtilities, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(261, 261, 261)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void abortAddUtilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abortAddUtilitiesActionPerformed
        this.dispose();
    }//GEN-LAST:event_abortAddUtilitiesActionPerformed

    private void areaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaIDActionPerformed

    private void confirmAddUtilitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAddUtilitiesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmAddUtilitiesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abortAddUtilities;
    private javax.swing.JLabel addAreaText;
    private javax.swing.JTextField areaID;
    private javax.swing.JButton confirmAddUtilities;
    private javax.swing.JTextField nameOfNewArea;
    private javax.swing.JLabel nameOfUtilites;
    private javax.swing.JLabel valueOfId;
    // End of variables declaration//GEN-END:variables
}
