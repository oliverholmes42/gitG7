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

/* Denna fil hanterar subklassen Boglodite som tillhör superklassen Alien. I denna subklass sker två saker, nya objekt skapas, 
 * och gamla objekt klonas och ersätts med det nya objektet skapat. */
public class Boglodite extends Alien {
    private int antal_Boogies;
    
    public Boglodite(HashMap<String, String> alienMap, Location location, Agent agent) {
        super(alienMap, location, agent); // Anropar superklassens konstruktor. 
        
        // För att se om värdet för "Antal_Boogies" kommer från databasen eller från registrerings-HashMapen sker denna kontroll:
        if(!alienMap.containsKey("Value")){
        antal_Boogies = Integer.parseInt(alienMap.get("Antal_Boogies"));
        }
        else{ 
            int intValue = (int) Float.parseFloat(alienMap.get("Value"));
            antal_Boogies = intValue;
        }
    }
    
    // Skapar ett tomt objekt.
    public Boglodite(){
        super();
    }
    
    // Klonar ett redan existerande objekt, för att sedan kunna ersätta med ett nytt redigerat.
    public void cloneObject(Boglodite other) { 
        super.cloneObject(other); 
        this.antal_Boogies = other.antal_Boogies; 
    }
    
    // Redigerar objektet
    public void editObject(HashMap<String,String> alienMap) throws InfException {
        super.editObject(alienMap);
        double doubleValue = Double.parseDouble(alienMap.get("Antal_Boogies"));
        antal_Boogies = (int) Math.round(doubleValue);

    }

    // Getters för antal boogies
    public int getBoogieCount() {
        return antal_Boogies;
    }
    
    // Setter för antal boogies
    public void setBoogieCount(int boogieCount) {
        this.antal_Boogies = boogieCount;
    }
}
