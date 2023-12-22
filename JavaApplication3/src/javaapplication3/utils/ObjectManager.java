/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.lang.reflect.Method;
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
    
    public static class Locations{
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
                System.out.println(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        /*
        public static void printList(){
            for(Location item : locationList){
                System.out.println(item.getName());
            }
        }
        public static void offload(){
            locationList.clear();
        }
        public static Location loadInstance(int ID) {
            for (Location loc : locationList) {
                if (loc.getLocationID() == ID) {
                    return loc;  // Return existing instance
                }
            }
           
            Location newLocation = new Location(ID);
            locationList.add(newLocation);
            return newLocation;
        
        }*/
    }
    /*
    public static class Aliens{
        public static ArrayList<Alien> alienList = new ArrayList<>();

        public static void loadAlienList() throws NumberFormatException, InfException {
            // Clear the list if it contains items
            if (!alienList.isEmpty()) {
                alienList.clear();
            }
            
            Locations.loadList();
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * FROM alien");
            for(HashMap<String,String> item : map){
                //Location location = Locations.locationList.get("")
                //Alien alien = new Alien(item,Locations.locationList);
            }
        }
    }*/

    public static class Agent {
        public static ArrayList<Agent> agentList = new ArrayList<>();

        public static void LoadList() throws NumberFormatException, InfException {
            // Clear and reload the agentList
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

    public static class Utilities {
        public static ArrayList<Utilities> utilitiesList = new ArrayList<>();

        public static void LoadList() throws NumberFormatException, InfException {
            // Clear and reload the utilitiesList
        }
    }
}
