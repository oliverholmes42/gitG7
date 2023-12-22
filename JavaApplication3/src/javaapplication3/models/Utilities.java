/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.util.HashMap;
import static javaapplication3.models.Alien.db;
import oru.inf.InfDB;
import javaapplication3.utils.DatabaseConnection;

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
    
    public void setName(String name){
   
        try{
        String query = "UPDATE Utrustning SET Benamning = " + name + " WHERE Utrustnings_ID  = " + utilityID;
        db.update(query);
        this.name = name;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }
    }
    
    public void setID(int newUtilityID){
        try{
        String query = "UPDATE Utrustning SET Utrustnings_ID  = " + newUtilityID + " WHERE Utrustnings_ID  = " + utilityID;
        db.update(query);
        this.utilityID = newUtilityID;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }
    }
     
    public String getName(){
    return name;
    }
    
    public int getID(){
    return utilityID;
    }
}
