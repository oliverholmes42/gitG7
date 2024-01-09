/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication3.GUI;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.utils.UserSession;
import javaapplication3.utils.loginInputValidation;
import javax.imageio.ImageIO;
import oru.inf.InfException;


/**
 * Detta är filen av klassen JFrame som hanterar loginfönstret som först spelas upp i programmet.
 * I och med att denna klass till största del formades i IDE:ns inbyggda designlayout har majoriteten av koden 
 * automatiskt genererats. För att sedan koppla andra klasser med denna behövdes skräddarsydd kod.
 * @author vilson, aiham, oliver, albin
 */
public class LoginPage extends javax.swing.JFrame {
    

    /**
     * Autogenererad kod.
     */
    public LoginPage() {
        initComponents();
        loadIcon();
        
        addTabThing();
    }

    private void addTabThing() {
        epostTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_TAB) {
                    passwordPasswordField.requestFocus();
                    evt.consume();
                }
            }
        });
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        loginLogoLabel = new javax.swing.JLabel();
        epostLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        epostTextField = new javax.swing.JTextField();
        passwordPasswordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setFocusable(false);
        setForeground(new java.awt.Color(204, 204, 204));
        setIconImages(null);
        setResizable(false);

        loginPanel.setBackground(new java.awt.Color(0, 0, 0));
        loginPanel.setForeground(new java.awt.Color(0, 0, 0));

        loginLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(204, 204, 204));
        loginLabel.setText("LOGIN");
        loginLabel.setToolTipText("");

        loginLogoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/MiB_Icon.png"))); // NOI18N
        loginLogoLabel.setText("jLabel1");

        epostLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        epostLabel.setForeground(new java.awt.Color(204, 204, 204));
        epostLabel.setText("ePost:");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(204, 204, 204));
        passwordLabel.setText("Lösenord:");

        epostTextField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        epostTextField.setFocusCycleRoot(true);

        passwordPasswordField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordPasswordField.setFocusCycleRoot(true);

        loginButton.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        loginButton.setText("LOGGA IN");
        loginButton.setFocusCycleRoot(true);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(loginLogoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginLabel)
                    .addComponent(passwordLabel)
                    .addComponent(epostLabel)
                    .addComponent(epostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addComponent(loginLabel)
                        .addGap(28, 28, 28)
                        .addComponent(epostLabel)
                        .addGap(18, 18, 18)
                        .addComponent(epostTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(passwordLabel)
                        .addGap(18, 18, 18)
                        .addComponent(passwordPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(loginLogoLabel))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void loadIcon() {
        try {
            Image icon = ImageIO.read(getClass().getResource("/resources/Icon.png"));
            setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        //Denna ActionEvent hanterar logiken för knapptrycket av "Logga in"-knappen.
        if (loginInputValidation.isEmailInputEmpty(epostTextField) && loginInputValidation.emailValidation(epostTextField)) {
            System.out.println("Emailinput korrekt"); //Om detta villkor stämmer gå till nästa villkor->

            if (loginInputValidation.isPasswordInputEmpty(passwordPasswordField)) {
                System.out.println("Lösenordsinput korrekt");//Om detta villkor stämmer gå till nästa villkor->

                 Map<String, Object> loginResult = loginInputValidation.isEmailAndPasswordCorrect(epostTextField, passwordPasswordField);
                 boolean isValidated = (Boolean) loginResult.get("isValidated");

                if (isValidated) {
                    int userId = (Integer) loginResult.get("userId");
                    int type = (Integer) loginResult.get("type");
                    String name = (String) loginResult.get("name");
                    System.out.println("User ID: " + userId);
                    UserSession.getInstance().setUserId(userId);
                    UserSession.getInstance().setType(type);
                    UserSession.getInstance().setName(name);
                    
                    System.out.println("Inloggning lyckades");
                    this.dispose(); // Close login window
                    try {
                        new MainPage().setVisible(true);
                    } catch (InfException ex) {
                        Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Inloggning misslyckades");
                }
            } else {
                System.out.println("Lösenordsinput tom");
            }
        } else {
            System.out.println("Emailinput misslyckades");
        }   //Om något av dessa villkor inte stämmer kommer korresponderande fel
            //dyka upp informerande om vad som gick fel internt i programmets output.
            //Med denna struktur på if-satsen kommer koden heller inte gå vidare förens det första villkoret uppfylls.
    }//GEN-LAST:event_loginButtonActionPerformed
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel epostLabel;
    private javax.swing.JTextField epostTextField;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel loginLogoLabel;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordPasswordField;
    // End of variables declaration//GEN-END:variables
}
