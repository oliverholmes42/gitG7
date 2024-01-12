/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.utilitySubClasses;

import java.util.HashMap;
import javaapplication3.models.Utilities;

/* Denna klass hanterar subklassen Teknik som tillhör superklassen Utrustning. I denna klass kategoriseras utrustning inom teknik
 * för att senare kunna bestämma tillhörigheten för ett nytt utrustningsobjekt som skapas. */
public class Teknik extends Utilities {
    private String kraftkalla;
    
    public Teknik(HashMap<String, String> utilitiesMap){  
        super(utilitiesMap); // Anropar superklassens konstruktor.
        
        // För att se om värdet för "Kraftkälla" kommer från databasen eller från registrerings-HashMapen sker denna kontroll:
        if(!utilitiesMap.containsKey("Value")){
            kraftkalla = utilitiesMap.get("Kraftkalla");
        }
        else {
            kraftkalla= utilitiesMap.get("Value");
        }
    }
    
    // Getter för kraftkälla
    public String getPowersource(){
        return kraftkalla;
    }
    
    // Setter för kraftkälla
    public void setPowersource(String kraftkalla){
        this.kraftkalla = kraftkalla;
    }
    
    
    
}
