/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;

import java.util.HashMap;
import javaapplication3.utils.DatabaseConnection;
import oru.inf.InfDB;

/**
 *
 * @author aiham, albin,oliver, vilson
 */
public class Location {
    private int locationID;
    private int existsIn;
    private String locationName;
    private HashMap<String, String> LocationMap;
    public static InfDB db;
    
    public Location(int LocationID) {

        this.locationID = LocationID;
        db = DatabaseConnection.getInstance();

        try {
            String LQuery = "SELECT * from plats where Plats_ID =" + LocationID;
            LocationMap = db.fetchRow(LQuery);
            this.existsIn = Integer.parseInt(LocationMap.get("Finns_I"));
            this.locationName = LocationMap.get("Benamning");

        } catch (Exception e) {
            
        }
    }
    
    // Setter for Location ID

    public void setLocationID(int newLocationID) {
       
       try{
       String lIDQuery= " UPDATE Plats SET Plats_ID = " + newLocationID + " WHERE Plats_ID = "+ locationID;    
       db.update(lIDQuery);
       this.locationID = newLocationID;   
    }
       catch(Exception e){
            System.out.println(e.getMessage());
        }
       
       }
   
    
    
    // Getter for Location ID

     public int getLocationID() {
       return locationID;
   }
    // Setter for what area the alien exists in
     
     public void setExistsIn(int newExistsIn) {
       try{
        String eQuery= " UPDATE Plats SET Finns_I = " + newExistsIn + " WHERE Plats_ID = "+ locationID;    
        db.update(eQuery);
        this.existsIn = newExistsIn;
       }
            catch(Exception e){
            System.out.println(e.getMessage());
        }
   }
       
             
    
    // Getter for what area the alien exists in

     
     public int getExistsIn() {
       return existsIn;
   }
     
    // Setter for name

     
     public void setLocationName(String newLocationName) {
         try{
         String newNameQuery = " UPDATE Plats SET Benamning = " + newLocationName + " WHERE Plats_ID = "+ locationID; 
         db.update (newNameQuery);
         this.locationName = newLocationName;        
         }
         catch(Exception e){
            System.out.println(e.getMessage());
         }
         
   }
    
    // Getter for name

     
     public String getName() {
       return locationName;
   }

   
}
