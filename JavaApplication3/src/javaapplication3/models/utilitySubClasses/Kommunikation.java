/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.utilitySubClasses;

import java.util.HashMap;
import javaapplication3.models.Utilities;

/* Denna klass hanterar subklassen Kommunikation som tillhör superklassen Utrustning. I denna klass kategoriseras utrustning inom kommunikation
 * för att senare kunna bestämma tillhörigheten för ett nytt utrustningsobjekt som skapas. */
public class Kommunikation extends Utilities {
    private String overforingsteknik;

    public Kommunikation(HashMap<String, String> utilitiesMap) {  
        super(utilitiesMap); // Anropar superklassens kontruktor
        
        // För att se om värdet för "Överföringsteknik" kommer från databasen eller från registrerings-HashMapen sker denna kontroll:
        if (!utilitiesMap.containsKey("Value")) {
            overforingsteknik = utilitiesMap.get("Overforingsteknik");
        } else {
            overforingsteknik = utilitiesMap.get("Value");
        }
    }
    
    // Getter för ööverföringsteknik
    public String getTransmissionTech() {
        return overforingsteknik;
    }
    
    // Setter för överföringsteknik
    public void setTransmissionTech(String overforingsteknik) {
        this.overforingsteknik = overforingsteknik;
    }
}

