/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.awt.Component;
import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Denna fil sköter valideringen av inloggningsuppgifter för loginsidan i programmet. Valideringen består utav tre steg:
 * Det måste finnas text i emailfältet, ett lösenord i lösenordsfältet, och det som är angivet kontrolleras genom 
 * informationen i databasen samt jämförs med varandra så de stämmer överens.
 * 
 * @author vilson, albin, oliver, aiham
 */
public class loginInputValidation {
    
    
    
    private static InfDB db = DatabaseConnection.getInstance();
    
    //Denna metod hanterar fall där epostfältet står tomt när man försöker logga in:
    public static boolean isEmailInputEmpty(JTextField input){
        
        boolean result = true;//Flaggar för om det finns text i fältet. Börjar som sant.
        
        //För att kontrollera innehållet i textfältet används metoden .isEmpty().
        if(input.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Email måste anges.");
            result = false;//Flaggar för att det är tomt.
        }
        
        return result;
    }
    
    //Denna metod hanterar fall där lösenordsfältet står tomt när man försöker logga in:
    public static boolean isPasswordInputEmpty(JPasswordField input){
        
        boolean result = true;//Flaggar för om det finns text i fältet. Börjar som sant.
        
        //För att kontrollera innehållet i textfältet används metoden .isEmpty().
        if(input.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lösenord måste anges.");
            result = false;//Flaggar för att det är tomt.
        }
        
        return result; 
    }
    
    public static boolean emailValidation(JTextField email){
        String emailString = email.getText();
        if(!emailString.contains("@")){
            JOptionPane.showMessageDialog(null, "Korrekt emailadress måste anges. Försök igen.");
            return false;
        }
        String parentName = getTopLevelContainerName(email);
        switch(parentName){
            case "RegisterNewAgentDialog" -> { 
                if(ObjectManager.Agents.emailList.contains(emailString.toLowerCase())){
                    JOptionPane.showMessageDialog(null, "Agent med detta namn finns redan.");
                    return false;
                }
                else if(!emailString.contains("@mib")){
                    JOptionPane.showMessageDialog(null, "Inkorrekt epost\n@ och domän måste finnas med.");
                    return false;
                }
                return true;
            }
            
            case "RegisterNewAlienDialogPopupV2" -> {
                return !ObjectManager.Aliens.emailList.contains(emailString.toLowerCase());
            }
             
        }
        return true;
    }
    
    public static String getTopLevelContainerName(Component component) {
    Container parent = component.getParent();
    while (parent != null) {
        if (parent instanceof JFrame||parent instanceof JDialog) {
            return parent.getClass().getSimpleName();
        }
        parent = parent.getParent();
    }
    return "Unknown";
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
            HashMap<String,String> emailQueryResultAlien = db.fetchRow(emailQueryAlien);
            
            if(!emailQueryResultAgent.isEmpty()){//Denna fråga innebär om resultatet från SQL-frågan resulterar i ingenting.
                String id = emailQueryResultAgent.get("Agent_ID");
                String admin = emailQueryResultAgent.get("Administrator");
                isValidated = true;
                userId = Integer.parseInt(emailQueryResultAgent.get("Agent_ID"));
                name = emailQueryResultAgent.get("Namn");
                Boolean isAdmin = admin.equals("J");
                if(isAdmin){
                    type = 5;
                }
                else{
                
                  //Det kan ENDAST resultera i ingenting ifall jämförelsen inte stämmer.
                String isFaltAgent = db.fetchSingle("SELECT Agent_ID FROM faltagent WHERE Agent_ID = "+id);
                String isKontorsChef = db.fetchSingle("SELECT Agent_ID FROM kontorschef WHERE Agent_ID = "+id);
                String isOmradesChef = db.fetchSingle("SELECT Agent_ID FROM omradeschef WHERE Agent_ID = "+id);
                isValidated = true;
                
                
                if (isFaltAgent!=null) {
                    type = 2;
                }
                if(isKontorsChef!=null){
                    type = 3;
                }
                
                if(isOmradesChef!=null){
                    type = 4;
                }}}
                
            else if(!emailQueryResultAlien.isEmpty()){
                isValidated = true;
                userId = Integer.parseInt(emailQueryResultAlien.get("Alien_ID"));
                type = 1;
                name = emailQueryResultAlien.get("Namn");
            
            }
            else{
                 JOptionPane.showMessageDialog(null, "Inloggning misslyckades.");
            }
            
        }catch(InfException e){
            System.out.println("Internt felmeddelande: " + e.getMessage());
            //För att programmerare ska kunna se felet som kan uppstå kommer ett internt felmeddelande i konsolen.
        }
        
        resultMap.put("isValidated", isValidated);
        resultMap.put("userId", userId);
        resultMap.put("type", type);
        resultMap.put("name", name);
        
        return resultMap;
        
    
}}
