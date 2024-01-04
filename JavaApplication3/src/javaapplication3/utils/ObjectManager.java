/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.models.*;
import javaapplication3.models.agentSubClass.Faltagent;
import javaapplication3.models.agentSubClass.KontorsChef;
import javaapplication3.models.agentSubClass.OmradesChef;
import javaapplication3.models.alienSubclasses.Boglodite;
import javaapplication3.models.alienSubclasses.Squid;
import javaapplication3.models.alienSubclasses.Worm;
import javaapplication3.models.utilitySubClasses.Kommunikation;
import javaapplication3.models.utilitySubClasses.Teknik;
import javaapplication3.models.utilitySubClasses.Vapen;
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
    
    public static String generatePassword() {
         String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
    
    public static HashMap<String, String> getFieldMap(Object obj) {
        HashMap<String, String> fieldMap = new HashMap<>();
        Class<?> objClass = obj.getClass(); // Get the class of the object

        if (Alien.class.isAssignableFrom(objClass)) {
            objClass = Alien.class;}
  
        for (Field field : objClass.getDeclaredFields()) {
            if(!field.getName().equals("db")){
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                String stringValue;

                
                Package classPackage = value.getClass().getPackage();
                String name = classPackage.getName();
                 boolean inModels = name.contains(".models");
                // Inline check if the object is from the .models package
                if (value != null && inModels) {
                    // Inline attempt to get the ID of a model object
                    try {
                        Method getIdMethod = value.getClass().getMethod("getId");
                        stringValue = String.valueOf(getIdMethod.invoke(value));
                    } catch (Exception e) {
                        stringValue = "N/A"; // or handle the exception as needed
                    }
                } else {
                    stringValue = String.valueOf(value);
                }

                // Inline capitalization of the first letter of a string
                String fieldName = field.getName();
                if (fieldName != null && !fieldName.isEmpty()) {
                    fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                }
                fieldMap.put(fieldName, stringValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }}

        return fieldMap;
    } 

    public static String buildUpdateQuery(String tableName, HashMap<String, String> data, String keyColumn) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data map cannot be empty");
        }
        if (!data.containsKey(keyColumn)) {
            throw new IllegalArgumentException("Key column '" + keyColumn + "' not found in data map");
        }

        String idValue = data.get(keyColumn);

        StringBuilder queryBuilder = new StringBuilder("UPDATE ");
        queryBuilder.append(tableName).append(" SET ");

        StringJoiner setJoiner = new StringJoiner(", ");

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String column = entry.getKey();
            String value = entry.getValue();

            // Skip the key column in the SET clause
            if (!column.equals(keyColumn)) {
                setJoiner.add(column + " = '" + value + "'");
            }
        }

        queryBuilder.append(setJoiner.toString());
        queryBuilder.append(" WHERE ").append(keyColumn).append(" = '").append(idValue).append("'");

        return queryBuilder.toString();
    }
    
    public static String buildInsertQuery(String tableName, HashMap<String, String> data) {
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Data map cannot be empty");
        }

        StringBuilder queryBuilder = new StringBuilder("INSERT INTO ");
        queryBuilder.append(tableName).append(" (");

        StringJoiner columnJoiner = new StringJoiner(", ");
        StringJoiner valueJoiner = new StringJoiner(", ", "VALUES (", ")");

        for (Map.Entry<String, String> entry : data.entrySet()) {
            String column = entry.getKey();
            String value = entry.getValue();
            
            if(!column.equals("Race")&&!column.equals("Value")&&!column.equals("Type")) {

                columnJoiner.add(column);
                valueJoiner.add("'" + value + "'");
            }
        }

        queryBuilder.append(columnJoiner.toString());
        queryBuilder.append(") ");
        queryBuilder.append(valueJoiner.toString());

        return queryBuilder.toString();
    }
   
    public static void updateObject(Object obj) throws InfException {
        HashMap<String, String> objectMap = getFieldMap(obj);
        Class<?> objClass = obj.getClass();
        String query= "";// Get the class of the object

        if (Alien.class.isAssignableFrom(objClass)) {
            objClass = Alien.class;}
        
        switch (objClass.getSimpleName()){
            case "Agent":
                query = buildUpdateQuery("agent", objectMap, "Agent_ID");
         
                break;
            
            case "Alien":
                query = buildUpdateQuery("alien", objectMap, "Alien_ID");
                
                break;
                
            case "Area":
                query = buildUpdateQuery("omrade", objectMap, "Omrades_ID");
                
                break;
            
            case "Location":
                query = buildUpdateQuery("plats", objectMap, "Plats_ID");
                
                break;
                
            case "Utilities":
                query = buildUpdateQuery("utrustning", objectMap, "Utrustnings_ID");
                
                break;
                
            default:
                System.out.println("No");
        }
        if(query.length()>0){db.update(query);}
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

            String alienQuery = ObjectManager.buildUpdateQuery("alien", alienMap, "Alien_ID");
            db.update(alienQuery);

        }

        public static void updateSubClass(HashMap<String,String> map, String oldSpecies, String newSpecies) throws InfException {
            if(oldSpecies.equals(newSpecies)){
                if (map.containsKey("Antal_Boogies")) {
                    HashMap<String, String> bogloditeMap = new HashMap<>();
                    bogloditeMap.put("Alien_ID", map.get("Alien_ID"));
                    bogloditeMap.put("Antal_Boogies", map.get("Antal_Boogies"));

                    //String bogloditeQuery = ObjectManager.buildUpdateQuery("Boglodite", bogloditeMap);
                    //db.update(bogloditeQuery);
                }

                // Update 'Squid' table if "Antal_Armar" is present
                if (map.containsKey("Antal_Armar")) {
                    HashMap<String, String> squidMap = new HashMap<>();
                    squidMap.put("Alien_ID", map.get("Alien_ID"));
                    squidMap.put("Antal_Armar", map.get("Antal_Armar"));

                    //String squidQuery = ObjectManager.buildUpdateQuery("Squid", squidMap);
                    //db.update(squidQuery);
                }

                // Update 'Worm' table if "Langd" is present
                if (map.containsKey("Langd")) {
                    HashMap<String, String> wormMap = new HashMap<>();
                    wormMap.put("Alien_ID", map.get("Alien_ID"));
                    wormMap.put("Langd", map.get("Langd"));

                    //String wormQuery = ObjectManager.buildUpdateQuery("Worm", wormMap);
                   // db.update(wormQuery);
                }   
            } else {
                String tableName = newSpecies; // Assuming 'two' is a variable holding the table name
                String alienID = map.get("Alien_ID");
                String value = map.get("Value");

                // Assuming 'alienID' and 'value' are strings. If they are numeric, remove the single quotes around the placeholders.
                String sql = "INSERT INTO " + tableName.toLowerCase() + " VALUES (" + alienID + ", " + value + ");";

                db.insert(sql);
                
                sql = "Delete from " + oldSpecies.toLowerCase() + " where Alien_ID = "+alienID;
                db.delete(sql);

                alienList.put(Integer.parseInt(alienID),newInstance(map,newSpecies));
            }
        }

        private static Alien newInstance(HashMap<String,String> map,String race) {
            Location location = Locations.locationList.get(Integer.parseInt(map.get("Plats")));
            Agent agent = Agents.agentList.get(Integer.parseInt(map.get("Ansvarig_Agent")));

            switch (race) {
                case "Worm":
                    return new Worm(map, location, agent);
                case "Boglodite":
                    return new Boglodite(map, location, agent);
                case "Squid":
                    return new Squid(map, location, agent);
                default:
                    return new Alien(map, location, agent);
            }
        }

        public static Alien getAlien(int id) {
            return alienList.get(id);
        }

        public static void offLoad() {
            alienList.clear();
        }
        
        public static void addNew(HashMap<String,String> map, Location location, Agent agent, String race) throws InfException{
            String Query = buildInsertQuery("alien", map);
            
            db.insert(Query);
            
            
            switch (race){
                case "Boglodite":
                    alienList.put(Integer.parseInt(map.get("Alien_ID")), new Boglodite(map, location, agent));
                    HashMap<String, String> bogloditeMap = new HashMap<>();
                    bogloditeMap.put("Alien_ID", map.get("Alien_ID"));
                    bogloditeMap.put("Antal_Boogies", map.get("Value"));

                    String bogloditeQuery = ObjectManager.buildInsertQuery("boglodite", bogloditeMap);
                    db.insert(bogloditeQuery);
                    break;
                
                case "Squid":
                    alienList.put(Integer.parseInt(map.get("Alien_ID")), new Squid(map, location, agent));
                    HashMap<String, String> squidMap = new HashMap<>();
                    squidMap.put("Alien_ID", map.get("Alien_ID"));
                    squidMap.put("Antal_Armar", map.get("Value"));

                    String squidQuery = ObjectManager.buildInsertQuery("squid", squidMap);
                    db.insert(squidQuery);
                    break;
                
                case "Worm":
                    alienList.put(Integer.parseInt(map.get("Alien_ID")), new Worm(map, location, agent));
                    HashMap<String, String> wormMap = new HashMap<>();
                    wormMap.put("Alien_ID", map.get("Alien_ID"));
                    wormMap.put("Langd", map.get("Value"));

                    String wormQuery = ObjectManager.buildInsertQuery("worm", wormMap);
                    db.insert(wormQuery);
                    break;
                    
                default:
                    System.out.println("Fel inmatning");
            }
        }
        
        public static void delete(ArrayList<Integer> list) {
            for(int ID : list){
                try {
                    Alien alien = alienList.get(ID);
                    String objClass = alien.getClass().getSimpleName();
                    
                    if(!objClass.equals("Alien")){
                        db.delete("Delete from "+objClass.toLowerCase()+" where Alien_ID = "+ID);
                    }
                    db.delete("Delete from alien where Alien_ID =" +ID);
                    alienList.remove(ID);
                } catch (InfException ex) {
                    Logger.getLogger(ObjectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }

    
    public static class Agents {
        public static HashMap<Integer, Agent> agentList = new HashMap<>();

       public static void LoadList() throws NumberFormatException, InfException {
            if (!agentList.isEmpty()) {
                agentList.clear();
            }

            if (Areas.areaList.isEmpty()) {
                Areas.loadList();
            }

            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * FROM agent");
            ArrayList<HashMap<String, String>> Fmap = db.fetchRows("SELECT * FROM faltagent");
            ArrayList<HashMap<String, String>> Omap = db.fetchRows("SELECT * FROM omradeschef");
            ArrayList<HashMap<String, String>> Kmap = db.fetchRows("SELECT * FROM kontorschef");

            for (HashMap<String, String> singleMap : map) {
                int agentId = Integer.parseInt(singleMap.get("Agent_ID"));
                int areaID = Integer.parseInt(singleMap.get("Omrade"));

                HashMap<String, String> matchingMap = findMatchingMap(agentId, Omap);
                if (matchingMap != null) {
                    
                    Area controlArea = Areas.areaList.get(matchingMap.get("Omrade"));
                    agentList.put(agentId, new OmradesChef(singleMap,Areas.areaList.get(areaID),controlArea));
                    
                } else if ((matchingMap = findMatchingMap(agentId, Kmap)) != null) {
                    
                    String officeName = matchingMap.get("Kontorsbeteckning");
                    agentList.put(agentId, new KontorsChef(singleMap, Areas.areaList.get(areaID),officeName));
                    
                } else if ((matchingMap = findMatchingMap(agentId, Fmap)) != null) {
                    
                     agentList.put(agentId, new Faltagent(singleMap, Areas.areaList.get(areaID)));
                    
                } else {
                    // The agentId does not exist in any of the lists
                    Agent agent = new Agent(singleMap, Areas.areaList.get(areaID));
                    agentList.put(agentId, agent);
                }
            }
        }

        
        private static HashMap<String, String> findMatchingMap(int agentId, ArrayList<HashMap<String, String>> list) {
            for (HashMap<String, String> map : list) {
                if (Integer.parseInt(map.get("Agent_ID")) == agentId) {
                    return map;
                }
            }
            return null;
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
            
            String query = "SELECT u.*, v.kaliber, k.Overforingsteknik, t.kraftkalla FROM utrustning u LEFT JOIN vapen v ON u.Utrustnings_ID = v.Utrustnings_ID LEFT JOIN kommunikation k ON u.Utrustnings_ID = k.Utrustnings_ID LEFT JOIN teknik t ON u.Utrustnings_ID = t.Utrustnings_ID";
            ArrayList<HashMap<String, String>> map = db.fetchRows(query);
            
            for(HashMap<String,String> singleMap : map){
                int id = Integer.parseInt(singleMap.get("Utrustnings_ID"));
                
                Utilities util;
                if(singleMap.get("Kaliber")!=null){
                    util = new Vapen(singleMap);
                }
                else if(singleMap.get("Overforingsteknik")!=null){
                    util = new Kommunikation(singleMap);
                }
                else if(singleMap.get("Kraftkalla")!=null){
                    util = new Teknik(singleMap);
                }
                else{util = new Utilities(singleMap);}
                utilitiesList.put(id, util);
            }
        }
        
        public static void updateField(int id, String column, String newValue){
            try{
                String updateQuery = "UPDATE utrustning SET " + column + " = '" + newValue + "' Utrustnings_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void updateField(int id, String column, int newValue){
            try{
                String updateQuery = "UPDATE utrustning SET " + column + " = " + newValue + " Utrustnings_ID = " + id;
                db.update(updateQuery);
            } catch(InfException e){
                System.out.println(e.getMessage());
            }
        }
        
        public static void offLoad(){
        utilitiesList.clear();
        }
        
        public static void addNew(HashMap<String,String> map) throws InfException{
            String Query = buildInsertQuery("utrustning", map);
            
            db.insert(Query);
            String type = map.get("Type");
            
            switch (type){
                case "Vapen":
                    utilitiesList.put(Integer.parseInt(map.get("Utrustnings_ID")), new Vapen(map));
                    HashMap<String, String> weaponMap = new HashMap<>();
                    weaponMap.put("Utrustnings_ID", map.get("Utrustnings_ID"));
                    weaponMap.put("Kaliber", map.get("Value"));

                    String weaponQuery = ObjectManager.buildInsertQuery("vapen", weaponMap);
                    db.insert(weaponQuery);
                    break;
                
                case "Kommunikation":
                    utilitiesList.put(Integer.parseInt(map.get("Utrustnings_ID")), new Kommunikation(map));
                    HashMap<String, String> commsMap = new HashMap<>();
                    commsMap.put("Utrustnings_ID", map.get("Utrustnings_ID"));
                    commsMap.put("Overforingsteknik", map.get("Value"));

                    String commsQuery = ObjectManager.buildInsertQuery("kommunikation", commsMap);
                    db.insert(commsQuery);
                    break;
                
                case "Teknik":
                    utilitiesList.put(Integer.parseInt(map.get("Utrustnings_ID")), new Teknik(map));
                    HashMap<String, String> techMap = new HashMap<>();
                    techMap.put("Utrustnings_ID", map.get("Utrustnings_ID"));
                    techMap.put("Kraftkalla", map.get("Value"));

                    String techQuery = ObjectManager.buildInsertQuery("teknik", techMap);
                    db.insert(techQuery);
                    break;
                    
                default:
                    System.out.println("Fel inmatning");
            }
        }
        
        public static void delete(ArrayList<Integer> list) {
            for(int ID : list){
                try {
                    Utilities utility = utilitiesList.get(ID);
                    String objClass = utility.getClass().getSimpleName();
                    
                    if(!objClass.equals("Utilities")){
                        db.delete("Delete from "+objClass.toLowerCase()+" where Utrustnings_ID = "+ID);
                    }
                    db.delete("Delete from utrustning where Utrustnings_ID =" +ID);
                    utilitiesList.remove(ID);
                } catch (InfException ex) {
                    Logger.getLogger(ObjectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
   
    
    public class AgentUtilityHandler {
        // HashMap with key as utility ID and value as an AgentUtils object

        public static HashMap<Integer, AgentUtils> agentUtilsMap = new HashMap<>();

        public static void loadList() throws InfException {
            if (Aliens.alienList.isEmpty()) {
                Aliens.loadAlienList();
            }
            if (UtilitiesHandler.utilitiesList.isEmpty()) {
                UtilitiesHandler.loadList();
            }

            String query = "SELECT * FROM innehar_utrustning";
            ArrayList<HashMap<String, String>> map = db.fetchRows(query);
            for (HashMap<String, String> singleMap : map) {
                int agentId = Integer.parseInt(singleMap.get("Agent_ID"));
                int utilityId = Integer.parseInt(singleMap.get("Utrustnings_ID"));
                LocalDate date = LocalDate.parse(singleMap.get("Utkvitteringsdatum"));

                Agent agent = Agents.agentList.get(agentId); // Assuming agentList is a static field in Agents class
                Utilities utility = UtilitiesHandler.utilitiesList.get(utilityId);

                AgentUtils item = new AgentUtils(agent, utility, date);

                // Put the AgentUtils item in the map with utility ID as the key
                agentUtilsMap.put(utilityId, item);
            }
        }

        public static HashMap<String, String> getUtilityInfo(Utilities utility) {
            HashMap<String, String> statusInfo = new HashMap<>();
            AgentUtils agentUtil = agentUtilsMap.get(utility.getID());

            if (agentUtil != null) {
                statusInfo.put("Status", "Utlånad");
                statusInfo.put("Borrower", agentUtil.getAgent().getName()); // Assuming Agent has a getName() method
                statusInfo.put("Date", agentUtil.getBorrowingDate().toString());
            } else {
                statusInfo.put("Status", "Tillgänglig");
                statusInfo.put("Borrower", null); // Empty string for borrower
                statusInfo.put("Date", null);     // Empty string for date
            }
            return statusInfo;
        }
        
        public static HashMap<Integer,Utilities> getAgentUtils(Agent agent){
            HashMap<Integer,Utilities> utilMap= new HashMap<>();
            
            for(AgentUtils item : agentUtilsMap.values()){
                if(item.getAgent().getId()==agent.getId()){
                    Utilities util = item.getUtility();
                    
                    utilMap.put(util.getID(),util);
                }
            }
            return utilMap;
        }
        
        public static void remove(ArrayList<Integer> idList) throws InfException {
            for(int id : idList){
                AgentUtils item = agentUtilsMap.get(id);
                db.delete("delete from innehar_utrustning where Agent_ID = " + item.getAgent().getId() + " and Utrustnings_ID = "+ item.getUtility().getID());
                agentUtilsMap.remove(item.getUtility().getID());
            } 
           
        }
        public static void addNew(ArrayList<Utilities> utilList) throws InfException {
            HashMap<String,String> inputMap = new HashMap<>();
            int AgentID = UserSession.getInstance().getUserId();
            String stringAgentID = Integer.toString(AgentID);
            for(Utilities item: utilList){
                int ID = item.getID();
                String stringID = Integer.toString(item.getID());
      
                LocalDate date = LocalDate.now();
                String stringDate = date.toString();
                
                inputMap.put("Agent_ID", stringAgentID);
                inputMap.put("Utrustnings_ID", stringID);
                inputMap.put("Utkvitteringsdatum", stringDate);
                
                db.insert(buildInsertQuery("innehar_utrustning",inputMap));
                agentUtilsMap.put(ID, new AgentUtils(Agents.agentList.get(AgentID),item,date));
                
                
                
            }
        }  
    }
}
