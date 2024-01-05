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
public class Squid extends Alien {
    private int antal_Armar;
    
    public Squid(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Call the superclass constructor
        if(!alienMap.containsKey("Value")){
        antal_Armar = Integer.parseInt(alienMap.get("Antal_Armar"));
        }
        else {
            int intValue = (int) Float.parseFloat(alienMap.get("Value"));
            antal_Armar = intValue;}
    }
    
    public Squid(){
        super();
    }
    
    public void cloneObject(Squid other) {
        super.cloneObject(other); // Call Alien's cloneObject to handle Alien properties
        this.antal_Armar = other.antal_Armar; // Clone Squid-specific property
    }
    
    public void editObject(HashMap<String,String> alienMap) throws InfException{
        super.editObject(alienMap);
        double doubleValue = Double.parseDouble(alienMap.get("Antal_Armar"));
        antal_Armar = (int) Math.round(doubleValue);

    }

    // Getters and setters for the length attribute
    public int getArmCount() {
        return antal_Armar;
    }

    public void setArmCount(int armCount) {
        this.antal_Armar = armCount;
    }

    // Other methods...

}
