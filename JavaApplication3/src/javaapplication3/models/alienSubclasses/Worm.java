/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.alienSubclasses;

import java.util.HashMap;
import javaapplication3.models.Agent;
import javaapplication3.models.Alien;
import javaapplication3.models.Location;

/**
 *
 * @author mopaj
 */
public class Worm extends Alien {
    private double length;
    
    public Worm(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Call the superclass constructor
        if (!alienMap.containsKey("value")){
        length = Double.parseDouble(alienMap.get("Langd"));
    }
    else{length =Double.parseDouble(alienMap.get("value"));}}
    
    public void editObject(HashMap<String,String> alienMap) {
        super.editObject(alienMap);
        length = Double.parseDouble(alienMap.get("Langd"));
    }

    // Getters and setters for the length attribute
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    // Other methods...

}
