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
import javaapplication3.GUI.MainPage;
import javaapplication3.models.Agent;
import javaapplication3.models.Alien;
import javaapplication3.models.Location;
import javaapplication3.models.alienSubclasses.Boglodite;
import javaapplication3.models.alienSubclasses.Squid;
import javaapplication3.models.alienSubclasses.Worm;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.PopupHandler;
import javaapplication3.utils.UserSession;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mopaj
 */
public class AlienPanel extends javax.swing.JPanel {
    private MainPage Parent;
    public static DefaultTableModel tableModel;
    private com.github.lgooddatepicker.components.DatePicker startDatePicker;
    private com.github.lgooddatepicker.components.DatePicker endDatePicker;

    /**
     * Creates new form AgentPanel
     */
    public AlienPanel(MainPage Parent) {
    initComponents();
    tableModel = (DefaultTableModel) resultTable.getModel();
    if (UserSession.getInstance().getType() < 5) {
            editAlienButton.setVisible(false);
            removeAlienButton.setVisible(false);
        }
    this.Parent = Parent;
    setDatePicker();

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Perform long-running data loading tasks here
                ObjectManager.Aliens.loadAlienList();
                return null;
            }

            @Override
            protected void done() {
                // This method is invoked on the EDT
                // Update your table and other UI components here
                loadTable();
                fillAreaFilter(); // Call this after the data is loaded
                addListener();
                fillAgentFilter();
            }
        };
        worker.execute();

        if (UserSession.getInstance().getType() < 5) {
            editAlienButton.setVisible(false);
            removeAlienButton.setVisible(false);
        }
    }


    private void setDatePicker(){
        startDatePicker = new com.github.lgooddatepicker.components.DatePicker();
        endDatePicker = new com.github.lgooddatepicker.components.DatePicker();

    // Replace the startDate and endDate panels with DatePicker components
        startDate.setLayout(new BorderLayout());
        startDate.add(startDatePicker);
        endDate.setLayout(new BorderLayout());
        endDate.add(endDatePicker);

        
    }
    
    private void fillAgentFilter(){
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement("Välj agent");
        for(Agent agent : ObjectManager.Agents.agentList.values()){
            dcbm.addElement(agent.getName());
        }
        agentComboBox.setModel(dcbm);
    }
    private void fillAreaFilter() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement("Välj plats");
        for(Location item : ObjectManager.Locations.locationList.values()){
            dcbm.addElement(item.getName());
        }
        areaComboBox.setModel(dcbm);
    }
    

    private void loadTable() { 

        for (Alien item : ObjectManager.Aliens.alienList.values()) {
            addRow(item);
        }
    }

    private void addRow(Alien item) {
        String[] row = {
            Integer.toString(item.getID()),
            item.getClass().getSimpleName(),
            getSubValue(item),
            item.getName(),
            item.getTelephone(),
            item.getEmail(),
            item.getRegistrationDate().toString(),
            item.getLocation().getName(),
            item.getResponsibleAgent().getName()
        };
        tableModel.addRow(row);
    }

    private String getSubValue(Alien item) {
        String uniqueValue;
        if (item instanceof Worm) {
            Worm worm = (Worm) item;
            uniqueValue = "Längd: " + worm.getLength();
        } else if (item instanceof Squid) {
            Squid squid = (Squid) item;
            uniqueValue = "Armar: " + squid.getArmCount(); // Replace getArmCount() with the actual method name
        } else if (item instanceof Boglodite) {
            Boglodite boglodite = (Boglodite) item;
            uniqueValue = "Boogies: " + boglodite.getBoogieCount(); // Replace getBoogieCount() with the actual method name
        } else {
            // Handle the generic Alien case or unknown subclass
            uniqueValue = "Unknown Alien Type";
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

        headerLabel = new javax.swing.JLabel();
        searchbarTextfield = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        areaComboBox = new javax.swing.JComboBox<>();
        raceComboBox = new javax.swing.JComboBox<>();
        filterLabel = new javax.swing.JLabel();
        resultScrollPane = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        clearFilterButton = new javax.swing.JButton();
        removeAlienButton = new javax.swing.JButton();
        addAlienButton = new javax.swing.JButton();
        editAlienButton = new javax.swing.JButton();
        startDate = new javax.swing.JPanel();
        endDate = new javax.swing.JPanel();
        agentComboBox = new javax.swing.JComboBox<>();
        filterLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(200, 200, 200));
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        headerLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(51, 51, 51));
        headerLabel.setText("Hantera Aliens");

        searchbarTextfield.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchbarTextfield.setForeground(new java.awt.Color(51, 51, 51));
        searchbarTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        searchbarTextfield.setOpaque(true);
        searchbarTextfield.setPreferredSize(new java.awt.Dimension(100, 45));

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

        areaComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaComboBox.setForeground(new java.awt.Color(51, 51, 51));
        areaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Område" }));
        areaComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        areaComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        raceComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        raceComboBox.setForeground(new java.awt.Color(51, 51, 51));
        raceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ras", "Worm", "Squid", "Boglodite" }));
        raceComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        raceComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        filterLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filterLabel.setForeground(new java.awt.Color(51, 51, 51));
        filterLabel.setText("Filtrera efter datum:");

        resultScrollPane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 63, 63), 3));

        resultTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 63, 63), 2));
        resultTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Alien ID", "Ras", "Unikt Värde", "Namn", "Telefonnummer", "E-post", "Incheckningsdatum", "Plats", "Ansvarig Agent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTable.setToolTipText("");
        resultTable.setRowHeight(60);
        resultTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        resultTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        resultTable.getTableHeader().setResizingAllowed(false);
        resultTable.getTableHeader().setReorderingAllowed(false);
        resultScrollPane.setViewportView(resultTable);
        if (resultTable.getColumnModel().getColumnCount() > 0) {
            resultTable.getColumnModel().getColumn(1).setResizable(false);
        }

        clearFilterButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        clearFilterButton.setText("Rensa Filter");
        clearFilterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        clearFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterButtonActionPerformed(evt);
            }
        });

        removeAlienButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        removeAlienButton.setText("Ta bort Alien");
        removeAlienButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        removeAlienButton.setEnabled(false);
        removeAlienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAlienButtonActionPerformed(evt);
            }
        });

        addAlienButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addAlienButton.setText("Lägg till Alien");
        addAlienButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        addAlienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAlienButtonActionPerformed(evt);
            }
        });

        editAlienButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editAlienButton.setText("Redigera Alien");
        editAlienButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        editAlienButton.setEnabled(false);
        editAlienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAlienButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startDateLayout = new javax.swing.GroupLayout(startDate);
        startDate.setLayout(startDateLayout);
        startDateLayout.setHorizontalGroup(
            startDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        startDateLayout.setVerticalGroup(
            startDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout endDateLayout = new javax.swing.GroupLayout(endDate);
        endDate.setLayout(endDateLayout);
        endDateLayout.setHorizontalGroup(
            endDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        endDateLayout.setVerticalGroup(
            endDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        agentComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agentComboBox.setForeground(new java.awt.Color(51, 51, 51));
        agentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agent" }));
        agentComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        agentComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        filterLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filterLabel1.setForeground(new java.awt.Color(51, 51, 51));
        filterLabel1.setText("Filtrera efter:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(headerLabel)
                        .addGap(377, 377, 377))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(resultScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(filterLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(filterLabel))
                                    .addGap(24, 24, 24)
                                    .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(raceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(removeAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(editAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(headerLabel)
                        .addGap(46, 46, 46)
                        .addComponent(filterLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(filterLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeAlienButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editAlienButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(agentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(raceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)))
                .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addAlienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlienButtonActionPerformed
        // TODO add your handling code here:
        PopupHandler.addNewAlienPopup(Parent, this);
    }//GEN-LAST:event_addAlienButtonActionPerformed
    
    public void reload(){
        tableModel.setRowCount(0);
        loadTable();
    }
    //Metod för att hämta eftersökt data
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        tableModel.setRowCount(0);

        LocalDate startDate = startDatePicker.getDate();
        LocalDate endDate = endDatePicker.getDate();
        String selectedRace = (String) raceComboBox.getSelectedItem();
        String selectedLocation = (String) areaComboBox.getSelectedItem();
        String selectedAgent = (String) agentComboBox.getSelectedItem();
        String searchText = searchbarTextfield.getText().toLowerCase();

        for (Alien item : ObjectManager.Aliens.alienList.values()) {
            LocalDate alienDate = item.getRegistrationDate();
            String alienRace = item.getClass().getSimpleName();
            String alienLocation = item.getLocation().getName();
            String alienName = item.getName().toLowerCase();
            String alienAgent = item.getResponsibleAgent().getName();

            boolean dateMatches = (startDate == null || alienDate.isAfter(startDate) || alienDate.isEqual(startDate))
                    && (endDate == null || alienDate.isBefore(endDate) || alienDate.isEqual(endDate));
            boolean raceMatches = raceComboBox.getSelectedIndex() == 0 || alienRace.equals(selectedRace);
            boolean locationMatches = areaComboBox.getSelectedIndex() == 0 || alienLocation.equals(selectedLocation);
            boolean nameMatches = alienName.contains(searchText);
            boolean agentMatches = agentComboBox.getSelectedIndex() == 0 || alienAgent.equals(selectedAgent);

            if (nameMatches && dateMatches && raceMatches && locationMatches && agentMatches) {
                addRow(item);
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void removeAlienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAlienButtonActionPerformed
        // TODO add your handling code here:'
        ArrayList<Integer> selectedID = new ArrayList<Integer>();
        for (int item : resultTable.getSelectedRows()) {
            selectedID.add(Integer.parseInt((String) resultTable.getValueAt(item, 0)));
        }
        int selectedAlienCount = selectedID.size(); // Replace with your method
        String message = "Ta bort " + selectedAlienCount + " alien" + (selectedAlienCount > 1 ? "s" : "") + " från systemet?";

        int response = JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            // Logic to delete the selected aliens
            ObjectManager.Aliens.delete(selectedID);
            reload();
        }
    }//GEN-LAST:event_removeAlienButtonActionPerformed

    private void editAlienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAlienButtonActionPerformed
        // TODO add your handling code here:
        if(resultTable.getSelectedRows().length==1){
            PopupHandler.editAlienPopup(Parent,this,ObjectManager.Aliens.alienList.get(Integer.parseInt((String) resultTable.getValueAt(resultTable.getSelectedRow(), 0))));
        }
        else {JOptionPane.showMessageDialog(this,"Endast en Alien kan redigeras samtidigt!");}
    }//GEN-LAST:event_editAlienButtonActionPerformed

    private void clearFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFilterButtonActionPerformed
        agentComboBox.setSelectedIndex(0);
        areaComboBox.setSelectedIndex(0);
        raceComboBox.setSelectedIndex(0);
        searchbarTextfield.setText("");
        startDatePicker.clear();
        endDatePicker.clear();
        reload();
    }//GEN-LAST:event_clearFilterButtonActionPerformed

    
    
    
    private void addListener() {
        resultTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Single click
                    int row = resultTable.getSelectedRow();
                    if (row >= 0) {
                        removeAlienButton.setEnabled(true);
                        editAlienButton.setEnabled(true);

                    }
                }
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAlienButton;
    private javax.swing.JComboBox<String> agentComboBox;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JButton clearFilterButton;
    private javax.swing.JButton editAlienButton;
    private javax.swing.JPanel endDate;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JLabel filterLabel1;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JComboBox<String> raceComboBox;
    private javax.swing.JButton removeAlienButton;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbarTextfield;
    private javax.swing.JPanel startDate;
    // End of variables declaration//GEN-END:variables
}
