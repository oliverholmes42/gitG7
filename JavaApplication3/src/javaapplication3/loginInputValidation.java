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
 *
 * @author vilso
 */
public class loginInputValidation {
    
    public static InfDB db;
    
    public static boolean isEmailInputEmpty(JTextField input){
        
        boolean result = true;
        
        if(input.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Email måste anges.");
            result = false;
        }
        
        return result;
    }
    
    public static boolean isPasswordInputEmpty(JPasswordField input){
        
        boolean result = true;
        
        if(input.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lösenord måste anges.");
            result = false;
        }
        
        return result;
    }
    
    public static boolean isEmailAndPasswordCorrect(JTextField email, JPasswordField password){
        
        boolean isValidated = false;
        
        try {
            String emailInput = email.getText();
            char[] passwordInput = password.getPassword();
            String passwordInputToString = String.valueOf(passwordInput);
            
            String emailQuery = "SELECT Epost FROM agent WHERE Epost = '" + emailInput + "' AND Losenord = '" + passwordInputToString + "'";
            String emailQueryResult = db.fetchSingle(emailQuery);
            if(emailQueryResult == null){
                JOptionPane.showMessageDialog(null, "Inloggning misslyckades.");
            }else{
                JOptionPane.showMessageDialog(null, "Inloggning lyckades!");
                isValidated = true;
            }
            
        }catch(InfException e){
            System.out.println("Internt felmeddelande: " + e.getMessage());
        }
        
        return isValidated;
        
    }
}
