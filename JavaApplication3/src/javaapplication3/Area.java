/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
public class Area {
   private int Area_ID;
   private String Area_name;

   // Constructor
   public Area(int Area_ID, String Area_name) {
       this.Area_ID = Area_ID;
       this.Area_name = Area_name;
   }

   // Getters and Setters
   public int getArea_ID() {
       return Area_ID;
   }

   public void setArea_ID(int Area_ID) {
       this.Area_ID = Area_ID;
   }

   public String getareaName() {
       return Area_name;
   }

   public void setName(String Area_name) {
       this.Area_name = Area_name;
   }
}


