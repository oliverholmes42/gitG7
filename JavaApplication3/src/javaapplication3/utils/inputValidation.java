/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import static javaapplication3.GUI.LoginPage.time;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Denna fil sköter valideringen av inloggningsuppgifter för loginsidan i
 * programmet. Valideringen består utav tre steg: Det måste finnas text i
 * emailfältet, ett lösenord i lösenordsfältet, och det som är angivet
 * kontrolleras genom informationen i databasen samt jämförs med varandra så de
 * stämmer överens.
 */
public class inputValidation {

    private static final InfDB db = DatabaseConnection.getInstance();
    
    //Denna metod hanterar fall där lösenordsfältet står tomt när man försöker logga in:
    public static boolean isPasswordInputEmpty(JPasswordField input) {

        boolean result = true;//Flaggar för om det finns text i fältet. Börjar som sant.

        //För att kontrollera innehållet i textfältet används metoden .isEmpty().
        if (input.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lösenord måste anges.");
            result = false;//Flaggar för att det är tomt.
        }

        return result;
    }
    
    /* Valideringsmetod för email. Här sker ett par olika kontroller, först av allt om är formaterat på ett korrekt sätt och ger avslag ifall
     * det är inkorrekt, sen sker två till kontroller på om emailen redan finns registrerad i emaillistan hos både aliens och agenter och om det
     * redan finns ges avslag, annars går man vidare. */
    public static boolean emailValidation(JTextField email) {
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}");
        Container parent = getTopLevelContainer(email);
        String parentName = parent.getClass().getSimpleName();
        String emailString = email.getText();
        System.out.println(12 + " " + (System.currentTimeMillis() - time));
        if (!emailPattern.matcher(emailString).matches()) {
            JOptionPane.showMessageDialog(parent, "Eposten är inte giltig");
            return false;
        }
        System.out.println(13 + " " + (System.currentTimeMillis() - time));
        switch (parentName) {
            case "RegisterNewAgentDialog" -> {
                if (ObjectManager.Agents.emailList.contains(emailString.toLowerCase())) {
                    JOptionPane.showMessageDialog(parent, "Agent med denna epost finns redan.");
                    return false;
                } else if (!emailString.contains("@mib")) {
                    JOptionPane.showMessageDialog(parent, "Inkorrekt epost\n@ och domän måste finnas med.");
                    return false;
                }
                return true;
            }

            case "RegisterNewAlienDialogPopupV2" -> {
                if (ObjectManager.Aliens.emailList.contains(emailString.toLowerCase())) {
                    JOptionPane.showMessageDialog(parent, "Alien med denna epost finns redan.");
                    return false;
                }
            }

        }
        System.out.println(14 + " " + (System.currentTimeMillis() - time));
        return true;
    }
    
    // Validering för om textfältet saknar input
    public static boolean fieldValidation(JTextField field) {
        if (field.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fält saknar info");
            return false;
        }
        return true;
    }
    
    // Validering för om textfältet för telefon saknar input
    public static boolean phoneValidation(JTextField field) {
        String text = field.getText();
        if (!text.matches("^[\\d-]+$")) {
            JOptionPane.showMessageDialog(null, "Telefonnummer inte godkänt");
            return false;
        }
        return true;
    }
    
    // Validering för om comboboxalternativ saknar input
    public static boolean comboBoxValidation(JComboBox box) {
        if (box.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Alternativ Saknas");
            return false;
        }
        return true;
    }
    
    // Validering för om textfältet lösenord saknar input
    public static boolean passwordValidaton(JTextField field){
            if(field.getText().matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+")){
                if(field.getText().length()>6){
                    JOptionPane.showMessageDialog(null, "Ej godkänt lösenord.\nMåste vara kortare än 6 tecken");
                    return false;
                }
                return true;
            }
        JOptionPane.showMessageDialog(null, "Ej godkänt lösenord.\nMåste innehålla 1 versal, 1 german och 1 siffra.");
        return false;
    }

    // Tar in en komponent och returnerar den frame eller dialog som komponenten tillhör
    public static Container getTopLevelContainer(Component component) {
        System.out.println(111 + " " + (System.currentTimeMillis() - time));
        Container parent = component.getParent();
        System.out.println(112 + " " + (System.currentTimeMillis() - time));
        while (parent != null) {
            if (parent instanceof JFrame || parent instanceof JDialog) {
                System.out.println(113 + " " + (System.currentTimeMillis() - time));
                return parent;
            }
            parent = parent.getParent();
        }
        return null;
    }

    //För att kunna jämföra epost med lösenord kommer denna metod hjälpa. Här sker en jämförelse mellan angiven email
    //och angivet lösenord och kollar så de stämmer överens innan man kan få tillgång till nästa sida.
    public static Map<String, Object> isEmailAndPasswordCorrect(JTextField email, JPasswordField password) {
        Map<String, Object> resultMap = new HashMap<>();
        boolean isValidated = false;
        int userId = -1;
        int type = 0;
        String name = "";

        try {
            String emailInput = email.getText();
            char[] passwordInput = password.getPassword();//JPasswordField lagrar data i en Array av char's och måste konverteras.
            String passwordInputToString = String.valueOf(passwordInput);//String.valueOf() sköter konvertering till String.

            String emailQueryAgent = "SELECT * FROM agent WHERE Epost = '" + emailInput + "' AND Losenord = '" + passwordInputToString + "'";
            String emailQueryAlien = "SELECT * FROM alien WHERE Epost = '" + emailInput + "' AND Losenord = '" + passwordInputToString + "'";

            HashMap<String, String> emailQueryResultAgent = db.fetchRow(emailQueryAgent);//SQL-frågan sparas i en lokal variabel.
            HashMap<String, String> emailQueryResultAlien = db.fetchRow(emailQueryAlien);

            if (!emailQueryResultAgent.isEmpty()) {//Denna fråga innebär om resultatet från SQL-frågan resulterar i ingenting.
                String id = emailQueryResultAgent.get("Agent_ID");
                String admin = emailQueryResultAgent.get("Administrator");
                isValidated = true;
                userId = Integer.parseInt(emailQueryResultAgent.get("Agent_ID"));
                name = emailQueryResultAgent.get("Namn");
                Boolean isAdmin = admin.equals("J");
                if (isAdmin) {
                    type = 5;
                } else {

                    //Det kan ENDAST resultera i ingenting ifall jämförelsen inte stämmer.
                    String isFaltAgent = db.fetchSingle("SELECT Agent_ID FROM faltagent WHERE Agent_ID = " + id);
                    String isKontorsChef = db.fetchSingle("SELECT Agent_ID FROM kontorschef WHERE Agent_ID = " + id);
                    String isOmradesChef = db.fetchSingle("SELECT Agent_ID FROM omradeschef WHERE Agent_ID = " + id);
                    isValidated = true;
                    
                    // Validering kring vilken åtkomst som ska ges
                    if (isFaltAgent != null) {
                        type = 2;
                    }
                    if (isKontorsChef != null) {
                        type = 3;
                    }

                    if (isOmradesChef != null) {
                        type = 4;
                    }
                }
            } else if (!emailQueryResultAlien.isEmpty()) {
                isValidated = true;
                userId = Integer.parseInt(emailQueryResultAlien.get("Alien_ID"));
                type = 1;
                name = emailQueryResultAlien.get("Namn");

            } else {
                JOptionPane.showMessageDialog(null, "Fel lösenord eller epost");
            }

        } catch (InfException e) {
            System.out.println("Internt felmeddelande: " + e.getMessage());
            //För att programmerare ska kunna se felet som kan uppstå kommer ett internt felmeddelande i konsolen.
        }

        resultMap.put("isValidated", isValidated);
        resultMap.put("userId", userId);
        resultMap.put("type", type);
        resultMap.put("name", name);

        return resultMap;

    }
}
