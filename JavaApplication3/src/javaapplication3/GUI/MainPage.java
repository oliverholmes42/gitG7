 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication3.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javaapplication3.GUI.panels.*;
import javaapplication3.GUI.panels.AgentPanel;
import javaapplication3.GUI.panels.AreaPanel;
import javaapplication3.GUI.panels.EquipmentPanel;
import javaapplication3.GUI.panels.HomePanel;
import javaapplication3.GUI.panels.ProfilePanel;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.Panel404;
import javaapplication3.utils.UserSession;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import oru.inf.InfException;




/**
 *
 * @author mopaj
 */
public class MainPage extends javax.swing.JFrame {
    private CardLayout cardLayout = new CardLayout();

    /**
     * Creates new form MainPage
     */
    public MainPage() throws InfException {
        initComponents();
        loadIcon();
        addListenersToMenu();
        addNavigationToMenu();
        createCardLayout();
        if(UserSession.getInstance().getType()==1){}
        cardLayout.show(mainPanelDisplay, "HomePanel");
        creatLogOut();
        
        if(UserSession.getInstance().getType()==1) {
            locationButton.setVisible(false);
            agentButton.setVisible(false);
            equipmentButton.setVisible(false);
        }
    }

    private void creatLogOut() {
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserSession.getInstance().stopSession(); // Stop the user session
                MainPage.this.dispose();// Dispose the current frame
                new LoginPage().setVisible(true); 
            }
        }); }

    private void addNavigationToMenu() {
        addNavigationToButton(homeButton, "HomePanel");
        addNavigationToButton(alienButton, "AlienPanel");
        addNavigationToButton(agentButton, "AgentPanel");
        addNavigationToButton(profileButton, "ProfilePanel");
        addNavigationToButton(equipmentButton, "EquipmentPanel");
        addNavigationToButton(areaButton, "AreaPanel");
        addNavigationToButton(locationButton, "LocationPanel");
    }

    private void createCardLayout() throws InfException {
        mainPanelDisplay.setLayout(cardLayout);
        if(UserSession.getInstance().getType()==1){mainPanelDisplay.add(new HomePanelAlien(), "HomePanel");}
        else{mainPanelDisplay.add(new HomePanel(), "HomePanel");}
    }

    private void addListenersToMenu() {
        addMouseListenersToLabel(homeButton);
        addMouseListenersToLabel(alienButton);
        addMouseListenersToLabel(agentButton);
        addMouseListenersToLabel(profileButton);
        addMouseListenersToLabel(equipmentButton);
        addMouseListenersToLabel(areaButton);
        addMouseListenersToLabel(logOutButton);
        addMouseListenersToLabel(locationButton);
    }
    
    private void addMouseListenersToLabel(JLabel label) {
    label.addMouseListener(new java.awt.event.MouseAdapter() {

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            label.setOpaque(true);
            label.setBackground(new Color(100, 100, 100));
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            labelMouseExited(evt, label);
        }
    });
}
    private void loadIcon() {
        try {
            Image icon = ImageIO.read(getClass().getResource("/resources/Icon.png"));
            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void switchToPanel(String panelName) throws NumberFormatException, InfException {
    Component[] components = mainPanelDisplay.getComponents();
    for (Component comp : components) {
        if (panelName.equals(comp.getName())) {
            mainPanelDisplay.remove(comp);
            break;
        }
    }

    // Create a new instance of the panel
    JPanel newPanel = createPanel(panelName);
    mainPanelDisplay.add(newPanel, panelName);

    // Show the new panel
    cardLayout.show(mainPanelDisplay, panelName);
}

    private JPanel createPanel(String panelName) throws NumberFormatException, InfException {
    switch (panelName) {
        case "HomePanel":
             if(UserSession.getInstance().getType()==1){return new HomePanelAlien();}
            else{return new HomePanel();}
        case "ProfilePanel":
            if(UserSession.getInstance().getType()==1){return new AlienProfilePanel();}
            else{return new ProfilePanel();}
        case "EquipmentPanel":
            return new EquipmentPanel(this);
        case "AreaPanel":
            return new AreaPanel();
         case "AgentPanel":
            return new AgentPanel(this);
        case "AlienPanel":
            return new AlienPanel(this);
        case "LocationPanel":
            return new LocationPanel(this);
        default:
            return new Panel404(); // Default empty panel
    }
}

    
    private void addNavigationToButton(JLabel label, String panelName) {
    label.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            ObjectManager.offloadAll();
            try {
                switchToPanel(panelName);
            } catch (NumberFormatException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InfException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
}

private void labelMouseExited(java.awt.event.MouseEvent evt, JLabel label) {
    // Action for mouse exit
    // Example: Revert background color
    label.setOpaque(false);
    label.setBackground(null);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JLabel();
        alienButton = new javax.swing.JLabel();
        agentButton = new javax.swing.JLabel();
        profileButton = new javax.swing.JLabel();
        equipmentButton = new javax.swing.JLabel();
        logOutButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        areaButton = new javax.swing.JLabel();
        locationButton = new javax.swing.JLabel();
        mainPanelDisplay = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(200, 200, 200));
        setResizable(false);

        menuPanel.setBackground(new java.awt.Color(51, 51, 51));
        menuPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuPanel.setForeground(new java.awt.Color(25, 22, 22));

        homeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        homeButton.setForeground(new java.awt.Color(200, 200, 200));
        homeButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homeButton.setText("HEM");
        homeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        alienButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        alienButton.setForeground(new java.awt.Color(200, 200, 200));
        alienButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        alienButton.setText("ALIEN");
        alienButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        agentButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        agentButton.setForeground(new java.awt.Color(200, 200, 200));
        agentButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        agentButton.setText("AGENT");
        agentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        profileButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        profileButton.setForeground(new java.awt.Color(200, 200, 200));
        profileButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileButton.setText("PROFILE");
        profileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        equipmentButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        equipmentButton.setForeground(new java.awt.Color(200, 200, 200));
        equipmentButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equipmentButton.setText("UTRUSTNING");
        equipmentButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        logOutButton.setForeground(new java.awt.Color(200, 200, 200));
        logOutButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logOutButton.setText("Log Out");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/MiB_IconCut.png"))); // NOI18N

        areaButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        areaButton.setForeground(new java.awt.Color(200, 200, 200));
        areaButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        areaButton.setText("OMRÅDE");
        areaButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        locationButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        locationButton.setForeground(new java.awt.Color(200, 200, 200));
        locationButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        locationButton.setText("PLATS");
        locationButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mainPanelDisplay.setBackground(new java.awt.Color(200, 200, 200));

        javax.swing.GroupLayout mainPanelDisplayLayout = new javax.swing.GroupLayout(mainPanelDisplay);
        mainPanelDisplay.setLayout(mainPanelDisplayLayout);
        mainPanelDisplayLayout.setHorizontalGroup(
            mainPanelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1134, Short.MAX_VALUE)
        );
        mainPanelDisplayLayout.setVerticalGroup(
            mainPanelDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 792, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 29, Short.MAX_VALUE))
                            .addComponent(locationButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(equipmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alienButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(areaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(logOutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alienButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(equipmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addGap(47, 47, 47))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(mainPanelDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainPage().setVisible(true);
                } catch (InfException ex) {
                    Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel agentButton;
    private javax.swing.JLabel alienButton;
    private javax.swing.JLabel areaButton;
    private javax.swing.JLabel equipmentButton;
    private javax.swing.JLabel homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel locationButton;
    private javax.swing.JLabel logOutButton;
    private javax.swing.JPanel mainPanelDisplay;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel profileButton;
    // End of variables declaration//GEN-END:variables
}
