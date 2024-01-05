/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.agentSubClass;

import java.util.HashMap;
import javaapplication3.models.Agent;
import javaapplication3.models.Area;
import javaapplication3.models.alienSubclasses.Squid;

/**
 *
 * @author mopaj
 */
public class Områdeschef extends Agent {
    private Area omrade;
    
    public Områdeschef(HashMap<String, String> agentMap, Area area, Area controlArea){
        super(agentMap,area);
        this.omrade = controlArea;
        
    }
    
     public Områdeschef(){
        super();
    }
    
    public void cloneObject(Områdeschef other) {
        super.cloneObject(other);
        this.omrade = other.omrade;
    }
    
    public void setControlArea(Area area){
        omrade = area;
    }
    
    public Area getControlArea(){
        return omrade;
    }
}
