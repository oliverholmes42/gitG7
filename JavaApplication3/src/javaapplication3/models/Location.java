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
    private int plats_ID;
    private Area finns_I;
    private String benämning;
    public static InfDB db;
    
    public Location(HashMap<String,String> map, Area area) {
        plats_ID = Integer.parseInt(map.get("Plats_ID"));
        this.finns_I = area;
        benämning = map.get("Benamning");
    }
    
    public void setName(String name) {
        benämning = name;
        //ObjectManager.Locations.updateField(plats_ID, "Benamning", benämning);
    }
    
    public String getName(){
        return benämning;
    }
    
    public void setLocationID(int newLocationID){
        //ObjectManager.Locations.updateField(plats_ID, "Plats_ID", newLocationID);
        plats_ID = newLocationID;
    }
    
    public int getId(){
        return plats_ID;
    }
    
    public void setArea(Area newArea){
        finns_I = newArea;
        //ObjectManager.Locations.updateField(plats_ID, "Finns_I", finns_I.getId());
    }
    
    public Area getArea(){
        return finns_I;   
    }
}

