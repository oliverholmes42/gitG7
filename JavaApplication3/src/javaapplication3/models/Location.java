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
    private int locationID;
    private int existsIn;
    private String locationName;

    
    public Location(int LocationID, int ExistsIn, String LocationName){
        this.locationID = LocationID;
        this.existsIn = ExistsIn;
        this.locationName = LocationName;

    }
    
    // Setter for Location ID

    public void setLocationID(int LocationID) {
       this.locationID = LocationID;
   }
    // Getter for Location ID

     public int getLocationID() {
       return locationID;
   }
    // Setter for what area the alien exists in
     
     public void setExistsIn(int ExistsIn) {
       this.existsIn = ExistsIn;
   }
    
    // Getter for what area the alien exists in

     
     public int getExistsIn() {
       return existsIn;
   }
     
    // Setter for name

     
     public void setLocation_Name(String LocationName) {
       this.locationName = LocationName;
   }
    
    // Getter for name

     
     public String getLocation_Name() {
       return locationName;
   }

   
}
