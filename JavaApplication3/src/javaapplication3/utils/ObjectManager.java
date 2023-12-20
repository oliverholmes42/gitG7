/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javaapplication3.models.*;
import oru.inf.*;

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

    public static class Areas{
        public static ArrayList<Area> areaList = new ArrayList<>();

        public static void loadList() throws NumberFormatException, InfException {
            // Clear the list if it contains items
            if (!areaList.isEmpty()) {
                areaList.clear();
            }
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT Omrades_ID FROM omrade");
            for(HashMap<String,String> singleMap : map){
                for (Map.Entry<String, String> entry: singleMap.entrySet()) {
                    Area item = new Area(Integer.parseInt(entry.getValue()));
                    areaList.add(item);
                }
            }
        }
        public static void printList(){
            for(Area item : areaList){
                System.out.println(item.getName());
            }
        }
        public static void offload(){
            areaList.clear();
        }
    }
    
    public static class Locations{
        public static ArrayList<Location> locationList = new ArrayList<>();

        public static void loadList() throws NumberFormatException, InfException {
            // Clear the list if it contains items
            if (!locationList.isEmpty()) {
                locationList.clear();
            }
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT Plats_ID FROM plats");
            for(HashMap<String,String> singleMap : map){
                for (Map.Entry<String, String> entry: singleMap.entrySet()) {
                    Location item = new Location(Integer.parseInt(entry.getValue()));
                    locationList.add(item);
                }
            }
        }
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
        
        }
    }
/*
    public static class Agent {
        public static ArrayList<Agent> agentList = new ArrayList<>();

        public static void LoadList() throws NumberFormatException, InfException {
            // Clear and reload the agentList
        }
    }

    public static class Area {
        public static ArrayList<Area> areaList = new ArrayList<>();

        public static void LoadList() throws NumberFormatException, InfException {
            // Clear and reload the areaList
        }
    }

    public static class Location {
        public static ArrayList<Location> locationList = new ArrayList<>();

        public static void LoadList() throws NumberFormatException, InfException {
            // Clear and reload the locationList
        }
    }

    public static class Utilities {
        public static ArrayList<Utilities> utilitiesList = new ArrayList<>();

        public static void LoadList() throws NumberFormatException, InfException {
            // Clear and reload the utilitiesList
        }
    }*/
}
