/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.agentSubClass;

import java.util.HashMap;
import javaapplication3.models.Agent;
import javaapplication3.models.Area;

/* Denna fil hanterar subklassen Områdeschef som kommer ifrån superklassen Agent. I denna subklass klonas redan existerande objekt för att sedan
 * kunna ersättas med ett redigerat objekt av Områdeschef. */
public class Områdeschef extends Agent {
    private Area omrade;
    
    /* Konstruktorn tar in en HashMap, ett area-objekt och en sträng som parameter för skapa ett objekt, samt pekar på 
     * vart informationen skall lagras. */
    public Områdeschef(HashMap<String, String> agentMap, Area area, Area controlArea){
        super(agentMap,area); //Anropar superklassens konstruktor
        this.omrade = controlArea;
        
    }
    
    // Denna metod skapar ett tomt objekt.
     public Områdeschef(){
        super();
    }
    
     // Denna metod klonar redan befintligt objekt, för att sedan kunna ersätta med ett nytt redigerat objekt.
    public void cloneObject(Områdeschef other) {
        super.cloneObject(other);
        this.omrade = other.omrade;
    }
    
    // Setter för område.
    public void setControlArea(Area area){
        omrade = area;
    }
    
    //Getter för område.
    public Area getControlArea(){
        return omrade;
    }
}
