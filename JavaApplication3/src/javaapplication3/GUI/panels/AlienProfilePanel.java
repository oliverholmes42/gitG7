/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package javaapplication3.GUI.panels;

import javaapplication3.GUI.MainPage;
import javaapplication3.models.Alien;
import oru.inf.InfDB;
import javaapplication3.utils.ObjectManager;
import javaapplication3.utils.PopupHandler;
import javaapplication3.utils.UserSession;
import oru.inf.InfException;


/**
 *
 * @Albin
 */
public class AlienProfilePanel extends javax.swing.JPanel {
    
    public static InfDB db; 
    private MainPage Parent;
    private Alien profile;
    
    /**
     * Creates new form AgentPanel
     */
    public AlienProfilePanel() throws NumberFormatException, InfException {
    initComponents();
    ObjectManager.Aliens.loadAlienList();
    profile = ObjectManager.Aliens.alienList.get(UserSession.getInstance().getUserId());
    fillPage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namnPanel = new javax.swing.JPanel();
        namnText = new javax.swing.JLabel();
        namnData = new javax.swing.JLabel();
        telefonPanel = new javax.swing.JPanel();
        telefonText = new javax.swing.JLabel();
        telefonData = new javax.swing.JLabel();
        epostPanel = new javax.swing.JPanel();
        epostText = new javax.swing.JLabel();
        epostData = new javax.swing.JLabel();
        anstallningsdatumPanel = new javax.swing.JPanel();
        anstallningsdatumText = new javax.swing.JLabel();
        anstallningsDatumData = new javax.swing.JLabel();
        losenordPanel = new javax.swing.JPanel();
        losenordText = new javax.swing.JLabel();
        losenordData = new javax.swing.JLabel();
        NyttLösenButton1 = new javax.swing.JButton();
        profilTitel = new javax.swing.JLabel();
        profilBild = new javax.swing.JLabel();

        setBackground(new java.awt.Color(200, 200, 200));
        setMaximumSize(new java.awt.Dimension(1128, 792));
        setMinimumSize(new java.awt.Dimension(1128, 792));
        setPreferredSize(new java.awt.Dimension(1128, 792));

        namnPanel.setMaximumSize(new java.awt.Dimension(557, 40));
        namnPanel.setMinimumSize(new java.awt.Dimension(557, 40));
        namnPanel.setPreferredSize(new java.awt.Dimension(557, 40));

        namnText.setText("NAMN:");
        namnText.setFocusable(false);
        namnText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        namnData.setText("Fornamn Efternamn");

        javax.swing.GroupLayout namnPanelLayout = new javax.swing.GroupLayout(namnPanel);
        namnPanel.setLayout(namnPanelLayout);
        namnPanelLayout.setHorizontalGroup(
            namnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(namnText, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(namnData, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(235, 235, 235))
        );
        namnPanelLayout.setVerticalGroup(
            namnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(namnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(namnText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(namnData, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        telefonPanel.setMaximumSize(new java.awt.Dimension(557, 40));
        telefonPanel.setMinimumSize(new java.awt.Dimension(557, 40));
        telefonPanel.setPreferredSize(new java.awt.Dimension(557, 40));

        telefonText.setText("TELEFON:");
        telefonText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        telefonText.setPreferredSize(new java.awt.Dimension(40, 16));

        telefonData.setText("07000000000");

        javax.swing.GroupLayout telefonPanelLayout = new javax.swing.GroupLayout(telefonPanel);
        telefonPanel.setLayout(telefonPanelLayout);
        telefonPanelLayout.setHorizontalGroup(
            telefonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telefonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(telefonText, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefonData, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        telefonPanelLayout.setVerticalGroup(
            telefonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(telefonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(telefonText, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(telefonData))
        );

        epostPanel.setMaximumSize(new java.awt.Dimension(557, 40));
        epostPanel.setMinimumSize(new java.awt.Dimension(557, 40));
        epostPanel.setPreferredSize(new java.awt.Dimension(557, 40));

        epostText.setText("EPOST:");
        epostText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        epostText.setPreferredSize(new java.awt.Dimension(40, 16));

        epostData.setText("mail@exempel.com");

        javax.swing.GroupLayout epostPanelLayout = new javax.swing.GroupLayout(epostPanel);
        epostPanel.setLayout(epostPanelLayout);
        epostPanelLayout.setHorizontalGroup(
            epostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(epostPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(epostText, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(epostData, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        epostPanelLayout.setVerticalGroup(
            epostPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(epostText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addComponent(epostData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        anstallningsdatumPanel.setMaximumSize(new java.awt.Dimension(557, 40));
        anstallningsdatumPanel.setMinimumSize(new java.awt.Dimension(557, 40));
        anstallningsdatumPanel.setPreferredSize(new java.awt.Dimension(557, 40));

        anstallningsdatumText.setText("Registreringsdatum:");
        anstallningsdatumText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        anstallningsdatumText.setPreferredSize(new java.awt.Dimension(40, 16));

        anstallningsDatumData.setText("2023-10-24");

        javax.swing.GroupLayout anstallningsdatumPanelLayout = new javax.swing.GroupLayout(anstallningsdatumPanel);
        anstallningsdatumPanel.setLayout(anstallningsdatumPanelLayout);
        anstallningsdatumPanelLayout.setHorizontalGroup(
            anstallningsdatumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anstallningsdatumPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(anstallningsdatumText, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anstallningsDatumData, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        anstallningsdatumPanelLayout.setVerticalGroup(
            anstallningsdatumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(anstallningsdatumPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(anstallningsdatumText, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(anstallningsDatumData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        losenordPanel.setMaximumSize(new java.awt.Dimension(557, 40));
        losenordPanel.setMinimumSize(new java.awt.Dimension(557, 40));
        losenordPanel.setPreferredSize(new java.awt.Dimension(557, 40));

        losenordText.setText("LÖSENORD:");
        losenordText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        losenordText.setPreferredSize(new java.awt.Dimension(40, 16));

        losenordData.setText("*****");

        javax.swing.GroupLayout losenordPanelLayout = new javax.swing.GroupLayout(losenordPanel);
        losenordPanel.setLayout(losenordPanelLayout);
        losenordPanelLayout.setHorizontalGroup(
            losenordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(losenordPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(losenordText, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(losenordData, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        losenordPanelLayout.setVerticalGroup(
            losenordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(losenordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(losenordText, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addComponent(losenordData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        NyttLösenButton1.setText("NYTT LÖSENORD");
        NyttLösenButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NyttLösenButton1ActionPerformed(evt);
            }
        });

        profilTitel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        profilTitel.setText("DIN PROFIL");

        profilBild.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/output-onlinepngtools.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(NyttLösenButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(losenordPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(anstallningsdatumPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(telefonPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(epostPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namnPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(profilBild))
                    .addComponent(profilTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(189, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(profilBild))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(profilTitel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(namnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(epostPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(telefonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(anstallningsdatumPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(losenordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(NyttLösenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(347, Short.MAX_VALUE))
        );

        namnPanel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void NyttLösenButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NyttLösenButton1ActionPerformed
        // TODO add your handling code here:
        PopupHandler.addNewPasswordPopup(Parent,profile);
    }//GEN-LAST:event_NyttLösenButton1ActionPerformed

    private void fillPage() {
        // TODO add your handling code here:
        
        namnData.setText(profile.getName());
        epostData.setText(profile.getEmail());
        telefonData.setText(profile.getTelephone());
        anstallningsDatumData.setText(profile.getRegistrationDate().toString());
        losenordData.setText(writePassword());
    }

    private String writePassword(){
    
        return "*".repeat(profile.getPassword().length());
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NyttLösenButton1;
    private javax.swing.JLabel anstallningsDatumData;
    private javax.swing.JPanel anstallningsdatumPanel;
    private javax.swing.JLabel anstallningsdatumText;
    private javax.swing.JLabel epostData;
    private javax.swing.JPanel epostPanel;
    private javax.swing.JLabel epostText;
    private javax.swing.JLabel losenordData;
    private javax.swing.JPanel losenordPanel;
    private javax.swing.JLabel losenordText;
    private javax.swing.JLabel namnData;
    private javax.swing.JPanel namnPanel;
    private javax.swing.JLabel namnText;
    private javax.swing.JLabel profilBild;
    private javax.swing.JLabel profilTitel;
    private javax.swing.JLabel telefonData;
    private javax.swing.JPanel telefonPanel;
    private javax.swing.JLabel telefonText;
    // End of variables declaration//GEN-END:variables
}
