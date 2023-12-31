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
public class Boglodite extends Alien {
    private int antal_Boogies;
    
    public Boglodite(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Call the superclass constructor
        if(!alienMap.containsKey("Value")){
        antal_Boogies = Integer.parseInt(alienMap.get("Antal_Boogies"));
        }
        else{ 
            int intValue = (int) Float.parseFloat(alienMap.get("Value"));
            antal_Boogies = intValue;
        }
    }
    
    public Boglodite(){
        super();
    }
    
    public void cloneObject(Boglodite other) {
        super.cloneObject(other); // Call Alien's cloneObject to handle Alien properties
        this.antal_Boogies = other.antal_Boogies; // Clone Squid-specific property
    }
    
    public void editObject(HashMap<String,String> alienMap) throws InfException {
        super.editObject(alienMap);
        double doubleValue = Double.parseDouble(alienMap.get("Antal_Boogies"));
        antal_Boogies = (int) Math.round(doubleValue);

    }

    // Getters and setters for the length attribute
    public int getBoogieCount() {
        return antal_Boogies;
    }

    public void setBoogieCount(int boogieCount) {
        this.antal_Boogies = boogieCount;
    }

    // Other methods...

}
