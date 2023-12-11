/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.time.LocalDate;

/**
 *
 * @author aiham
 */
public class Alien {
    private int alien_ID;
    private LocalDate Registrationdate;
    private String alien_epost;
    private String alien_password;
    private String alien_name;
    private String alien_phonenumber;
    private Location location;
    private Agent responsible_agent;



    public Alien(int alien_ID, LocalDate Registrationdate, String alien_epost, 
            String alien_password, String alien_name, String alien_phonenumber, 
            Location location, Agent responsible_agent){
        
        this.alien_ID = alien_ID;
        this.Registrationdate = Registrationdate;
        this.alien_epost = alien_epost;
        this.alien_password = alien_password;
        this.alien_name = alien_name;
        this.alien_phonenumber = alien_phonenumber;
        this.location = location;
        this.responsible_agent = responsible_agent;
        
        }

// Setter for name
    
    public void setalienID(int alien_ID) {
        this.alien_ID = alien_ID;
    }
    
// Getter for name
    
    public int getalienID() {
        return alien_ID;
    }
    
// Setter for Registrationdate
    
    public void setRegistrationDate(LocalDate Registrationdate) {
        this.Registrationdate = Registrationdate;
    }
    
// Getter for Registrationdate

    public LocalDate getRegistrationDate() {
        return Registrationdate;
    }
    
    // Setter for alienEpost
    
    public void setalienEpost(String alien_epost) {
        this.alien_epost = alien_epost;
    }
    
// Setter for alienEpost
    
    public String getalienEpost() {
        return alien_epost;
    }
    
// Setter for alienPassword
    
    public void setalienPassword(String alien_password) {
        this.alien_password = alien_password;
    }
    
// Getter for alienPassword

    public String getalienPassword() {
        return alien_password;
    }
    
// Setter for alienName
    
    public void setalienName(String alien_name) {
        this.alien_name = alien_name;
    }
    
// Getter for alienName

    public String getalienName() {
        return alien_name;
    }
    
    
// Setter for alienPhonenumber

    public void setalienPhonenumber(String alien_phonenumber) {
        this.alien_phonenumber = alien_phonenumber;
    }
  
// Getter for alienPhonenumber

    public String getalienPhonenumber() {
        return alien_phonenumber;
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

    
    public void setalienResponslbleAgent(Agent responsible_agent) {
        this.responsible_agent =  responsible_agent;
    }
    
// Getter for agent responsible for alien

    public Agent getresponsible_agent() {
        return responsible_agent;
    }
    
    
}
        
        
  
