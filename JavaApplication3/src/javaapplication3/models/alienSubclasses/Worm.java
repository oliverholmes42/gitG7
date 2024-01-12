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

/* Denna fil hanterar subklassen Squid som tillhör superklassen Alien. I denna subklass sker två saker, nya objekt skapas, 
 * och gamla objekt klonas och ersätts med det nya objektet skapat. */
public class Worm extends Alien {
    private double langd;
    
    public Worm(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Anropar superklassens konstruktor.

        // För att se om värdet för "Längd" kommer från databasen eller från registrerings-HashMapen sker denna kontroll:
        if (!alienMap.containsKey("Value")) {
            langd = Double.parseDouble(alienMap.get("Langd"));
        } else {
            langd = Double.parseDouble(alienMap.get("Value"));
        }
    }
    
    // Skapar ett nytt tomt objekt
    public Worm() {
        super();
    }
    
    // Klonar ett redan existerande objekt för att kunna ersätta med nytt redigerat objekt.
    public void cloneObject(Worm other) {
        super.cloneObject(other); 
        this.langd = other.langd;
    }
    
    // Redigerar klon-objektet för att kunna ersätta gammalt.
    public void editObject(HashMap<String, String> alienMap) throws InfException {
        super.editObject(alienMap);
        langd = Double.parseDouble(alienMap.get("Langd"));
    }

    // Getters för längd
    public double getLength() {
        return langd;
    }
    
    // Setter för längd
    public void setLength(double length) {
        this.langd = length;
    }

}
