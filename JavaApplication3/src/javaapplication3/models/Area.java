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
   public static InfDB db;

   // Constructor
   public Area(HashMap<String,String> areaMap){
       
       areaID = Integer.parseInt(areaMap.get("Omrades_ID"));
       areaName = areaMap.get("Benamning");
   }
   

   // Getters and Setters
   public int getAreaID() {
       return areaID;
   }
   
   @Override
    public String toString() {
        return areaID + ": " + areaName;
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


