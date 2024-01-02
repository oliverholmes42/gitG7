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
        if(!alienMap.containsKey("value")){
        antal_Armar = Integer.parseInt(alienMap.get("Antal_Armar"));
        }
        else {antal_Armar = Integer.parseInt(alienMap.get("value"));}
    }
    
    public void editObject(HashMap<String,String> alienMap) throws InfException{
        super.editObject(alienMap);
        antal_Armar = Integer.parseInt(alienMap.get("Antal_Armar"));
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
