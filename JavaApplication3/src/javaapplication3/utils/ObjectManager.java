/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import javaapplication3.models.*;
import oru.inf.*;
import oru.inf.InfException;

/**
 *
 * @author mopaj
 */
public class ObjectManager {

    public static InfDB db = DatabaseConnection.getInstance();
    
    public static void offloadAll() {
        Class<?>[] innerClasses = ObjectManager.class.getDeclaredClasses();

        for (Class<?> innerClass : innerClasses) {
            try {
                Method offloadMethod = innerClass.getDeclaredMethod("offload");
                offloadMethod.setAccessible(true); // In case the method is not public
                offloadMethod.invoke(null); // Invoke the static method
            } catch (NoSuchMethodException e) {
                System.out.println(innerClass.getName() + " does not have an offload method.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static class Locations {
        public static HashMap<Integer, Location> locationList = new HashMap<>();

        public static void loadList() throws NumberFormatException, InfException {
            // Clear the list if it contains items
            if (!locationList.isEmpty()) {
                locationList.clear();
            }
            Areas.loadList();
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * from plats");
            for(HashMap<String,String> singleMap : map){
                int id1 = Integer.parseInt(singleMap.get("Plats_ID"));
                int id2 = Integer.parseInt(singleMap.get("Finns_I"));
                Location location = new Location(singleMap,Areas.areaList.get(id2));
                locationList.put(id1, location);
                
            }
        }
        
        public static void updateField(int id, String column, String newValue){
            try{
                String updateQuery = "UPDATE plats SET " + column + " = '" + newValue + "' WHERE Plats_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void updateField(int id, String column, int newValue){
            try{
                String updateQuery = "UPDATE plats SET " + column + " = " + newValue + " WHERE Plats_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static class Aliens{
        public static HashMap<Integer, Alien> alienList = new HashMap<>();

        public static void loadAlienList() throws NumberFormatException, InfException {
            // Clear the list if it contains items
            if (!alienList.isEmpty()) {
                alienList.clear();
            }
            
            Locations.loadList();
            Agents.LoadList();
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * FROM alien");
            for(HashMap<String,String> singleMap : map){
                int id = Integer.parseInt(singleMap.get("Alien_ID"));
                int platsID = Integer.parseInt(singleMap.get("Plats"));
                int agentID = Integer.parseInt(singleMap.get("Ansvarig_Agent"));
                Alien alien = new Alien(singleMap,Locations.locationList.get(platsID), Agents.agentList.get(agentID));
                alienList.put(id, alien);
            }
        }
        
        public static void updateField(int id, String column, String newValue){
            try{
                String updateQuery = "UPDATE alien SET " + column + " = '" + newValue + "' WHERE Alien_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void updateField(int id, String column, int newValue){
            try{
                String updateQuery = "UPDATE alien SET " + column + " = " + newValue + " WHERE Alien_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
    }

    public static class Agents {
        public static HashMap<Integer, Agent> agentList = new HashMap<>();

        public static void LoadList() throws NumberFormatException, InfException {
            if(!agentList.isEmpty()) {agentList.clear();}
            
            if(Areas.areaList.isEmpty()) {Areas.loadList();}
            
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * FROM agent"); 
            for(HashMap<String,String> singleMap : map){
                int id = Integer.parseInt(singleMap.get("Agent_ID"));
                int areaID = Integer.parseInt(singleMap.get("Omrade"));
                Agent agent = new Agent(singleMap,Areas.areaList.get(areaID));
                agentList.put(id,agent);
            }
        }
        
        public static void updateField(int id, String column, String newValue){
            try{
                String updateQuery = "UPDATE agent SET " + column + " = '" + newValue + "' WHERE Agent_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void updateField(int id, String column, int newValue){
            try{
                String updateQuery = "UPDATE agent SET " + column + " = " + newValue + " WHERE Agent_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void updateField(int id, String column, LocalDate newValue){
            try{
                String updateQuery = "UPDATE agent SET " + column + " = '" + newValue + "' WHERE Agent_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static class Areas {
        public static HashMap<Integer, Area> areaList = new HashMap<>();

        public static void loadList() throws NumberFormatException, InfException {
            if(!areaList.isEmpty()) {areaList.clear();}
            
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * FROM omrade");
            for(HashMap<String,String> singleMap : map){
                int id = Integer.parseInt(singleMap.get("Omrades_ID"));
                Area area = new Area(singleMap);
                areaList.put(id,area);
            }
        }
    }

    public static class UtilitiesHandler {
        public static HashMap<Integer, Utilities> utilitiesList = new HashMap<>();

        public static void loadList() throws NumberFormatException, InfException {
            if(!utilitiesList.isEmpty()) {utilitiesList.clear();}
            
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * FROM utrustning");
            for(HashMap<String,String> singleMap : map){
                int id = Integer.parseInt(singleMap.get("Utrustnings_ID"));
                Utilities util = new Utilities(singleMap);
                utilitiesList.put(id, util);
            }
        }
    }
}
