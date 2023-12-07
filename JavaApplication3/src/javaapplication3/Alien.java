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
    private String alien_name;
    private int alien_ID;
    private String alien_gender;
    private String alien_race;
    private HashMap<Double, Double> alien_location;

    public Alien(String alien_name, int alien_ID, String alien_gender, String alien_race){
        this.alien_name = alien_name;
        this.alien_ID = alien_ID;
        this.alien_gender = alien_gender;
        this.alien_race = alien_race;
        this.alien_location = new HashMap<>();
    }
    
    public void setName(String alien_name){
       this.alien_name = alien_name;
    }
    
    public String getName(){
    return alien_name;
    }
    
    public void setGender(String alien_gender){
    this.alien_gender = alien_gender;
    }
    
    public String getGender(){
    return alien_gender;
    }
    
    public void setID(int Alien_ID){
        this.alien_ID = alien_ID;
    }
    
    public int getAlienID(){
    return alien_ID;
    }
    
    public void setRace(String alien_race){
    this.alien_race = alien_race;
    }
    
    public String getRace(){
    return alien_race;
    }
    
    public void setLocation(double x_coordinates, double y_coordinates){
        this.alien_location = alien_location;
    }
    
    public HashMap<Double, Double> getLocation(){
        return alien_location;
    }
}
