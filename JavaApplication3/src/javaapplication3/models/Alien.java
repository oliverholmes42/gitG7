/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.utils.ObjectManager;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author aiham
 */
public class Alien {
    private int alienID;
    private LocalDate RegistrationDate;
    private String alienEpost;
    private String alienPassword;
    private String alienName;
    private String alienPhonenumber;
    private Location location;
    private Agent responsibleAgent;
    public static InfDB db;


    public Alien(HashMap<String, String> alienMap, Location location, Agent agent){
        
        this.alienID = Integer.parseInt(alienMap.get("Alien_ID"));
        this.RegistrationDate = LocalDate.parse(alienMap.get("Registreringsdatum"));
        this.alienEpost = alienMap.get("Epost");
        this.alienPassword = alienMap.get("Losenord");
        this.alienName = alienMap.get("Namn");
        this.alienPhonenumber = alienMap.get("Telefon");
        this.location = location;
        responsibleAgent = agent;
        
        }

// Setter for name
    
    public void editObject(HashMap<String, String> alienMap) {
        try {
            ObjectManager.Aliens.updateInstance(alienMap);
            
            this.alienID = Integer.parseInt(alienMap.get("Alien_ID"));
            this.RegistrationDate = LocalDate.parse(alienMap.get("Registreringsdatum"));
            this.alienEpost = alienMap.get("Epost");
            this.alienPassword = alienMap.get("Losenord");
            this.alienName = alienMap.get("Namn");
            this.alienPhonenumber = alienMap.get("Telefon");
            this.location = ObjectManager.Locations.locationList.get(Integer.valueOf(alienMap.get("Plats")));
            this.responsibleAgent = ObjectManager.Agents.agentList.get(Integer.valueOf(alienMap.get("Ansvarig_Agent")));
            
        } catch (InfException ex) {
            Logger.getLogger(Alien.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setAlienID(int newAlienID) {
        ObjectManager.Aliens.updateField(alienID, "Alien_ID", newAlienID);
        alienID = newAlienID;
    }
    
// Getter for name
    
    public int getAlienID() {
        return alienID;
    }
    
// Setter for Registrationdate
    
    public void setRegistrationDate(LocalDate newRegistrationDate) {
        ObjectManager.Aliens.updateField(alienID,"Registreringsdatum" , newRegistrationDate.toString());
        RegistrationDate = newRegistrationDate;
    }
    
// Getter for Registrationdate

    public LocalDate getRegistrationDate() {
        return RegistrationDate;
    }
    
    // Setter for alienEpost
    
    public void setAlienEpost(String newAlienEpost) {
        ObjectManager.Aliens.updateField(alienID, "Epost", newAlienEpost);
        alienEpost = newAlienEpost;  
    }
    
// Setter for alienEpost
    
    public String getAlienEpost() {
        return alienEpost;
    }
    
// Setter for alienPassword
    
    public void setAlienPassword(String newAlienPassword) {
        ObjectManager.Aliens.updateField(alienID, "Losenord", newAlienPassword);
        alienPassword = newAlienPassword;
    }
    
// Getter for alienPassword

    public String getAlienPassword() {
        return alienPassword;
    }
    
// Setter for alienName
    
    public void setAlienName(String newAlienName) {
        ObjectManager.Aliens.updateField(alienID, "Namn", newAlienName);
        alienName = newAlienName;
    }
    
// Getter for alienName

    public String getAlienName() {
        return alienName;
    }
    
    
// Setter for alienPhonenumber

    public void setAlienPhonenumber(String newAlienPhonenumber) {
        ObjectManager.Aliens.updateField(alienID, "Telefon", newAlienPhonenumber);
        alienPhonenumber = newAlienPhonenumber; 
    }
  
// Getter for alienPhonenumber

    public String getAlienPhonenumber() {
        return alienPhonenumber;
    }

// Setter for alienLocation

    public void setAlienLocation(Location newLocation) {
        ObjectManager.Aliens.updateField(alienID, "Plats", newLocation.getId());
        location =  newLocation;
    }
    
// Getter for alienLocation

    public Location getAlienLocation() {
        return location;
    }
    
// Setter for agent responsible for alien

    
    public void setAlienResponsibleAgent(Agent newResponsibleAgent) {
        ObjectManager.Aliens.updateField(alienID, "Ansvarig_Agent", newResponsibleAgent.getId());
        responsibleAgent =  newResponsibleAgent;
    }
    
// Getter for agent responsible for alien

    public Agent getResponsibleAgent() {
        return responsibleAgent;
    }
    
    //public Location getLocation() {
    //return location;
    //}
    
    
}
        
        
  
