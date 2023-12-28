/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;

import java.util.HashMap;
import javaapplication3.utils.ObjectManager;
import oru.inf.InfDB;

/**
 *
 * @author aiham, albin,oliver, vilson
 */
public class Location {
    private int locationID;
    private Area area;
    private String locationName;
    public static InfDB db;
    
    public Location(HashMap<String,String> map, Area area) {
        locationID = Integer.parseInt(map.get("Plats_ID"));
        this.area = area;
        locationName = map.get("Benamning");
    }
    
    public void setName(String name) {
        locationName = name;
        ObjectManager.Locations.updateField(locationID, "Benamning", locationName);
    }
    
    public String getName(){
        return locationName;
    }
    
    public void setLocationID(int newLocationID){
        ObjectManager.Locations.updateField(locationID, "Plats_ID", newLocationID);
        locationID = newLocationID;
    }
    
    public int getId(){
        return locationID;
    }
    
    public void setArea(Area newArea){
        area = newArea;
        ObjectManager.Locations.updateField(locationID, "Finns_I", area.getAreaID());
    }
    
    public Area getArea(){
        return area;   
    }
}

