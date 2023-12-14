/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.time.LocalDate;

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



    public Alien(int alienID, LocalDate RegistrationDate, String alienEpost, 
            String alienPassword, String alienName, String alienPhonenumber, 
            Location location, Agent responsibleAgent){
        
        this.alienID = alienID;
        this.RegistrationDate = RegistrationDate;
        this.alienEpost = alienEpost;
        this.alienPassword = alienPassword;
        this.alienName = alienName;
        this.alienPhonenumber = alienPhonenumber;
        this.location = location;
        this.responsibleAgent = responsibleAgent;
        
        }

// Setter for name
    
    public void setalienID(int alienID) {
        this.alienID = alienID;
    }
    
// Getter for name
    
    public int getalienID() {
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
    
    public void setalienEpost(String alienEpost) {
        this.alienEpost = alienEpost;
    }
    
// Setter for alienEpost
    
    public String getalienEpost() {
        return alienEpost;
    }
    
// Setter for alienPassword
    
    public void setalienPassword(String alienPassword) {
        this.alienPassword = alienPassword;
    }
    
// Getter for alienPassword

    public String getalienPassword() {
        return alienPassword;
    }
    
// Setter for alienName
    
    public void setalienName(String alienName) {
        this.alienName = alienName;
    }
    
// Getter for alienName

    public String getalienName() {
        return alienName;
    }
    
    
// Setter for alienPhonenumber

    public void setalienPhonenumber(String alienPhonenumber) {
        this.alienPhonenumber = alienPhonenumber;
    }
  
// Getter for alienPhonenumber

    public String getalienPhonenumber() {
        return alienPhonenumber;
    }

// Setter for alienLocation

    public void setalienLocation(Location location) {
        this.location =  location;
    }
    
// Getter for alienLocation

    public Location getalienLocation() {
        return location;
    }
    
// Setter for agent responsible for alien

    
    public void setalienResponslbleAgent(Agent responsibleAgent) {
        this.responsibleAgent =  responsibleAgent;
    }
    
// Getter for agent responsible for alien

    public Agent getresponsibleAgent() {
        return responsibleAgent;
    }
    
    
}
        
        
  
