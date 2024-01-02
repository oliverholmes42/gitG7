/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import javaapplication3.GUI.MainPage;
import javaapplication3.models.Alien;
import javaapplication3.models.Location;
import javaapplication3.models.alienSubclasses.Boglodite;
import javaapplication3.models.alienSubclasses.Squid;
import javaapplication3.models.alienSubclasses.Worm;
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
public class AlienPanel extends javax.swing.JPanel {
    private MainPage Parent;
    public static DefaultTableModel tableModel;
    /**
     * Creates new form AgentPanel
     */
    public AlienPanel(MainPage Parent) throws NumberFormatException, InfException {
        initComponents();
        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.DAY_OF_MONTH);    
        ObjectManager.Aliens.loadAlienList();
        this.Parent = Parent;

        tableModel = (DefaultTableModel) resultTable.getModel();
        loadTable();

        
        this.Parent = Parent;
        addListener();
        tableModel = (DefaultTableModel) resultTable.getModel();
        
        
        fillAreaFilter();
        addYearsToComboBox();

       
    }

    private void fillAreaFilter() {
        DefaultComboBoxModel<String> dcbm = new DefaultComboBoxModel<>();
        dcbm.addElement("Välj plats");
        for(Location item : ObjectManager.Locations.locationList.values()){
            dcbm.addElement(item.getName());
        }
        areaComboBox.setModel(dcbm);
    }
    
        private void addYearsToComboBox() {

        int minYear = Integer.MAX_VALUE;
        int maxYear = Integer.MIN_VALUE;

        for (Alien alien : ObjectManager.Aliens.alienList.values()) {
            LocalDate registrationDate = alien.getRegistrationDate();
            int year = registrationDate.getYear();

            if (year < minYear) {
                minYear = year;
            }
            if (year > maxYear) {
                maxYear = year;
            }
        }

        // Add all years between the lowest and highest years to the JComboBox
        for (int year = minYear; year <= maxYear; year++) {
            yearPickerComboBox.addItem(Integer.toString(year));
        }
    }
    

    private void loadTable() {
        tableModel.setRowCount(0); // Clear existing rows
        
        for (Alien item : ObjectManager.Aliens.alienList.values()) {
            String[] row = {
                Integer.toString(item.getID()),
                item.getClass().getSimpleName(),
                getSubValue(item),
                item.getAlienName(),
                item.getAlienPhonenumber(),
                item.getAlienEpost(),
                item.getRegistrationDate().toString(),
                item.getAlienLocation().getName(),
                item.getResponsibleAgent().getName()
            };
            tableModel.addRow(row);
        }   }

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
        yearPickerComboBox = new javax.swing.JComboBox<>();
        filterLabel = new javax.swing.JLabel();
        resultScrollPane = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        clearFilterButton = new javax.swing.JButton();
        removeAlienButton = new javax.swing.JButton();
        addAlienButton = new javax.swing.JButton();
        monthPickerComboBox = new javax.swing.JComboBox<>();
        editAlienButton = new javax.swing.JButton();

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
        areaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaComboBoxActionPerformed(evt);
            }
        });

        raceComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        raceComboBox.setForeground(new java.awt.Color(51, 51, 51));
        raceComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ras", "Worm", "Squid", "Boglodite" }));
        raceComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        raceComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        yearPickerComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yearPickerComboBox.setForeground(new java.awt.Color(51, 51, 51));
        yearPickerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "År" }));
        yearPickerComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        yearPickerComboBox.setOpaque(true);
        yearPickerComboBox.setPreferredSize(new java.awt.Dimension(180, 45));

        filterLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        filterLabel.setForeground(new java.awt.Color(51, 51, 51));
        filterLabel.setText("Filtrera efter:");

        resultScrollPane.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 63, 63), 3));

        resultTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 63, 63), 2));
        resultTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, "Vilson", "0760191235", "vilson@.se", "2023-12-23", "2", "4"}
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

        monthPickerComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        monthPickerComboBox.setForeground(new java.awt.Color(51, 51, 51));
        monthPickerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Månad", "Januari", "Februari", "Mars", "April", "Maj", "Juni", "Juli", "Augusti", "September", "Oktober", "November", "December" }));
        monthPickerComboBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));

        editAlienButton.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editAlienButton.setText("Redigera Alien");
        editAlienButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
        editAlienButton.setEnabled(false);
        editAlienButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAlienButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(headerLabel)
                .addGap(430, 430, 430))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterLabel)
                    .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(clearFilterButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(areaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(raceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yearPickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(monthPickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(removeAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(editAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(headerLabel)
                .addGap(33, 33, 33)
                .addComponent(filterLabel)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raceComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearPickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchbarTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthPickerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearFilterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editAlienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addAlienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAlienButtonActionPerformed
        // TODO add your handling code here:
        PopupHandler.addNewAlienPopup(Parent);
    }//GEN-LAST:event_addAlienButtonActionPerformed
    
    public void reload(){
        loadTable();
    }
    //Metod för att hämta eftersökt data
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        tableModel.setRowCount(0);
    
    String selectedYear = (String) yearPickerComboBox.getSelectedItem();
    String selectedRace = (String) raceComboBox.getSelectedItem();
    String selectedLocation = (String) areaComboBox.getSelectedItem();
    String searchText = searchbarTextfield.getText().toLowerCase();
    int selectedMonthIndex = monthPickerComboBox.getSelectedIndex();

    for (Alien item : ObjectManager.Aliens.alienList.values()) {
        String alienYear = Integer.toString(item.getRegistrationDate().getYear());
        int alienMonth = item.getRegistrationDate().getMonthValue();
        String alienRace = item.getClass().getSimpleName();
        String alienLocation = item.getAlienLocation().getName();
        String alienName = item.getAlienName().toLowerCase();

        boolean yearMatches = yearPickerComboBox.getSelectedIndex() == 0 || alienYear.equals(selectedYear);
        boolean monthMatches = selectedMonthIndex == 0 || alienMonth == selectedMonthIndex;
        boolean raceMatches = raceComboBox.getSelectedIndex() == 0 || alienRace.equals(selectedRace);
        boolean locationMatches = areaComboBox.getSelectedIndex() == 0 || alienLocation.equals(selectedLocation);
        boolean nameMatches = alienName.contains(searchText);

        if (nameMatches && yearMatches && monthMatches && raceMatches && locationMatches) {
            String[] row = {
                Integer.toString(item.getID()),
                alienRace,
                getSubValue(item),
                item.getAlienName(),
                item.getAlienPhonenumber(),
                item.getAlienEpost(),
                item.getRegistrationDate().toString(),
                alienLocation,
                item.getResponsibleAgent().getName()
            };

            tableModel.addRow(row);
        }
    }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void removeAlienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAlienButtonActionPerformed
        // TODO add your handling code here:'
        ArrayList<Integer> selectedID = new ArrayList<Integer>();
        for(int item: resultTable.getSelectedRows()){
            selectedID.add(Integer.parseInt((String) resultTable.getValueAt(item, 0)));
        }
        int selectedAlienCount = selectedID.size(); // Replace with your method
    String message = "Delete " + selectedAlienCount + " alien" + (selectedAlienCount > 1 ? "s" : "") + " from the system?";
    
    int response = JOptionPane.showConfirmDialog(null, message, "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
        // Logic to delete the selected aliens
        for(int id : selectedID){
        System.out.println("DELETE from alien where Alien_ID = "+id);}
    }
    }//GEN-LAST:event_removeAlienButtonActionPerformed

    private void editAlienButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAlienButtonActionPerformed
        // TODO add your handling code here:
        if(resultTable.getSelectedRows().length==1){
            PopupHandler.editAlienPopup(Parent,this,ObjectManager.Aliens.getAlien(Integer.parseInt((String) resultTable.getValueAt(resultTable.getSelectedRow(), 0))));
        }
        else {JOptionPane.showMessageDialog(this,"Endast en Alien kan redigeras samtidigt!");}
    }//GEN-LAST:event_editAlienButtonActionPerformed

    private void areaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaComboBoxActionPerformed

    
    
    
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
        }); }
    /*
    private Alien getAlienByID(int id) {
    // Your logic to retrieve the Location object based on the id
    // This might involve searching through ObjectManager.Locations.locationList
        for (Alien i : ObjectManager.Aliens.alienList) {
            if (i.getAlienID() == id) {
                return i;
            }
        }
        return null;
    }
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAlienButton;
    private javax.swing.JComboBox<String> areaComboBox;
    private javax.swing.JButton clearFilterButton;
    private javax.swing.JButton editAlienButton;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JComboBox<String> monthPickerComboBox;
    private javax.swing.JComboBox<String> raceComboBox;
    private javax.swing.JButton removeAlienButton;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTable resultTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchbarTextfield;
    private javax.swing.JComboBox<String> yearPickerComboBox;
    // End of variables declaration//GEN-END:variables
}
