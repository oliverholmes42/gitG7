/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.utilitySubClasses;

import java.util.HashMap;
import javaapplication3.models.Utilities;

/* Denna klass hanterar subklassen Vapen som tillhör superklassen Utrustning. I denna klass kategoriseras utrustning inom vapen
 * för att senare kunna bestämma tillhörigheten för ett nytt utrustningsobjekt som skapas. */
public class Vapen extends Utilities {
    private int kaliber;
    
    public Vapen(HashMap<String, String> utilitiesMap){  
        super(utilitiesMap); // Anropar superklassens konstruktor
        
        // För att se om värdet för "Kaliber" kommer från databasen eller från registrerings-HashMapen sker denna kontroll:
        if(!utilitiesMap.containsKey("Value")){
            kaliber = Integer.parseInt(utilitiesMap.get("Kaliber"));
        }
        else {
            kaliber = Integer.parseInt(utilitiesMap.get("Value"));
        }
    }
    
    // Getter för kaliber
    public int getCaliber(){
        return kaliber;
    }
    
    // Setter för kaliber
    public void setCaliber(int kaliber){
        this.kaliber = kaliber;
    }
}
