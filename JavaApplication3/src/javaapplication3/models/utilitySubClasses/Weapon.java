/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.utilitySubClasses;

import java.util.HashMap;
import javaapplication3.models.Utilities;

/**
 *
 * @author mopaj
 */
public class Weapon extends Utilities {
    private int kaliber;
    
    public Weapon(HashMap<String, String> utilitiesMap){  
        super(utilitiesMap);
        if(!utilitiesMap.containsKey("Value")){
            kaliber = Integer.parseInt(utilitiesMap.get("Kaliber"));
        }
        else {
            kaliber = Integer.parseInt(utilitiesMap.get("Value"));
        }
    }
    
    public int getCaliber(){
        return kaliber;
    }
    
    public void setCaliber(int kaliber){
        this.kaliber = kaliber;
    }
}
