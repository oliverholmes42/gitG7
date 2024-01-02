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
        else{ antal_Boogies = Integer.parseInt(alienMap.get("Value"));}
    }
    
    public void editObject(HashMap<String,String> alienMap) throws InfException {
        super.editObject(alienMap);
        antal_Boogies = Integer.parseInt(alienMap.get("Antal_Boogies"));
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
