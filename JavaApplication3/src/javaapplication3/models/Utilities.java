/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.util.HashMap;
import static javaapplication3.models.Agent.db;
import oru.inf.InfDB;
import javaapplication3.utils.DatabaseConnection;

/**
 *
 * @author aiham, albin, vilson, oliver
 */
public class Utilities {
    private int utilityID;
    private String name;
    private HashMap<String, String> Utilities;
    public static InfDB db;
    
    //Konstruktor
    public Utilities(int utilityID){  
        
        this.utilityID = utilityID;

        db = DatabaseConnection.getInstance();
        try {
        String uQuery = "select * from utrustning where Utrustnings_ID = " + utilityID;
        Utilities = db.fetchRow(uQuery);
        this.name = Utilities.get("Benamning");


        }
        catch(Exception e){
        }

    }
    
    public void setName(String name){
   
    try{
        String nameQuery = "' UPDATE Utrustning SET Benamning = '" + name + "' WHERE Utrustnings_ID = '" + utilityID;
        db.update(nameQuery);
        this.name = name;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       } 
    }
    
    public void setID(int newUtilityID){
    try{
        String utilityQuery= "' UPDATE Utrustning SET Utrustnings_ID = '" + newUtilityID + "' WHERE Utrustnings_ID = '"+ utilityID;
        db.update(utilityQuery);
        this.utilityID = utilityID;
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
