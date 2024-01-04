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
public class KontorsChef extends Agent {
    String officeName;
    
    public KontorsChef(HashMap<String, String> agentMap, Area area, String officeName){
        super(agentMap,area);
        this.officeName = officeName;
    }
    
    public void setOfficeName(String name){
        officeName = name;
    }
    
    public String getOfficeName(){
        return officeName;
    }
}
