/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;

/**
 *
 * @author aiham
 */
public class Location {
    private int Location_ID;
    private int Exists_In;
    private String Location_Name;

    
    public Location(int Location_ID, int Exists_In, String Location_Name){
        this.Location_ID = Location_ID;
        this.Exists_In = Exists_In;
        this.Location_Name = Location_Name;

    }
    
    // Setter for Location ID

    public void setLocation_ID(int Location_ID) {
       this.Location_ID = Location_ID;
   }
    // Getter for Location ID

     public int getLocation_ID() {
       return Location_ID;
   }
    // Setter for what area the alien exists in
     
     public void setExists_In(int Exists_In) {
       this.Exists_In = Exists_In;
   }
    
    // Getter for what area the alien exists in

     
     public int getExists_In() {
       return Exists_In;
   }
     
    // Setter for name

     
     public void setLocation_Name(String Location_Name) {
       this.Location_ID = Location_ID;
   }
    
    // Getter for name

     
     public String getLocation_Name() {
       return Location_Name;
   }

   
}
