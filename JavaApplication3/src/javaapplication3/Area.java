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
   private int AID;
   private String name;

   // Constructor
   public Area(int AID, String name) {
       this.AID = AID;
       this.name = name;
   }

   // Getters and Setters
   public int getAID() {
       return AID;
   }

   public void setAID(int AID) {
       this.AID = AID;
   }

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
}


