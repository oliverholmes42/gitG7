/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.util.HashMap;
import oru.inf.InfDB;


/**
 *
 * @author aiham, albin, vilson, oliver
 */
public class Utilities {
    private int utrustnings_ID;
    private String benamning;
    public static InfDB db;
    
    //Konstruktor
    public Utilities(HashMap<String, String> utilitiesMap){  
        
        this.utrustnings_ID = Integer.parseInt(utilitiesMap.get("Utrustnings_ID"));
        this.benamning = utilitiesMap.get("Benamning");

    }
    
    public void setName(String newName){
        benamning = newName; 

    }
    
    public void setID(int newUtilityID){
        utrustnings_ID = newUtilityID;
    }
     
    public String getName(){
    return benamning;
    }
    
    public int getID(){
    return utrustnings_ID;
    }
}
