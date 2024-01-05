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
    String kontorsbeteckning;
    
    public KontorsChef(HashMap<String, String> agentMap, Area area, String officeName){
        super(agentMap,area);
        this.kontorsbeteckning = officeName;
    }
    
    public KontorsChef(){
        super();
    }
    
    public void cloneObject(KontorsChef other) {
        super.cloneObject(other);
        this.kontorsbeteckning = other.kontorsbeteckning;
    }
    
    public void setOfficeName(String name){
        kontorsbeteckning = name;
    }
    
    public String getOfficeName(){
        return kontorsbeteckning;
    }
}
