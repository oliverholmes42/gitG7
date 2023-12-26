/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.panels.AlienPanel;
import javaapplication3.GUI.panels.LocationPanel;
import javaapplication3.models.Alien;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.time.LocalDate;
import java.util.Map;
import javaapplication3.models.Area;
import javax.swing.JComboBox;


/**
 *
 * @author vilso
 */
public class ResultTableManager {
    
    public static InfDB db;
    
    
    /*public void loadTable() throws InfException {
        try {
            // TODO add your handling code here:
            ObjectManager.Aliens.loadAlienList();
        } catch (NumberFormatException ex) {
            Logger.getLogger(AlienPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InfException ex) {
            Logger.getLogger(AlienPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        AlienPanel.tableModel.setRowCount(0); // Clear existing rows
        
        for (Alien item : ObjectManager.Aliens.alienList) {
            String[] row = {Integer.toString(item.getAlienID()), 
                            item.getAlienName(), 
                            item.getAlienPhonenumber(), 
                            item.getAlienEpost(), 
                            LocalDate.parse(item.valueOf(getRegistrationDate()))};
            tableModel.addRow(row);
        }
    }*/
    
    
    public static void createQueryForAreaFilter(JComboBox area) throws InfException{
        
        for(Area a : ObjectManager.Areas.areaList.values()){
            
            //area.addElement(a.getName());
        }
    }
    
    
    
    
    /*public static void getInputFromSearchFilter(JTextField name, JTextField email, JTextField phone, JComboBox agent, JComboBox area){
        
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
}
