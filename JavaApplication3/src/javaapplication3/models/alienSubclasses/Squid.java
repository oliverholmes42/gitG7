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
public class Squid extends Alien {
    private int armCount;
    
    public Squid(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Call the superclass constructor
        if(!alienMap.containsKey("value")){
        armCount = Integer.parseInt(alienMap.get("Antal_Armar"));
        }
        else {armCount = Integer.parseInt(alienMap.get("value"));}
    }
    
    public void editObject(HashMap<String,String> alienMap){
        super.editObject(alienMap);
        armCount = Integer.parseInt(alienMap.get("Antal_Armar"));
    }

    // Getters and setters for the length attribute
    public int getArmCount() {
        return armCount;
    }

    public void setArmCount(int armCount) {
        this.armCount = armCount;
    }

    // Other methods...

}
