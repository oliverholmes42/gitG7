/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models.agentSubClass;

import java.util.HashMap;
import javaapplication3.models.Agent;
import javaapplication3.models.Area;

/* Denna fil hanterar subklassen fältagent för att sedan kunna kategorisera registrerade agenter under kategorin "fältagent".
 * Fältagent extends Agent innebär att superklassen till denna klass är just Agent.*/

public class Fältagent extends Agent {
    /* Konstruktorn tar in en HashMap och ett area-objekt som parameter för att kunna skapa objekt, samt pekar på 
     * vart informationen skall lagras. Fältagent saknar attribut och är lite svårare att hantera gentemot andra subklasser,
     * och denna lösning fixar det problemet. */
    public Fältagent(HashMap<String, String> agentMap, Area area){
        super(agentMap,area); // Anropar superklassens konstruktor.
    }
    
    /* Samma gäller i denna konstruktor där toma objekt ska skapas.*/
    public Fältagent(){
        super();
    }
    
    /* Denna metod klonar redan existerande objekt, där vi senare kan redigera attributen och värden för att sedan ersätta originalet. */
    public void cloneObject(Fältagent other){
        super.cloneObject(other);
    }
}
