/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javaapplication3.models.Agent;
import javaapplication3.models.Utilities;
import javaapplication3.models.utilitySubClasses.Kommunikation;
import javaapplication3.models.utilitySubClasses.Teknik;
import javaapplication3.models.utilitySubClasses.Vapen;
import javaapplication3.utils.ObjectManager;
import static javaapplication3.utils.ObjectManager.Agents.findTopThreeAgentsWithMostAliens;
import javaapplication3.utils.UserSession;
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
     */
    public HomePanel() throws InfException {
        initComponents();
        jLabel2.setText("Välkommen, "+UserSession.getInstance().getName());
        ObjectManager.AgentUtilityHandler.loadList();
        
        fillTable();
        displayTopThreeAgents();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        utilityTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
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
        ));
        utilityTable.setGridColor(new java.awt.Color(30, 30, 30));
        utilityTable.setInheritsPopupMenu(true);
        utilityTable.setRowHeight(60);
        utilityTable.setRowMargin(1);
        jScrollPane2.setViewportView(utilityTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 50, 50));
        jLabel1.setText("Din Utrustning:");
        jLabel1.setAutoscrolls(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Välkommen");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 50, 50));
        jLabel3.setText("Top 3 agenter med flest aliens:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 50, 50));
        jLabel4.setText("Aliens du är ansvarig för:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Alien Namn", "TelefonNummer", "ID"
            }
        ));
        jTable1.setRowHeight(60);
        jTable1.setRowMargin(5);
        jScrollPane1.setViewportView(jTable1);

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

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        topThree.setRowHeight(60);
        topThree.setRowMargin(5);
        jScrollPane3.setViewportView(topThree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(96, 96, 96))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(482, 482, 482)
                        .addComponent(jLabel1)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable topThree;
    private javax.swing.JTable utilityTable;
    // End of variables declaration//GEN-END:variables
}
