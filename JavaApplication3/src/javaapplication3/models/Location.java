/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;

import java.util.HashMap;
import javaapplication3.utils.ObjectManager;
import oru.inf.InfDB;

/**
 *
 * @author aiham, albin,oliver, vilson
 */
public class Location {
    private int locationID;
    private Area area;
    private String locationName;
    public static InfDB db;
    
    public Location(HashMap<String,String> map, Area area) {
        locationID = Integer.parseInt(map.get("Plats_ID"));
        this.area = area;
        locationName = map.get("Benamning");
    }
    
    public void setName(String name) {
        locationName = name;
        ObjectManager.Locations.updateField(locationID, "Benamning", locationName);
    
    
    // Setter for Location ID
/*
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
        //this.existsIn = newExistsIn;
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
   }*/

   
}
