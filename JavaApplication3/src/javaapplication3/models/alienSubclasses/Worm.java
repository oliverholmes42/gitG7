/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.alienSubclasses;

import java.util.HashMap;
import javaapplication3.models.Agent;
import javaapplication3.models.Alien;
import javaapplication3.models.Location;
import oru.inf.InfException;

/**
 *
 * @author mopaj
 */
public class Worm extends Alien {
    private double langd;
    
    public Worm(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Call the superclass constructor
        if (!alienMap.containsKey("Value")){
        langd = Double.parseDouble(alienMap.get("Langd"));
    }
    else{langd =Double.parseDouble(alienMap.get("Value"));}}
    
     public Worm(){
        super();
    }
    
    public void cloneObject(Worm other) {
        super.cloneObject(other); // Call Alien's cloneObject to handle Alien properties
        this.langd = other.langd; // Clone Squid-specific property
    }
    
    
    
    public void editObject(HashMap<String,String> alienMap) throws InfException {
        super.editObject(alienMap);
         langd = Double.parseDouble(alienMap.get("Langd"));
    }

    // Getters and setters for the length attribute
    public double getLength() {
        return langd;
    }

    public void setLength(double length) {
        this.langd = length;
    }

  

}
