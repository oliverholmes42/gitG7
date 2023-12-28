/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import javaapplication3.models.*;
import javaapplication3.models.alienSubclasses.Boglodite;
import javaapplication3.models.alienSubclasses.Squid;
import javaapplication3.models.alienSubclasses.Worm;
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
                Method offloadMethod = innerClass.getDeclaredMethod("offLoad");
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
        
        public static void offLoad(){
        locationList.clear();
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
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT a.*, w.Langd, b.Antal_Boogies, s.Antal_Armar FROM Alien a LEFT JOIN Worm w ON a.Alien_ID = w.Alien_ID LEFT JOIN Boglodite b ON a.Alien_ID = b.Alien_ID LEFT JOIN Squid s ON a.Alien_ID = s.Alien_ID");
            for (HashMap<String, String> singleMap : map) {
            int id = Integer.parseInt(singleMap.get("Alien_ID"));
            int platsID = Integer.parseInt(singleMap.get("Plats"));
            int agentID = Integer.parseInt(singleMap.get("Ansvarig_Agent"));

            Alien alien;
            if (singleMap.get("Langd")!=null) {
                // Create a Worm instance
                alien = new Worm(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            } else if (singleMap.get("Antal_Boogies")!=null) {
                // Create a Boglodite instance
                alien = new Boglodite(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            } else if (singleMap.get("Antal_Armar")!=null) {
                // Create a Squid instance
                alien = new Squid(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            } else {
                // Create a generic Alien instance
                alien = new Alien(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            }

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
       
        public static void updateInstance(HashMap<String, String> map) throws InfException {
            // Build and execute the main update query for the 'alien' table
            HashMap<String, String> alienMap = new HashMap<>(map);
            alienMap.remove("Antal_Boogies"); // Remove special key for alien table update
            alienMap.remove("Antal_Armar");   // Similarly for other special keys
            alienMap.remove("Langd");

            String alienQuery = buildUpdateQuery("alien", alienMap);
            db.update(alienQuery);

        }

        public static void updateSubClass(HashMap<String, String> map, String oldSpecies, String newSpecies) throws InfException {
            if(oldSpecies.equals(newSpecies)){
                if (map.containsKey("Antal_Boogies")) {
                    HashMap<String, String> bogloditeMap = new HashMap<>();
                    bogloditeMap.put("Alien_ID", map.get("Alien_ID"));
                    bogloditeMap.put("Antal_Boogies", map.get("Antal_Boogies"));

                    String bogloditeQuery = buildUpdateQuery("Boglodite", bogloditeMap);
                    db.update(bogloditeQuery);
                }

                // Update 'Squid' table if "Antal_Armar" is present
                if (map.containsKey("Antal_Armar")) {
                    HashMap<String, String> squidMap = new HashMap<>();
                    squidMap.put("Alien_ID", map.get("Alien_ID"));
                    squidMap.put("Antal_Armar", map.get("Antal_Armar"));

                    String squidQuery = buildUpdateQuery("Squid", squidMap);
                    db.update(squidQuery);
                }

                // Update 'Worm' table if "Langd" is present
                if (map.containsKey("Langd")) {
                    HashMap<String, String> wormMap = new HashMap<>();
                    wormMap.put("Alien_ID", map.get("Alien_ID"));
                    wormMap.put("Langd", map.get("Langd"));

                    String wormQuery = buildUpdateQuery("Worm", wormMap);
                    db.update(wormQuery);
                }   
            } else {
                String tableName = newSpecies; // Assuming 'two' is a variable holding the table name
                String alienID = map.get("Alien_ID");
                String value = map.get("value");

                // Assuming 'alienID' and 'value' are strings. If they are numeric, remove the single quotes around the placeholders.
                String sql = "INSERT INTO " + tableName.toLowerCase() + " VALUES (" + alienID + ", " + value + ");";

                db.insert(sql);
                
                sql = "Delete from " + oldSpecies.toLowerCase() + " where Alien_ID = "+alienID;
                db.delete(sql);

                alienList.put(Integer.parseInt(alienID),setNewInstance(map,newSpecies));
            }
        }

        private static Alien setNewInstance(HashMap<String,String> map,String two) {
            Location location = Locations.locationList.get(Integer.parseInt(map.get("Plats")));
            Agent agent = Agents.agentList.get(Integer.parseInt(map.get("Ansvarig_Agent")));
            switch (two) {
                case "Worm":
                    return new Worm(map, location, agent);
                case "Boglodite":
                    return new Boglodite(map, location, agent);
                case "Squid":
                    return new Squid(map, location, agent);
                default:
                    return new Alien(map, location, agent);
            }   }

        public static String buildUpdateQuery(String tableName, HashMap<String, String> data) {
            String keyColumn = "Alien_ID";
            String idValue = data.get(keyColumn); // Get the ID value

            StringBuilder queryBuilder = new StringBuilder("UPDATE ");
            queryBuilder.append(tableName).append(" SET ");

            StringJoiner setJoiner = new StringJoiner(", ");

            for (Map.Entry<String, String> entry : data.entrySet()) {
                String column = entry.getKey();
                String value = entry.getValue();

                // Skip the key column and special keys in the SET clause
                if (!column.equals(keyColumn)) {
                    setJoiner.add(column + " = '" + value + "'");
                }
            }

            queryBuilder.append(setJoiner.toString());
            queryBuilder.append(" WHERE ").append(keyColumn).append(" = '").append(idValue).append("'");

            return queryBuilder.toString();
        }


                public static Alien getAlien(int id) {
                    return alienList.get(id);
                }

                public static void offLoad(){
                alienList.clear();
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
        
        public static void offLoad(){
        agentList.clear();
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
        
        public static void updateField(int id, String column, String newValue){
            try{
                String updateQuery = "UPDATE omrade SET " + column + " = '" + newValue + "' WHERE Omrades_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void updateField(int id, String column, int newValue){
            try{
                String updateQuery = "UPDATE omrade SET " + column + " = " + newValue + " WHERE Omrades_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void offLoad(){
        areaList.clear();
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
        
        public static void offLoad(){
        utilitiesList.clear();
        }
    }
}
