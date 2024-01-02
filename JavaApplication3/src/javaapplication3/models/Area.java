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
import javaapplication3.utils.ObjectManager;

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
   public int getId() {
       return areaID;
   }
   
   public void setAreaID(int newAreaID) {
       ObjectManager.Areas.updateField(areaID, "Omrades_ID", newAreaID);
       areaID = newAreaID;
   }


   public void setName(String newAreaName) {
       ObjectManager.Areas.updateField(areaID, "Benamning", newAreaName);
       areaName = newAreaName;  
   }
   
      public String getName() {
       return areaName;
   }
}


