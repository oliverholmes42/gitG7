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
    private int LocationID;
    private int ExistsIn;
    private String LocationName;

    
    public Location(int LocationID, int ExistsIn, String LocationName){
        this.LocationID = LocationID;
        this.ExistsIn = ExistsIn;
        this.LocationName = LocationName;

    }
    
    // Setter for Location ID

    public void setLocationID(int LocationID) {
       this.LocationID = LocationID;
   }
    // Getter for Location ID

     public int getLocationID() {
       return LocationID;
   }
    // Setter for what area the alien exists in
     
     public void setExistsIn(int ExistsIn) {
       this.ExistsIn = ExistsIn;
   }
    
    // Getter for what area the alien exists in

     
     public int getExistsIn() {
       return ExistsIn;
   }
     
    // Setter for name

     
     public void setLocation_Name(String LocationName) {
       this.LocationName = LocationName;
   }
    
    // Getter for name

     
     public String getLocation_Name() {
       return LocationName;
   }

   
}
