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

public class Squid extends Alien {
    private int antal_Armar;
    
    public Squid(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Anropar superklassens konstruktor
        
        // För att se om värdet för "Antal_Armar" kommer från databasen eller från registrerings-HashMapen sker denna kontroll:
        if(!alienMap.containsKey("Value")){
        antal_Armar = Integer.parseInt(alienMap.get("Antal_Armar"));
        }
        else {
            int intValue = (int) Float.parseFloat(alienMap.get("Value"));
            antal_Armar = intValue;}
    }
    
    // Skapar ett tomt objekt
    public Squid(){
        super();
    }
    
    // Klonar ett redan existerande objekt för att kunna ersätta med nytt redigerat objekt.
    public void cloneObject(Squid other) {
        super.cloneObject(other); 
        this.antal_Armar = other.antal_Armar;
    }
    
    // Redigerar klon-objektet för att kunna ersätta gammalt.
    public void editObject(HashMap<String,String> alienMap) throws InfException{
        super.editObject(alienMap);
        double doubleValue = Double.parseDouble(alienMap.get("Antal_Armar"));
        antal_Armar = (int) Math.round(doubleValue);

    }

    // Getter för antal armar
    public int getArmCount() {
        return antal_Armar;
    }
    
    // Setter för antal armar
    public void setArmCount(int armCount) {
        this.antal_Armar = armCount;
    }
}
