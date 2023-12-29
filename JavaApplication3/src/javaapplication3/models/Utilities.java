/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.util.HashMap;
import oru.inf.InfDB;
import javaapplication3.utils.ObjectManager;

/**
 *
 * @author aiham, albin, vilson, oliver
 */
public class Utilities {
    private int utilityID;
    private String name;
    public static InfDB db;
    
    //Konstruktor
    public Utilities(HashMap<String, String> utilitiesMap){  
        
        this.utilityID = Integer.parseInt(utilitiesMap.get("Utrustnings_ID"));
        this.name = utilitiesMap.get("Benamning");

    }
    
    public void setName(String newName){
        ObjectManager.UtilitiesHandler.updateField(utilityID, "Benamning", newName);
        name = newName; 

    }
    
    public void setID(int newUtilityID){
        ObjectManager.UtilitiesHandler.updateField(utilityID, "Utrustnings_ID", newUtilityID);
        utilityID = newUtilityID;
    }
     
    public String getName(){
    return name;
    }
    
    public int getID(){
    return utilityID;
    }
}
