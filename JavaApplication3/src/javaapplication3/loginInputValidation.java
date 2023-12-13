/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

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
    
    public static InfDB db;
    
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
    
    //För att kunna jämföra epost med lösenord kommer denna metod hjälpa. Här sker en jämförelse mellan angiven email
    //och angivet lösenord och kollar så de stämmer överens innan man kan få tillgång till nästa sida.
    public static boolean isEmailAndPasswordCorrect(JTextField email, JPasswordField password){
        
        boolean isValidated = false;//Flagga för att påvisa om man som användare är validerad.
        
        try {
            String emailInput = email.getText();
            char[] passwordInput = password.getPassword();//JPasswordField lagrar data i en Array av char's och måste konverteras.
            String passwordInputToString = String.valueOf(passwordInput);//String.valueOf() sköter konvertering till String.
            
            String emailQuery = "SELECT Epost FROM agent WHERE Epost = '" + emailInput + "' AND Losenord = '" + passwordInputToString + "'";
            String emailQueryResult = db.fetchSingle(emailQuery);//SQL-frågan sparas i en lokal variabel.
            
            if(emailQueryResult == null){//Denna fråga innebär om resultatet från SQL-frågan resulterar i ingenting.
                                         //Det kan ENDAST resultera i ingenting ifall jämförelsen inte stämmer. 
                JOptionPane.showMessageDialog(null, "Inloggning misslyckades.");
            }else{
                JOptionPane.showMessageDialog(null, "Inloggning lyckades!");
                isValidated = true;//Flaggar för att valideringen är lyckad.
            }
            
        }catch(InfException e){
            System.out.println("Internt felmeddelande: " + e.getMessage());
            //För att programmerare ska kunna se felet som kan uppstå kommer ett internt felmeddelande i konsolen.
        }
        
        return isValidated;
        
    }
}
