/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.agentSubClass;

import java.util.HashMap;
import javaapplication3.models.Agent;
import javaapplication3.models.Area;

/**
 *
 * @author mopaj
 */
public class Områdeschef extends Agent {
    private Area controlArea;
    
    public Områdeschef(HashMap<String, String> agentMap, Area area, Area controlArea){
        super(agentMap,area);
        this.controlArea = controlArea;
        
    }
    
    public void setControlArea(Area area){
        controlArea = area;
    }
    
    public Area getControlArea(){
        return controlArea;
    }
}
