/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.util.HashMap;

/**
 *
 * @author vilso
 */
public class Alien {
    String alien_name;
    int alien_ID;
    String alien_gender;
    String alien_race;
    HashMap<Double, Double> alien_location = new HashMap<>(); 
    
    public Alien(String alien_name, int alien_ID, String alien_gender, String alien_race){
        this.alien_name = alien_name;
        this.alien_ID = alien_ID;
        this.alien_gender = alien_gender;
        this.alien_race = alien_race;
    }
}
