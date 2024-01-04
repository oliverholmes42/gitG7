/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

package javaapplication3.GUI.panels;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.MainPage;
import javaapplication3.models.Agent;
import javaapplication3.models.Area;
import javaapplication3.models.Location;
import javaapplication3.models.agentSubClass.Fältagent;
import javaapplication3.models.agentSubClass.KontorsChef;
import javaapplication3.models.agentSubClass.Områdeschef;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.PopupHandler;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfException;


/**
 *
 * @author mopaj
 */
public class AgentPanel extends javax.swing.JPanel {
    
    private MainPage Parent;
    public static DefaultTableModel agentTableModel;
    private com.github.lgooddatepicker.components.DatePicker startDatePicker;
    private com.github.lgooddatepicker.components.DatePicker endDatePicker;
    
   

    public AgentPanel(MainPage Parent) throws NumberFormatException, InfException {
        initComponents();
        this.Parent = Parent;
        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.DAY_OF_MONTH);    
        ObjectManager.Aliens.loadAlienList();
        this.Parent = Parent;

        agentTableModel = (DefaultTableModel) resultTable.getModel();
        loadTable();
        addListener();
        agentTableModel = (DefaultTableModel) resultTable.getModel();
        
        
        fillAreaFilter();
        setDatePicker(); 

    }
    
    private void setDatePicker(){
        
        startDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        endDatePicker = new com.github.lgooddatepicker.components.DatePicker();

    // Replace the startDate and endDate panels with DatePicker components
        startDate.setLayout(new BorderLayout());
        endDate.setLayout(new BorderLayout());
        startDate.add(startDatePicker);
        endDate.add(endDatePicker);
    }
    
    private void fillAreaFilter() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement("Välj område:");
        for(Area item : ObjectManager.Areas.areaList.values()){
            dcbm.addElement(item.getName());
        }
        areaComboBox.setModel(dcbm);
    }
    
    private void loadTable() {
        agentTableModel.setRowCount(0); // Clear existing rows

        for (Agent item : ObjectManager.Agents.agentList.values()) {
            addRow(item);
        }
    }
    
    private void addRow(Agent item) {
        String[] row = {
            Integer.toString(item.getId()),
            item.getName(),
            item.getClass().getSimpleName(),
            getSubValue(item),
            item.getTelephone(),
            item.getRecruitmentDate().toString(),
            stringLoop(item),
            item.getEmail(),
            item.getArea().getName()
            
        };
        agentTableModel.addRow(row);
    }
    
    private String stringLoop(Agent item){
        if(item.getAdmin().equals("J")){
            return "Ja";
        }
        else {
            return "Nej";
        }
    }
    
    private String getSubValue(Agent item) {
        String uniqueValue;
        if (item instanceof Fältagent) {
            uniqueValue = null;
        } else if (item instanceof KontorsChef) {
            KontorsChef kChef = (KontorsChef) item;
            uniqueValue = kChef.getOfficeName(); // Replace getArmCount() with the actual method name
        } else if (item instanceof Områdeschef) {
            Områdeschef oChef = (Områdeschef) item;
            uniqueValue = oChef.getControlArea().getName(); // Replace getBoogieCount() with the actual method name
        } else {
            // Handle the generic Alien case or unknown subclass
            uniqueValue = "Unknown Title Value";
        }
        return uniqueValue;
    }
    
    private void addListener() {
        resultTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Single click
                    int row = resultTable.getSelectedRow();
                    if (row >= 0) {
                        removeAgentButton.setEnabled(true);
                        alterAgentInfoButton.setEnabled(true);
                        
                    }
                }
            }
        }); }
    
    public void reload(){
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

        addAlienButton1 = new javax.swing.JButton();
        clearFilterButton = new javax.swing.JButton();
        removeAgentButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        alterAgentInfoButton = new javax.swing.JButton();
        searchbarTextfield = new javax.swing.JTextField();
        areaComboBox = new javax.swing.JComboBox<>();
        filterLabel = new javax.swing.JLabel();
        resultScrollPane = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        addAgentButton = new javax.swing.JButton();
        endDate = new javax.swing.JPanel();
        startDate = new javax.swing.JPanel();
        filterLabel1 = new javax.swing.JLabel();

        addAlienButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAlienButton1.setText("Lägg till Agent");
        addAlienButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        setBackground(new java.awt.Color(200, 200, 200));
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        clearFilterButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearFilterButton.setText("Rensa Filter");
        clearFilterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        clearFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterButtonActionPerformed(evt);
            }
        });

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
        alterAgentInfoButton.setText("Redigera agent");
        alterAgentInfoButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        alterAgentInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterAgentInfoButtonActionPerformed(evt);
            }
        });

        searchbarTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchbarTextfield.setForeground(new java.awt.Color(51, 51, 51));
        searchbarTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        searchbarTextfield.setOpaque(true);
        searchbarTextfield.setPreferredSize(new java.awt.Dimension(100, 45));

        areaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaComboBox.setForeground(new java.awt.Color(51, 51, 51));
        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Område" }));
        areaComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        areaComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        filterLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filterLabel.setForeground(new java.awt.Color(51, 51, 51));
        filterLabel.setText("Filtrera efter:");

        resultTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Agent ID", "Namn", "Titel", "Unikt värde", "Telefonnummer", "Anställningsdatum", "Administratör", "E-post", "Omrade"
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
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        addAgentButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAgentButton.setText("Lägg till Agent");
        addAgentButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        addAgentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAgentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout endDateLayout = new javax.swing.GroupLayout(endDate);
        endDate.setLayout(endDateLayout);
        endDateLayout.setHorizontalGroup(
            endDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        endDateLayout.setVerticalGroup(
            endDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout startDateLayout = new javax.swing.GroupLayout(startDate);
        startDate.setLayout(startDateLayout);
        startDateLayout.setHorizontalGroup(
            startDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        startDateLayout.setVerticalGroup(
            startDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        filterLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filterLabel1.setForeground(new java.awt.Color(51, 51, 51));
        filterLabel1.setText("Filtrera efter datum:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(filterLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(filterLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(addAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(alterAgentInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(removeAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(341, 341, 341)
                            .addComponent(headerLabel))))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(headerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filterLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(filterLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alterAgentInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeAgentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeAgentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAgentButtonActionPerformed
        ArrayList<Integer> selectedID = new ArrayList<Integer>();
        for (int item : resultTable.getSelectedRows()) {
            selectedID.add(Integer.parseInt((String) resultTable.getValueAt(item, 0)));
        }
        int selectedAgentCount = selectedID.size(); // Replace with your method
        String message = "Ta bort " + selectedAgentCount + " agent" + (selectedAgentCount > 1 ? "er" : "") + " från systemet?";

        int response = JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try {
                // Logic to delete the selected aliens
                ObjectManager.Agents.delete(selectedID);

            } catch (InfException ex) {
                Logger.getLogger(AgentPanel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Misslyckades. Referenser för denna agent finns på andra ställen i databasen. \nKontrollera att agenten inte används i andra objekt. (Exempel: ansvarig för alien.)");
            }
            loadTable();
        }
    }//GEN-LAST:event_removeAgentButtonActionPerformed

    private void addAgentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAgentButtonActionPerformed
        try {
            PopupHandler.addNewAgentPopup(Parent, this);
        } catch (InfException ex) {
            Logger.getLogger(AgentPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addAgentButtonActionPerformed

    private void clearFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFilterButtonActionPerformed
        areaComboBox.setSelectedIndex(0);
        startDatePicker.clear();
        endDatePicker.clear();
        searchbarTextfield.setText("");
    }//GEN-LAST:event_clearFilterButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        agentTableModel.setRowCount(0);

        LocalDate startDate = startDatePicker.getDate();
        LocalDate endDate = endDatePicker.getDate();
        String selectedLocation = (String) areaComboBox.getSelectedItem();
        String searchText = searchbarTextfield.getText().toLowerCase();
        
        for (Agent item : ObjectManager.Agents.agentList.values()) {
            LocalDate agentDate = item.getRecruitmentDate();
            String agentLocation = item.getArea().getName();
            String agentName = item.getName().toLowerCase();

            boolean dateMatches = (startDate == null || agentDate.isAfter(startDate) || agentDate.isEqual(startDate))
                    && (endDate == null || agentDate.isBefore(endDate) || agentDate.isEqual(endDate));
            boolean locationMatches = areaComboBox.getSelectedIndex() == 0 || agentLocation.equals(selectedLocation);
            boolean nameMatches = agentName.contains(searchText);

            if (nameMatches && dateMatches && locationMatches) {
                addRow(item);
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void alterAgentInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterAgentInfoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alterAgentInfoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAgentButton;
    private javax.swing.JButton addAlienButton1;
    private javax.swing.JButton alterAgentInfoButton;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JButton clearFilterButton;
    private javax.swing.JPanel endDate;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JLabel filterLabel1;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton removeAgentButton;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbarTextfield;
    private javax.swing.JPanel startDate;
    // End of variables declaration//GEN-END:variables
}
