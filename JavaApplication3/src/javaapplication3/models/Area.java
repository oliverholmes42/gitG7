/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;

import java.util.HashMap;
import static javaapplication3.models.Agent.db;
import static javaapplication3.models.Utilities.db;
import oru.inf.InfDB;
import javaapplication3.utils.DatabaseConnection;

/**
 *
 * @author Albin, Vilson, Oliver, Aiham
 */
public class Area {
   private int areaID;
   private String areaName;
   private HashMap<String, String> Area;
   public static InfDB db;

   // Constructor
   public Area(int Area_ID){
       
       this.areaID = Area_ID;
       db = DatabaseConnection.getInstance();
       try{
       String aQuery = "Select * from omrade where Omrades_ID = " + Area_ID;
       Area = db.fetchRow(aQuery);
       this.areaName = Area.get("Benamning");
       
       }
       catch(Exception e){ 
       }
   }
   

   // Getters and Setters
   public int getAreaID() {
       return areaID;
   }

   public void setAreaID(int newAreaID) {
           try{
        String aIDQuery= "' UPDATE Omrade SET Omrades_ID = '" + newAreaID + "' WHERE Omrades_ID = '"+ areaID;
        db.update(aIDQuery);
        this.areaID = newAreaID;
    }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
   }


   public void setName(String newAreaName) {
        try{
        String nameQuery = "' UPDATE omrade SET Benamning = '" + newAreaName + "' WHERE  = '" + areaID;
        db.update(nameQuery);
        this.areaName = newAreaName;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       } 
  
   }
   
      public String getName() {
       return areaName;
   }
}


