/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;
import java.util.HashMap;
import oru.inf.InfDB;

/**
 *
 * @author aiham, albin,oliver, vilson
 */
public class Location {
    private int plats_ID;
    private Area finns_I;
    private String benamning;
    public static InfDB db;
    
    public Location(HashMap<String,String> map, Area area) {
        plats_ID = Integer.parseInt(map.get("Plats_ID"));
        this.finns_I = area;
        benamning = map.get("Benamning");
    }
    
    public Location(){
        plats_ID = 0;
        finns_I = null;
        benamning = null;
    }
    
    public void cloneObject(Location location){
        this.plats_ID = location.plats_ID;
        this.finns_I = location.finns_I;
        this.benamning = location.benamning;
    }
    
    public void setName(String name) {
        benamning = name;
       
    }
    
    public String getName(){
        return benamning;
    }
    
    public void setLocationID(int newLocationID){
        plats_ID = newLocationID;
    }
    
    public int getId(){
        return plats_ID;
    }
    
    public void setArea(Area newArea){
        finns_I = newArea;
    }
    
    public Area getArea(){
        return finns_I;   
    }
}

