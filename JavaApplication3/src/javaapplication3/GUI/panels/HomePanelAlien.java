/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.models.Agent;
import javaapplication3.models.Alien;
import javaapplication3.models.Area;
import javaapplication3.models.Location;
import javaapplication3.models.alienSubclasses.Boglodite;
import javaapplication3.models.alienSubclasses.Squid;
import javaapplication3.models.alienSubclasses.Worm;
import javaapplication3.utils.DatabaseConnection;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.UserSession;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author mopaj
 */
public class HomePanelAlien extends javax.swing.JPanel {
    private static InfDB db;
    private UserSession user = UserSession.getInstance();
    private Alien alien;
    private Agent agent;
    private Area area;
    public static DefaultTableModel tableModel;


    /**
     * Creates new form AgentPanel
     */
    public HomePanelAlien() throws InfException {
        this.db = DatabaseConnection.getInstance();
        initComponents();
        areaLabel1.setHorizontalAlignment(JLabel.CENTER);
        mailBoss.setVisible(false);
        tableModel = (DefaultTableModel) resultTable.getModel();
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                ObjectManager.Aliens.loadAlienList();
                return null;
            }

            @Override
            protected void done() {
                try {
                    telLArea();
                    fillTable();
                } catch (NumberFormatException ex) {
                    Logger.getLogger(HomePanelAlien.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InfException ex) {
                    Logger.getLogger(HomePanelAlien.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        worker.execute();
        header.setText("Välkommen, "+UserSession.getInstance().getName());
    }
    
    private void fillTable(){
        for(Alien item : ObjectManager.Aliens.alienList.values()){
            if(item.getLocation().getArea()==area){
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
        }
        resultTable.setModel(tableModel);
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
    private void telLArea() throws NumberFormatException, InfException{
    int id = user.getUserId();
    alien = ObjectManager.Aliens.alienList.get(id);
    Location location = alien.getLocation();
    area = location.getArea();
    agent = ObjectManager.Agents.findOmradeschefForArea(area.getId());
    String message = "Området saknar chef";
    
    if(agent != null){
        message = "Områdeschef: "+agent.getName();
        mailBoss.setVisible(true);
    }
    
    
    areaLabel1.setText("Du tillhör "+location.getName()+" en del av "+area.getName());
    areaLabel2.setText(message);
    
    
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
        header = new javax.swing.JLabel();
        areaLabel1 = new javax.swing.JLabel();
        areaLabel2 = new javax.swing.JLabel();
        mailBoss = new javax.swing.JButton();
        resultScrollPane = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(200, 200, 200));
        setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        header.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        header.setForeground(new java.awt.Color(30, 30, 30));
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("Välkommen");

        areaLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        areaLabel1.setForeground(new java.awt.Color(0, 0, 0));
        areaLabel1.setText(" ");
        areaLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        areaLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        areaLabel2.setForeground(new java.awt.Color(0, 0, 0));
        areaLabel2.setText(" ");
        areaLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mailBoss.setText("Maila chef");
        mailBoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailBossActionPerformed(evt);
            }
        });

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
        resultTable.setRowSelectionAllowed(false);
        resultTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        resultTable.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        resultTable.setShowGrid(false);
        resultTable.getTableHeader().setResizingAllowed(false);
        resultTable.getTableHeader().setReorderingAllowed(false);
        resultScrollPane.setViewportView(resultTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Alien i mitt område:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(areaLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mailBoss))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(areaLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(header)
                .addGap(24, 24, 24)
                .addComponent(areaLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(areaLabel2)
                    .addComponent(mailBoss))
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(resultScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mailBossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailBossActionPerformed
   
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported");
            return;
        }

        Desktop desktop = Desktop.getDesktop();
        if (!desktop.isSupported(Desktop.Action.MAIL)) {
            System.out.println("MAIL action is not supported");
            return;
        }

        try {
            // You can modify this URI to add recipients, subject, body, etc.
            String email = agent.getEmail();
            String name = agent.getName();
            String subject = "Till " + name;
            String encodedSubject = URLEncoder.encode(subject, StandardCharsets.UTF_8.toString());
            
            encodedSubject = encodedSubject.replace("+", "%20");

            URI mailto = new URI("mailto:" + email + "?subject=" + encodedSubject);
            
            desktop.mail(mailto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }//GEN-LAST:event_mailBossActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaLabel1;
    private javax.swing.JLabel areaLabel2;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton mailBoss;
    private javax.swing.JScrollPane resultScrollPane;
    private javax.swing.JTable resultTable;
    // End of variables declaration//GEN-END:variables
}
