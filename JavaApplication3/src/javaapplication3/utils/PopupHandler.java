/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import javaapplication3.GUI.MainPage;
import javaapplication3.GUI.RegisterNewAgentDialog;
import javaapplication3.GUI.RegisterNewAlienDialogPopupV2;
import javaapplication3.models.Area;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author vilso
 */
public class PopupHandler {
    
    public static InfDB db = DatabaseConnection.getInstance();
    
    private PopupHandler(){
    }
    
    
    public static void bogloditeComboBoxHandler(JSpinner value){
        
        try {
            double valueToInt = ((Integer) value.getValue()).doubleValue();
            String valueInput = Double.toString(valueToInt);
            String query = "INSERT INTO boglodite (Antal_Boogies) VALUES '" + valueInput + "'";
            db.insert(query);
            
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void squidComboBoxHandler(JSpinner value){
        
        try {
            double valueToInt = ((Integer) value.getValue()).doubleValue();
            String valueInput = Double.toString(valueToInt);
            String query = "INSERT INTO squid (Antal_Armar) VALUES '" + valueInput + "'";
            db.insert(query);
            
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void wormComboBoxHandler(JSpinner value){
        
        try {
            double valueToInt = ((Integer) value.getValue()).doubleValue();
            String valueInput = Double.toString(valueToInt);
            String query = "INSERT INTO worm (Langd) VALUES '" + valueInput + "'";
            db.insert(query);
            
        } catch (InfException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    /*public static void getInputFromRegisterForm(JTextField name, JTextField email, JTextField phone, JComboBox agent, JComboBox area){
        
        try {
            
            String nameInput = name.getText();
            String emailInput = email.getText();
            String phoneInput = phone.getText();
            String agentInput = agent.getEditor().getItem().toString();
            //int areaInput = ;
            
            String alienQuery = "INSERT INTO alien (Namn, Telefon, Epost, Plats, Ansvarig_Agent)"
                    + " VALUES ('" + nameInput + "', '" + phoneInput + "', '" + emailInput + "', '" + areaInput + "', '" + agentInput + "' )";
            db.insert(alienQuery);
            
        } catch (InfException e){
            System.out.println(e.getMessage());
        }
        
    }*/
    
    public static void addNewAlienPopup(MainPage Parent){
        new RegisterNewAlienDialogPopupV2(Parent, true).setVisible(true);
    }
    
    public static void generateRandomPassword(){
        
    }
    
    public static void addNewAgentPopup(MainPage Parent){
        new RegisterNewAgentDialog(Parent, true).setVisible(true);
    }
    
}
