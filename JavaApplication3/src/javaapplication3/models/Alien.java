/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.time.LocalDate;
import java.util.HashMap;
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
    
    public void setAlienID(int alienID) {
        this.alienID = alienID;
    }
    
// Getter for name
    
    public int getAlienID() {
        return alienID;
    }
    
// Setter for Registrationdate
    
    public void setRegistrationDate(LocalDate RegistrationDate) {
        this.RegistrationDate = RegistrationDate;
    }
    
// Getter for Registrationdate

    public LocalDate getRegistrationDate() {
        return RegistrationDate;
    }
    
    // Setter for alienEpost
    
    public void setAlienEpost(String alienEpost) {
        try{
        String query = "UPDATE alien SET Epost = '" + alienEpost + "' WHERE Alien_ID = " + alienID;
        db.update(query);
        this.alienEpost = alienEpost;
       }
        catch(InfException e){
       System.out.println(e.getMessage());
       } 
    }
    
// Setter for alienEpost
    
    public String getAlienEpost() {
        return alienEpost;
    }
    
// Setter for alienPassword
    
    public void setAlienPassword(String alienPassword) {
        
    }
    
// Getter for alienPassword

    public String getAlienPassword() {
        return alienPassword;
    }
    
// Setter for alienName
    
    public void setAlienName(String alienName) {
        try{
        String query = "UPDATE alien SET Namn = '" + alienName + "' WHERE Alien_ID = " + alienID;
        db.update(query);
        this.alienName = alienName;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }
    }
    
// Getter for alienName

    public String getAlienName() {
        return alienName;
    }
    
    
// Setter for alienPhonenumber

    public void setAlienPhonenumber(String alienPhonenumber) {
        try{
        String query = "UPDATE alien SET Telefon = '" + alienPhonenumber + "' WHERE Alien_ID = " + alienID;
        db.update(query);
        this.alienPhonenumber = alienPhonenumber;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       } 
    }
  
// Getter for alienPhonenumber

    public String getAlienPhonenumber() {
        return alienPhonenumber;
    }

// Setter for alienLocation

    public void setAlienLocation(Location location) {
        this.location =  location;
    }
    
// Getter for alienLocation

    public Location getAlienLocation() {
        return location;
    }
    
// Setter for agent responsible for alien

    
    public void setAlienResponslbleAgent(Agent responsibleAgent) {
        this.responsibleAgent =  responsibleAgent;
    }
    
// Getter for agent responsible for alien

    public Agent getResponsibleAgent() {
        return responsibleAgent;
    }
    
    
}
        
        
  
