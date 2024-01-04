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
public class Teknik extends Utilities {
    private String kraftkalla;
    
    public Teknik(HashMap<String, String> utilitiesMap){  
        super(utilitiesMap);
        if(!utilitiesMap.containsKey("Value")){
            kraftkalla = utilitiesMap.get("Kraftkalla");
        }
        else {
            kraftkalla= utilitiesMap.get("Value");
        }
    }
    
    public String getPowersource(){
        return kraftkalla;
    }
    
    public void setPowersource(String kraftkalla){
        this.kraftkalla = kraftkalla;
    }
    
    
    
}
