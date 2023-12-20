/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

/**
 *
 * @author mopaj
 */
public class AgentPanel extends javax.swing.JPanel {

    /**
     * Creates new form AgentPanel
     */
    public AgentPanel() {
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

        clearFilterButton = new javax.swing.JButton();
        removeAgentButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        alterAgentInfoButton = new javax.swing.JButton();
        searchbarTextfield = new javax.swing.JTextField();
        monthPickerComboBox = new javax.swing.JComboBox<>();
        areaComboBox = new javax.swing.JComboBox<>();
        yearPickerComboBox = new javax.swing.JComboBox<>();
        filterLabel = new javax.swing.JLabel();
        resultScrollPane = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        addAlienButton1 = new javax.swing.JButton();
        addAgentButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(200, 200, 200));
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        clearFilterButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearFilterButton.setText("Rensa Filter");
        clearFilterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        removeAgentButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        removeAgentButton.setText("Ta bort Agent");
        removeAgentButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        removeAgentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAgentButtonActionPerformed(evt);
            }
        });

        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(51, 51, 51));
        headerLabel.setText("Hantera Agenter");

        alterAgentInfoButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        alterAgentInfoButton.setText("Ändra Agent Info");
        alterAgentInfoButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        searchbarTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchbarTextfield.setForeground(new java.awt.Color(51, 51, 51));
        searchbarTextfield.setText("Sök efter Agent...");
        searchbarTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        searchbarTextfield.setOpaque(true);
        searchbarTextfield.setPreferredSize(new java.awt.Dimension(100, 45));

        monthPickerComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        monthPickerComboBox.setForeground(new java.awt.Color(51, 51, 51));
        monthPickerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Månad" }));
        monthPickerComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        areaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaComboBox.setForeground(new java.awt.Color(51, 51, 51));
        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Område" }));
        areaComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        areaComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        yearPickerComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yearPickerComboBox.setForeground(new java.awt.Color(51, 51, 51));
        yearPickerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "År" }));
        yearPickerComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        yearPickerComboBox.setOpaque(true);
        yearPickerComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        filterLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filterLabel.setForeground(new java.awt.Color(51, 51, 51));
        filterLabel.setText("Filtrera efter:");

        resultTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Agent ID", "Namn", "Telefonnummer", "Anställningsdatum", "Administratör", "E-post", "Losenord", "Omrade"
            }
        ));
        resultTable.setRowHeight(60);
        resultTable.getTableHeader().setResizingAllowed(false);
        resultTable.getTableHeader().setReorderingAllowed(false);
        resultScrollPane.setViewportView(resultTable);

        searchButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchButton.setForeground(new java.awt.Color(51, 51, 51));
        searchButton.setText("Sök");
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        searchButton.setOpaque(true);

        addAlienButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAlienButton1.setText("Lägg till Agent");
        addAlienButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        addAgentButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAgentButton.setText("Lägg till Agent");
        addAgentButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(alterAgentInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(removeAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(yearPickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(headerLabel)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(monthPickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(filterLabel)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addAlienButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(headerLabel)
                .addGap(67, 67, 67)
                .addComponent(filterLabel)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearPickerComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthPickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterAgentInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(addAlienButton1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeAgentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAgentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeAgentButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAgentButton;
    private javax.swing.JButton addAlienButton1;
    private javax.swing.JButton alterAgentInfoButton;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JButton clearFilterButton;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JComboBox<String> monthPickerComboBox;
    private javax.swing.JButton removeAgentButton;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbarTextfield;
    private javax.swing.JComboBox<String> yearPickerComboBox;
    // End of variables declaration//GEN-END:variables
}
