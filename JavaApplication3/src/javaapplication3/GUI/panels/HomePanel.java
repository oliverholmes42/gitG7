/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javaapplication3.models.Agent;
import javaapplication3.models.Alien;
import javaapplication3.models.Utilities;
import javaapplication3.models.utilitySubClasses.Kommunikation;
import javaapplication3.models.utilitySubClasses.Teknik;
import javaapplication3.models.utilitySubClasses.Vapen;
import javaapplication3.utils.ObjectManager;
import static javaapplication3.utils.ObjectManager.Agents.findTopThreeAgentsWithMostAliens;
import javaapplication3.utils.UserSession;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfException;

/**
 *
 * @author mopaj
 */
public class HomePanel extends javax.swing.JPanel {
    private UserSession user = UserSession.getInstance();


    /**
     * Creates new form AgentPanel
     * @throws oru.inf.InfException
     */
    public HomePanel() throws InfException {
    initComponents();
        mainHeader.setText("Välkommen, " + UserSession.getInstance().getName());

        // Using SwingWorker to load data in the background
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Perform long-running data loading tasks here
                ObjectManager.AgentUtilityHandler.loadList();
                ObjectManager.Aliens.loadAlienList();
                return null;
            }

            @Override
            protected void done() {
                // This method is invoked on the EDT
                // Update your tables with the new data here
                fillTable();
                fillAlienTable();
                try {
                    displayTopThreeAgents();
                } catch (InfException e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }

    
    private void fillTable(){
        DefaultTableModel tableModel = (DefaultTableModel) utilityTable.getModel();
        if (user.getType() != 1) {
            Agent agent = ObjectManager.Agents.agentList.get(user.getUserId());
            HashMap<Integer, Utilities> map = ObjectManager.AgentUtilityHandler.getAgentUtils(agent);
            tableModel.setRowCount(0);
            for (Utilities item : map.values()) {

                HashMap<String, String> itemMap = ObjectManager.AgentUtilityHandler.getUtilityInfo(item);
                String[] row = {
                    Integer.toString(item.getID()),
                    item.getName(),
                    item.getClass().getSimpleName(),
                    getSubValue(item),
                    itemMap.get("Date")
                };
                tableModel.addRow(row);
            }
        }
    }
    
    private void fillAlienTable(){
        DefaultTableModel tableModel = (DefaultTableModel) alienHomeTable.getModel();
            Agent agent = ObjectManager.Agents.agentList.get(user.getUserId());
            tableModel.setRowCount(0);
            for(Alien alien: ObjectManager.Aliens.alienList.values()){
                if(alien.getResponsibleAgent()==agent){
                    String[] row = {
                        ""+alien.getID(),
                        alien.getName(),
                        alien.getTelephone()
                    };
                    tableModel.addRow(row);
                }
            }
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

    private void displayTopThreeAgents() throws InfException {
        DefaultTableModel tableModel = (DefaultTableModel) topThree.getModel();
        tableModel.setRowCount(0);
        List<Map.Entry<Agent, Integer>> topAgents = findTopThreeAgentsWithMostAliens();
        int i=1;
        for (Map.Entry<Agent, Integer> entry : topAgents) {
            String[] row = {
            Integer.toString(i),
            Integer.toString(entry.getKey().getId()),
            entry.getKey().getName(),
            Integer.toString(entry.getValue())
        };
            tableModel.addRow(row);
            i++;
    }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        utilityTableContainer = new javax.swing.JScrollPane();
        utilityTable = new javax.swing.JTable();
        utilityHeader = new javax.swing.JLabel();
        mainHeader = new javax.swing.JLabel();
        top3Header = new javax.swing.JLabel();
        yourAliensHeader = new javax.swing.JLabel();
        alienUtilityContainer = new javax.swing.JScrollPane();
        alienHomeTable = new javax.swing.JTable();
        top3TableContainer = new javax.swing.JScrollPane();
        topThree = new javax.swing.JTable();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(200, 200, 200));
        setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        utilityTable.setBackground(new java.awt.Color(210, 210, 210));
        utilityTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        utilityTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        utilityTable.setForeground(new java.awt.Color(30, 30, 30));
        utilityTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Benämning", "Typ", "Unikt värde", "Lånedatum"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        utilityTable.setGridColor(new java.awt.Color(30, 30, 30));
        utilityTable.setInheritsPopupMenu(true);
        utilityTable.setRowHeight(60);
        utilityTable.setRowMargin(1);
        utilityTableContainer.setViewportView(utilityTable);

        utilityHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        utilityHeader.setForeground(new java.awt.Color(50, 50, 50));
        utilityHeader.setText("Din Utrustning:");
        utilityHeader.setAutoscrolls(true);

        mainHeader.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        mainHeader.setForeground(new java.awt.Color(30, 30, 30));
        mainHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainHeader.setText("Välkommen");

        top3Header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        top3Header.setForeground(new java.awt.Color(50, 50, 50));
        top3Header.setText("Top 3 agenter med flest aliens:");

        yourAliensHeader.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        yourAliensHeader.setForeground(new java.awt.Color(50, 50, 50));
        yourAliensHeader.setText("Aliens du är ansvarig för:");

        alienHomeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Alien Namn", "TelefonNummer"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alienHomeTable.setRowHeight(60);
        alienHomeTable.setRowMargin(5);
        alienUtilityContainer.setViewportView(alienHomeTable);

        topThree.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Rank", "ID", "Agent Namn", "Antal Alien "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        topThree.setRowHeight(60);
        topThree.setRowMargin(5);
        top3TableContainer.setViewportView(topThree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(utilityTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(top3TableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(top3Header)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(yourAliensHeader)
                                        .addGap(96, 96, 96))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(alienUtilityContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(mainHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(482, 482, 482)
                        .addComponent(utilityHeader)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(mainHeader)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(top3Header)
                    .addComponent(yourAliensHeader))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alienUtilityContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(top3TableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(utilityHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(utilityTableContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable alienHomeTable;
    private javax.swing.JScrollPane alienUtilityContainer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel mainHeader;
    private javax.swing.JLabel top3Header;
    private javax.swing.JScrollPane top3TableContainer;
    private javax.swing.JTable topThree;
    private javax.swing.JLabel utilityHeader;
    private javax.swing.JTable utilityTable;
    private javax.swing.JScrollPane utilityTableContainer;
    private javax.swing.JLabel yourAliensHeader;
    // End of variables declaration//GEN-END:variables
}
