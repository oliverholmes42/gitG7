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
public class Kommunikation extends Utilities {
    private String overforingsteknik;

    public Kommunikation(HashMap<String, String> utilitiesMap) {  
        super(utilitiesMap);
        if (!utilitiesMap.containsKey("Value")) {
            overforingsteknik = utilitiesMap.get("Overforingsteknik");
        } else {
            overforingsteknik = utilitiesMap.get("Value");
        }
    }

    public String getTransmissionTech() {
        return overforingsteknik;
    }

    public void setTransmissionTech(String overforingsteknik) {
        this.overforingsteknik = overforingsteknik;
    }
}

