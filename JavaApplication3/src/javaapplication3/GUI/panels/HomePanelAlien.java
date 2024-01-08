/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javaapplication3.models.Agent;
import javaapplication3.models.Alien;
import javaapplication3.models.Area;
import javaapplication3.models.Location;
import javaapplication3.utils.DatabaseConnection;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.UserSession;
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


    /**
     * Creates new form AgentPanel
     */
    public HomePanelAlien() throws InfException {
        this.db = DatabaseConnection.getInstance();
        initComponents();
        ObjectManager.Aliens.loadAlienList();
        ObjectManager.Agents.LoadList();
        jLabel2.setText("Välkommen, "+UserSession.getInstance().getName());
        telLArea();
    }
    
    private void telLArea() throws NumberFormatException, InfException{
    int id = user.getUserId();
    alien = ObjectManager.Aliens.alienList.get(id);
    Location location = alien.getLocation();
    Area area = location.getArea();
    agent = ObjectManager.Agents.findOmradeschefForArea(area.getId());
    String message = "Området saknar chef";
    
    if(agent != null){
        message = "Områdeschef: "+agent.getName();
    }else{
        jButton1.setVisible(false);
    }
    
    
    areaLabel.setText("Du tillhör "+location.getName()+" en del av "+area.getName());
    areaLabel1.setText(message);
    
    
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        areaLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(200, 200, 200));
        setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Välkommen");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Du tillhör område:");

        areaLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        areaLabel.setForeground(new java.awt.Color(0, 0, 0));
        areaLabel.setText("jLabel3");
        areaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        areaLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        areaLabel1.setForeground(new java.awt.Color(0, 0, 0));
        areaLabel1.setText("jLabel3");
        areaLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Maila chef");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(areaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 814, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(148, 148, 148))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton1)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(areaLabel)
                .addGap(18, 18, 18)
                .addComponent(areaLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(420, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
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
    
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel areaLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
