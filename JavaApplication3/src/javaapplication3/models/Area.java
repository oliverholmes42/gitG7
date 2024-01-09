/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.util.HashMap;
import oru.inf.InfDB;


/**
 *
 * @author Albin, Vilson, Oliver, Aiham
 */
public class Area {
   private int omrades_ID;
   private String benamning;
   public static InfDB db;

   // Constructor
   public Area(HashMap<String,String> areaMap){
       
       omrades_ID = Integer.parseInt(areaMap.get("Omrades_ID"));
       benamning = areaMap.get("Benamning");
   }
   

   // Getters and Setters
   public int getId() {
       return omrades_ID;
   }
   
   public void setAreaID(int newAreaID) {
       omrades_ID = newAreaID;
   }


   public void setName(String newAreaName) {
       benamning = newAreaName;  
   }
   
      public String getName() {
       return benamning;
   }
}


