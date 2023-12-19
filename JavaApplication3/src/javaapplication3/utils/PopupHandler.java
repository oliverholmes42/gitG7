/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.util.HashMap;
import javaapplication3.GUI.MainPage;
import javaapplication3.GUI.RegisterNewAlienDialogPopupV2;
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
    
    public static InfDB db;
    
    private PopupHandler(){
        
    }
    
    public static void getInputFromRegisterForm(JTextField name, JTextField email, JTextField phone, JComboBox agent,
                                                JComboBox area, JComboBox species, JSpinner value){
        HashMap<String, Object> resultMap = new HashMap<>();
        boolean isInput = false;
        
        try {
            
            String nameInput = name.getText();
            String emailInput = email.getText();
            String phoneInput = phone.getText();
            String agentInput = agent.getEditor().getItem().toString();
            String areaInput = area.getEditor().getItem().toString();
            String speciesInput = species.getEditor().getItem().toString();
            double valueToInt = ((Integer) value.getValue()).doubleValue();
            String valueInput = Double.toString(valueToInt);
            
            String alienQuery = "INSERT INTO alien (Namn, Telefon, Epost, Plats, Ansvarig_Agent)"
                    + " VALUES ('" + nameInput + "', '" + phoneInput + "', '" + emailInput + "', '" + areaInput + "', '" + agentInput + "' )";
            db.insert(alienQuery);
            
            
            
        } catch (InfException e){
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void addNewAlienPopup(MainPage Parent){
        new RegisterNewAlienDialogPopupV2(Parent, true).setVisible(true);
    }
    
    
    
}
