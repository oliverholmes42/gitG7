/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.time.LocalDate;
import java.util.HashMap;
import javaapplication3.utils.ObjectManager;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author aiham
 */
public class Alien {
    private int alien_ID;
    private LocalDate registreringsdatum;
    private String epost;
    private String losenord;
    private String namn;
    private String telefon;
    private Location plats;
    private Agent ansvarig_Agent;
    public static InfDB db;


    public Alien(HashMap<String, String> alienMap, Location location, Agent agent){
        
        this.alien_ID = Integer.parseInt(alienMap.get("Alien_ID"));
        this.registreringsdatum = LocalDate.parse(alienMap.get("Registreringsdatum"));
        this.epost = alienMap.get("Epost");
        this.losenord = alienMap.get("Losenord");
        this.namn = alienMap.get("Namn");
        this.telefon = alienMap.get("Telefon");
        this.plats = location;
        ansvarig_Agent = agent;
        
        }
    
      public Alien() {
        this.alien_ID = 0;
        this.registreringsdatum = null;
        this.epost = null;
        this.losenord = null;
        this.namn = null;
        this.telefon = null;
        this.plats = null;
        this.ansvarig_Agent = null;
    }
      
      public void cloneObject(Alien other) {
        this.alien_ID = other.alien_ID;
        this.registreringsdatum = other.registreringsdatum;
        this.epost = other.epost;
        this.losenord = other.losenord;
        this.namn = other.namn;
        this.telefon = other.telefon;
        this.plats = other.plats;
        this.ansvarig_Agent = other.ansvarig_Agent;
    }

// Setter for name
    
    public void editObject(HashMap<String, String> alienMap) throws InfException {
        ObjectManager.Aliens.updateInstance(alienMap);
        
        this.alien_ID = Integer.parseInt(alienMap.get("Alien_ID"));
        this.registreringsdatum = LocalDate.parse(alienMap.get("Registreringsdatum"));
        this.epost = alienMap.get("Epost");
        this.losenord = alienMap.get("Losenord");
        this.namn = alienMap.get("Namn");
        this.telefon = alienMap.get("Telefon");
        this.plats = ObjectManager.Locations.locationList.get(Integer.valueOf(alienMap.get("Plats")));
        this.ansvarig_Agent = ObjectManager.Agents.agentList.get(Integer.valueOf(alienMap.get("Ansvarig_Agent")));
        
    }
    
    public void setAlienID(int newAlienID) {
        alien_ID = newAlienID;
    }
    
// Getter for name
    
    public int getID() {
        return alien_ID;
    }
    
// Setter for Registrationdate
    
    public void setRegistrationDate(LocalDate newRegistrationDate) {
        registreringsdatum = newRegistrationDate;
    }
    
// Getter for Registrationdate

    public LocalDate getRegistrationDate() {
        return registreringsdatum;
    }
    
    // Setter for alienEpost
    
    public void setAlienEpost(String newAlienEpost) {
        epost = newAlienEpost;  
    }
    
// Setter for alienEpost
    
    public String getEmail() {
        return epost;
    }
    
// Setter for alienPassword
    
    public void setPassword(String newAlienPassword) {
        losenord = newAlienPassword;
    }
    
// Getter for alienPassword

    public String getPassword() {
        return losenord;
    }
    
// Setter for alienName
    
    public void setAlienName(String newAlienName) {
        namn = newAlienName;
    }
    
// Getter for alienName

    public String getName() {
        return namn;
    }
    
    
// Setter for alienPhonenumber

    public void setAlienPhonenumber(String newAlienPhonenumber) {
        telefon = newAlienPhonenumber; 
    }
  
// Getter for alienPhonenumber

    public String getTelephone() {
        return telefon;
    }

// Setter for alienLocation

    public void setAlienLocation(Location newLocation) {
        plats =  newLocation;
    }
    
// Getter for alienLocation

    public Location getLocation() {
        return plats;
    }
    
// Setter for agent responsible for alien

    
    public void setAlienResponsibleAgent(Agent newResponsibleAgent) {
        ansvarig_Agent =  newResponsibleAgent;
    }
    
// Getter for agent responsible for alien

    public Agent getResponsibleAgent() {
        return ansvarig_Agent;
    }
    

    
    
}
        
        
  
 