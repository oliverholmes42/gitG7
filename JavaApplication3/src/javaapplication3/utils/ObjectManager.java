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
import javaapplication3.models.agentSubClass.Fältagent;
import javaapplication3.models.agentSubClass.KontorsChef;
import javaapplication3.models.agentSubClass.Områdeschef;
import javaapplication3.models.alienSubclasses.Boglodite;
import javaapplication3.models.alienSubclasses.Squid;
import javaapplication3.models.alienSubclasses.Worm;
import javaapplication3.models.utilitySubClasses.Kommunikation;
import javaapplication3.models.utilitySubClasses.Teknik;
import javaapplication3.models.utilitySubClasses.Vapen;
import oru.inf.*;
import oru.inf.InfException;
import java.util.Comparator;
import java.util.List;


/**
 *
 * @author mopaj
 */

/*
Stor klass som hanterar alla object som används genom hela projektet. Har interna klasser för varje model och en rad metoder.
*/
public class ObjectManager {

    public static InfDB db = DatabaseConnection.getInstance();
    
    
    //Tömmer alla listorna
    public static void offloadAll() {
        Class<?>[] innerClasses = ObjectManager.class.getDeclaredClasses();

        for (Class<?> innerClass : innerClasses) {
            try {
                Method offloadMethod = innerClass.getDeclaredMethod("offLoad");
                offloadMethod.setAccessible(true); 
                offloadMethod.invoke(null); 
            } catch (NoSuchMethodException e) {
                System.out.println(innerClass.getName() + " does not have an offload method.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    //Skapar lösenord, måste matcha regex kravet
    public static String generatePassword() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        String saltStr;
        do {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        saltStr = salt.toString();}
        while(!saltStr.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+"));
        return saltStr;
    }

    
    //Metod som tar in ett object och returnerar en HashMap med alla dess fält och värden.
    public static HashMap<String, String> getFieldMap(Object obj) {
        HashMap<String, String> fieldMap = new HashMap<>();
        Class<?> objClass = obj.getClass(); //Hämtar klassen

        // Kollar om klassen är en subclass till Alien, Agent, eller Utrustning
        if (Alien.class.isAssignableFrom(objClass)
                || Utilities.class.isAssignableFrom(objClass)
                || Agent.class.isAssignableFrom(objClass)) {

            // Hämtar fälten från subklassen
            Class<?> currentClass = objClass;
            while (currentClass != null) {
                for (Field field : currentClass.getDeclaredFields()) {
                    if (!field.getName().equals("db")) {
                        field.setAccessible(true);
                        try {
                            Object value = field.get(obj);
                            String stringValue = processFieldValue(value);

                            String fieldName = field.getName();
                            
                            //Check för om objectet är en subklass till agent, inte är agent samt har ett fält med betäckningen 'omrade' (Områdeschef har två värden med namn område)
                            if (Agent.class.isAssignableFrom(objClass) && !currentClass.equals(Agent.class) && fieldName.equalsIgnoreCase("omrade")) {
                                fieldName = "ControlAreaId";
                            } else {
                                fieldName = capitalizeFirstLetter(fieldName);
                            }

                            fieldMap.put(fieldName, stringValue);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                currentClass = currentClass.getSuperclass(); // Flytta upp till superklassen
            }
        } else {
            for (Field field : objClass.getDeclaredFields()) {
                if (!field.getName().equals("db")) {
                    field.setAccessible(true);
                    try {
                        Object value = field.get(obj);
                        String stringValue = processFieldValue(value);

                        String fieldName = capitalizeFirstLetter(field.getName());
                        fieldMap.put(fieldName, stringValue);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        //returnerar HashMapen nu komplett
        return fieldMap;
    }

    //Gör första bokstaven stor
    private static String capitalizeFirstLetter(String input) {
        if (input != null && !input.isEmpty()) {
            return input.substring(0, 1).toUpperCase() + input.substring(1);
        }
        return input;
    }
    
    //Hämtar ut värden från fälten och gör de till stängar
    private static String processFieldValue(Object value) {
        if (value == null) {
            return "null";
        }

        Package classPackage = value.getClass().getPackage();
        if (classPackage != null) {
            String name = classPackage.getName();
            boolean inModels = name.contains(".models");//kollar om fältets värde tillhör modelels(är ett objekt)

            if (inModels) {
                try {
                    Method getIdMethod = value.getClass().getMethod("getId");//hämtar ut id för de objektet
                    return String.valueOf(getIdMethod.invoke(value));
                } catch (Exception e) {
                    return "N/A"; 
                }
            }
        }

        return String.valueOf(value);
    }

    //Metod som bygger ett update query baserat på 4 parameterar, HashMapen används genom att nyckeln är columnernas namn och värdet det nya värdet
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
            if (column.equals("ControlAreaId")){column = "omrade";}
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
    
    //Metod som bygger ett insert query, samma princip som buildUpdateQuery
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
   
    //Metod som sköter uppdateringen, både i databasen och lokalt i de olika listorna
    public static void updateObject(Object obj) throws InfException {
        HashMap<String, String> objectMap = getFieldMap(obj);
        Class<?> objClass = obj.getClass();
        String query= "";
        
        //kollar vilken klass objectet tillhör
        switch (objClass.getSimpleName()) {
            case "Worm":
                HashMap<String, String> wormMap = new HashMap<>();//skapar en ny hashmap med de unika värderna
                wormMap.put("Langd", objectMap.get("Langd"));
                wormMap.put("Alien_ID", objectMap.get("Alien_ID"));
                objectMap.remove("Langd");//tar bort unika värden från super-mapen

                String wormQuery = buildUpdateQuery("worm", wormMap, "Alien_ID");//bygger frågan för subklassen
                db.update(wormQuery);//uppdaterar databasen

                query = buildUpdateQuery("alien", objectMap, "Alien_ID");//skapar frågan som används i superklassens uppdatering
                break;
                
            //samma som tidigare men med egna värden
            case "Squid":
                HashMap<String, String> squidMap = new HashMap<>();
                squidMap.put("Antal_Armar", objectMap.get("Antal_Armar"));
                squidMap.put("Alien_ID", objectMap.get("Alien_ID"));
                objectMap.remove("Antal_Armar");

                String squidQuery = buildUpdateQuery("squid", squidMap, "Alien_ID");
                db.update(squidQuery);

                query = buildUpdateQuery("alien", objectMap, "Alien_ID");
                break;
            
            //samma som tidigare men med egna värden
            case "Boglodite":
                HashMap<String, String> boogloditeMap = new HashMap<>();
                boogloditeMap.put("Antal_Boogies", objectMap.get("Antal_Boogies"));
                boogloditeMap.put("Alien_ID", objectMap.get("Alien_ID"));
                objectMap.remove("Antal_Boogies");

                String boogloditeQuery = buildUpdateQuery("boglodite", boogloditeMap, "Alien_ID");
                db.update(boogloditeQuery);

                query = buildUpdateQuery("alien", objectMap, "Alien_ID");
                break;
            
            //Ifall en alien saknar subklass
            case "Alien":
                query = buildUpdateQuery("alien", objectMap, "Alien_ID");
                break;
                
            //samma som med alien fast för agent
            case "Fältagent":
                HashMap<String, String> fältagentMap = new HashMap<>();
                fältagentMap.put("Agent_ID", objectMap.get("Agent_ID"));
                
                String fältagentQuery = buildUpdateQuery("faltagent", fältagentMap, "Agent_ID");
                db.update(fältagentQuery);

                query = buildUpdateQuery("agent", objectMap, "Agent_ID");
                break;

            case "KontorsChef":
                HashMap<String, String> kontorsChefMap = new HashMap<>();
                kontorsChefMap.put("Kontorsbeteckning", objectMap.get("Kontorsbeteckning"));
                kontorsChefMap.put("Agent_ID", objectMap.get("Agent_ID"));
                objectMap.remove("Kontorsbeteckning");

                String kontorsChefQuery = buildUpdateQuery("kontorschef", kontorsChefMap, "Agent_ID");
                db.update(kontorsChefQuery);

                query = buildUpdateQuery("agent", objectMap, "Agent_ID");
                break;

            case "Områdeschef":
                HashMap<String, String> områdeschefMap = new HashMap<>();
                områdeschefMap.put("ControlAreaId",objectMap.get("ControlAreaId"));
                områdeschefMap.put("Agent_ID", objectMap.get("Agent_ID"));
                objectMap.remove("ControlAreaId");

                String områdeschefQuery = buildUpdateQuery("omradeschef", områdeschefMap, "Agent_ID");
                db.update(områdeschefQuery);

                query = buildUpdateQuery("agent", objectMap, "Agent_ID");
                break;

            case "Agent":
                query = buildUpdateQuery("agent", objectMap, "Agent_ID");
                break;
            
            //uppdateringar för övriga klasser
            case "Area":
                query = buildUpdateQuery("omrade", objectMap, "Omrades_ID");
                break;
            case "Location":
                query = buildUpdateQuery("plats", objectMap, "Plats_ID");
                break;
            case "Utilities":
                query = buildUpdateQuery("utrustning", objectMap, "Utrustnings_ID");
                break;
                
            //om klass saknas händer inget
            default:
                break;
        }
        
        //kollar om query har fyllts i(görs inom switch casen)
        if (query.length() > 0) {
            db.update(query);//uppdaterar huvudobjektet
        }
    }

    //Inre klass för platser
    public static class Locations {
        public static HashMap<Integer, Location> locationList = new HashMap<>();//HashMap som innehåller alla aktiva objekt
        

        public static void loadList() throws NumberFormatException, InfException {//fyller hashmap med data från databasen
            // Rensar om den inte är tom
           if (!locationList.isEmpty()) {
                locationList.clear();
            }

            // Laddar in områden om den inte är tom
            if (Areas.areaList.isEmpty()) {
                Areas.loadList();
            }
            
            
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * from plats");
            for(HashMap<String,String> singleMap : map){
                int id1 = Integer.parseInt(singleMap.get("Plats_ID"));
                int id2 = Integer.parseInt(singleMap.get("Finns_I"));
                Location location = new Location(singleMap,Areas.areaList.get(id2));
                locationList.put(id1, location);
                
            }
        }
        
        //tömmer hashmap
        public static void offLoad(){
        locationList.clear();
        }
        
        //Raderar från böde databas och hashmap
        public static void delete(ArrayList<Integer> list) throws InfException {
            for (int ID : list) {
                db.delete("Delete from plats where Plats_ID =" + ID);
                locationList.remove(ID);
            }
        }
    }
    
    //inre klas för alien
    public static class Aliens{
        public static HashMap<Integer, Alien> alienList = new HashMap<>(); //objekt hashmap
        public static ArrayList<String> emailList = new ArrayList<>();//ArrayList med alla emails(för att kolla dubletter)

        //Metod som fyller hashmapen
        public static void loadAlienList() throws NumberFormatException, InfException {
            //Rensa om inte tom
            if (!alienList.isEmpty()) {
                alienList.clear();
            }

            //Fyll plats om tom
            if (Locations.locationList.isEmpty()) {
                Locations.loadList();
            }

            //fyll alien om tom
            if (Agents.agentList.isEmpty()) {
                Agents.LoadList();
            }
            
            //Query som hömtar från superklass och alla subklasser
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT a.*, w.Langd, b.Antal_Boogies, s.Antal_Armar FROM Alien a LEFT JOIN Worm w ON a.Alien_ID = w.Alien_ID LEFT JOIN Boglodite b ON a.Alien_ID = b.Alien_ID LEFT JOIN Squid s ON a.Alien_ID = s.Alien_ID");
            for (HashMap<String, String> singleMap : map) {
            int id = Integer.parseInt(singleMap.get("Alien_ID"));
            int platsID = Integer.parseInt(singleMap.get("Plats"));
            int agentID = Integer.parseInt(singleMap.get("Ansvarig_Agent"));

            Alien alien;
            if (singleMap.get("Langd")!=null) {
                // Skapa en ny worm
                alien = new Worm(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            } else if (singleMap.get("Antal_Boogies")!=null) {
                // Skapa en ny boglodite
                alien = new Boglodite(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            } else if (singleMap.get("Antal_Armar")!=null) {
                // Skapa en ny Squid
                alien = new Squid(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            } else {
                // Skapa en ny tom alien
                alien = new Alien(singleMap, Locations.locationList.get(platsID), Agents.agentList.get(agentID));
            }

            alienList.put(id, alien);
            emailList.add(singleMap.get("Epost").toLowerCase());
        }
        }
       
        //Uppdaterar en instans i databasen
        public static void updateInstance(HashMap<String, String> map) throws InfException {
            HashMap<String, String> alienMap = new HashMap<>(map);
            
            //unika värden tas bort
            alienMap.remove("Antal_Boogies"); 
            alienMap.remove("Antal_Armar");   
            alienMap.remove("Langd");

            String alienQuery = ObjectManager.buildUpdateQuery("alien", alienMap, "Alien_ID");//Frpgan byggs via buildUpdateQuery
            db.update(alienQuery);//updateras

        }
       
        //Metod som uppdaterar subklasser i databasen
        public static void updateSubClass(HashMap<String,String> map, String oldSpecies, String newSpecies) throws InfException {
                String tableName = newSpecies;
                String alienID = map.get("Alien_ID");
                String value = map.get("Value");

                //Skapar ny instans för nya subklassen
                String sql = "INSERT INTO " + tableName.toLowerCase() + " VALUES (" + alienID + ", " + value + ");";
                db.insert(sql);
                
                //raderar gamla instansen i gamla subklaseen
                sql = "Delete from " + oldSpecies.toLowerCase() + " where Alien_ID = "+alienID;
                db.delete(sql);

            
        }


        //rensar hashmap
        public static void offLoad() {
            alienList.clear();
            emailList.clear();
        }
        
        //skapa ny instans
        public static void addNew(HashMap<String,String> map, Location location, Agent agent, String race) throws InfException{
            
            String Query = buildInsertQuery("alien", map);
            db.insert(Query);//huvudinstansen skapas
            
            
            switch (race){
                case "Boglodite":
                    alienList.put(Integer.parseInt(map.get("Alien_ID")), new Boglodite(map, location, agent));//Nytt objekt skapas och läggs i hashmap
                    HashMap<String, String> bogloditeMap = new HashMap<>();//subklass hashmap skapas och fylls
                    bogloditeMap.put("Alien_ID", map.get("Alien_ID"));
                    bogloditeMap.put("Antal_Boogies", map.get("Value"));

                    String bogloditeQuery = ObjectManager.buildInsertQuery("boglodite", bogloditeMap);//fråga byggs
                    db.insert(bogloditeQuery);//subklass uppdateras i databas
                    break;
                
                //samma som oven men andra värden
                case "Squid":
                    alienList.put(Integer.parseInt(map.get("Alien_ID")), new Squid(map, location, agent));
                    HashMap<String, String> squidMap = new HashMap<>();
                    squidMap.put("Alien_ID", map.get("Alien_ID"));
                    squidMap.put("Antal_Armar", map.get("Value"));

                    String squidQuery = ObjectManager.buildInsertQuery("squid", squidMap);
                    db.insert(squidQuery);
                    break;
                
                //samma som oven men andra värden    
                case "Worm":
                    alienList.put(Integer.parseInt(map.get("Alien_ID")), new Worm(map, location, agent));
                    HashMap<String, String> wormMap = new HashMap<>();
                    wormMap.put("Alien_ID", map.get("Alien_ID"));
                    wormMap.put("Langd", map.get("Value"));

                    String wormQuery = ObjectManager.buildInsertQuery("worm", wormMap);
                    db.insert(wormQuery);
                    break;
                    
                default:
            }
            emailList.add(map.get("Epost"));//epost läggs i epostlistan
        }
        
        //radera metod
        public static void delete(ArrayList<Integer> list) {
            for(int ID : list){
                try {
                    Alien alien = alienList.get(ID);
                    String objClass = alien.getClass().getSimpleName();
                    
                    if(!objClass.equals("Alien")){
                        db.delete("Delete from "+objClass.toLowerCase()+" where Alien_ID = "+ID);//raderar först från subklass om av den typ
                    }
                    db.delete("Delete from alien where Alien_ID =" +ID);
                    alienList.remove(ID);
                    emailList.remove(alien.getEmail());
                } catch (InfException ex) {
                    Logger.getLogger(ObjectManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }

    //inre klass för agenter, samma upplägg som alien
    public static class Agents {
        public static HashMap<Integer, Agent> agentList = new HashMap<>();
        public static ArrayList<String> emailList = new ArrayList<>();

       public static void LoadList() throws NumberFormatException, InfException {
           if (!agentList.isEmpty()) {
               agentList.clear();
           }

           // Check and load Areas if not already loaded
           if (Areas.areaList.isEmpty()) {
               Areas.loadList();
           }
            
            //Agents subklasser innehåller columner med samma namn som kolumner i superklassen 4 frågor behövet ställas istället för 1
            ArrayList<HashMap<String, String>> map = db.fetchRows("SELECT * FROM agent");
            ArrayList<HashMap<String, String>> Fmap = db.fetchRows("SELECT * FROM faltagent");
            ArrayList<HashMap<String, String>> Omap = db.fetchRows("SELECT * FROM omradeschef");
            ArrayList<HashMap<String, String>> Kmap = db.fetchRows("SELECT * FROM kontorschef");

            for (HashMap<String, String> singleMap : map) {
                int agentId = Integer.parseInt(singleMap.get("Agent_ID"));
                int areaID = Integer.parseInt(singleMap.get("Omrade"));

                HashMap<String, String> matchingMap = findMatchingMap(agentId, Omap);//kollar om agenten finns i omap (områdeschef)
                if (matchingMap != null) {
                    String id = matchingMap.get("Omrade");
                    int intID = Integer.parseInt(id);
                    Area controlArea = Areas.areaList.get(intID);
                    agentList.put(agentId, new Områdeschef(singleMap,Areas.areaList.get(areaID),controlArea));
                    
                } else if ((matchingMap = findMatchingMap(agentId, Kmap)) != null) {//Kollar om ageenten finns i Kmap (kontorschef)
                    
                    String officeName = matchingMap.get("Kontorsbeteckning");
                    agentList.put(agentId, new KontorsChef(singleMap, Areas.areaList.get(areaID),officeName));
                    
                } else if ((matchingMap = findMatchingMap(agentId, Fmap)) != null) {//Fmap (fältagent)
                    
                     agentList.put(agentId, new Fältagent(singleMap, Areas.areaList.get(areaID)));
                    
                } else {
                    
                    Agent agent = new Agent(singleMap, Areas.areaList.get(areaID));//agent är tom agent
                    agentList.put(agentId, agent);
                }
                emailList.add(singleMap.get("Epost").toLowerCase());//lägg till epost
            }
        }

        //Kollar om en hashMap innehåller ett specifikt agentID
        private static HashMap<String, String> findMatchingMap(int agentId, ArrayList<HashMap<String, String>> list) {
            for (HashMap<String, String> map : list) {
                if (Integer.parseInt(map.get("Agent_ID")) == agentId) {
                    return map;
                }
            }
            return null;
        }

        
        public static void offLoad(){
        agentList.clear();
        emailList.clear();
        }
        
        //samma som tidigare
        public static void addNew(HashMap<String,String> map, Area area, String type) throws InfException{
            String Query = buildInsertQuery("agent", map);
            
            db.insert(Query);
            
            
            switch (type){
                case "Fältagent":
                    agentList.put(Integer.parseInt(map.get("Agent_ID")), new Fältagent(map, area));
                    HashMap<String, String> faltAgentMap = new HashMap<>();
                    faltAgentMap.put("Agent_ID", map.get("Agent_ID"));

                    String faltAgentQuery = ObjectManager.buildInsertQuery("faltagent", faltAgentMap);
                    db.insert(faltAgentQuery);
                    break;
                
                case "Kontorschef":
                    String officeName = map.get("Value");
             
                    agentList.put(Integer.parseInt(map.get("Agent_ID")), new KontorsChef(map, area, officeName));
                    HashMap<String, String> kontorsChefMap = new HashMap<>();
                    kontorsChefMap.put("Agent_ID", map.get("Agent_ID"));
                    kontorsChefMap.put("Kontorsbeteckning", map.get("Value"));

                    String kontorsChefQuery = ObjectManager.buildInsertQuery("kontorschef", kontorsChefMap);
                    db.insert(kontorsChefQuery);
                    break;
                
                case "Områdeschef":
                    int id = Integer.parseInt(map.get("Value"));
                    Area controlArea = ObjectManager.Areas.areaList.get(id);
        
                    agentList.put(Integer.parseInt(map.get("Agent_ID")), new Områdeschef(map, area, controlArea));
                    HashMap<String, String> omradesChefMap = new HashMap<>();
                    omradesChefMap.put("Agent_ID", map.get("Agent_ID"));
                    omradesChefMap.put("Omrade", map.get("Value"));

                    String omradesChefQuery = ObjectManager.buildInsertQuery("omradeschef", omradesChefMap);
                    db.insert(omradesChefQuery);
                    break;
                    
                default:
                    System.out.println("Fel inmatning");
            }
            emailList.add(map.get("Epost"));
        }
        
        //samma som tidigare
        public static void delete(ArrayList<Integer> list) throws InfException {
            for (int ID : list) {

                Agent agent = agentList.get(ID);
                String objClass = agent.getClass().getSimpleName();

                if (!objClass.equals("Agent")) {
                    String sweString = swedify(objClass);
                    db.delete("Delete from " + sweString + " where Agent_ID = " + ID);
                }
                db.delete("Delete from agent where Agent_ID =" + ID);
                agentList.remove(ID);
                emailList.remove(agent.getEmail());

            }

        }
        
        //Rättar till namnet så de matchar tabellerna i db
        private static String swedify(String string){
            switch (string){
                case "KontorsChef":
                    return "kontorschef";
                    
                case "Kontorschef":
                    return "kontorschef";
                 
                case "Områdeschef":
                    return "omradeschef";
                    
                default:
                    return "faltagent";
            }
        }
        
        //metod som returnerar områdeschef för ett areadId
        public static Områdeschef findOmradeschefForArea(int areaId) throws NumberFormatException, InfException {
            LoadList();
            for (Agent agent : agentList.values()) {
                if (agent instanceof Områdeschef) {
                    Områdeschef omradeschef = (Områdeschef) agent;
                    if (omradeschef.getControlArea().getId() == areaId) {
                        offLoad();
                        return omradeschef;
                    }
                }
            }
            offLoad();
            return null;
        }
        
        //Returnerar en lista med agent i ordning av vem som har mest aliens
        public static List<Map.Entry<Agent, Integer>> findTopThreeAgentsWithMostAliens() throws InfException {
        ObjectManager.Aliens.loadAlienList();
        HashMap<Agent, Integer> alienCountPerAgent = new HashMap<>();//Hashmap med agent och en siffra

        //Kollar alla aliens ansvarig agent, öker den agentens siffra i hashmapen med 1, om saknas lägger till agent i listan
        for (Alien alien : ObjectManager.Aliens.alienList.values()) {
            Agent responsibleAgent = alien.getResponsibleAgent();
            alienCountPerAgent.put(responsibleAgent, alienCountPerAgent.getOrDefault(responsibleAgent, 0) + 1);
        }

        // Skapar en lista från hashmapen och sorterar
        List<Map.Entry<Agent, Integer>> sortedAgents = new ArrayList<>(alienCountPerAgent.entrySet());
        sortedAgents.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Returnerar top 3 i listan elle hela om litan är kortare än så
        return sortedAgents.size() > 3 ? sortedAgents.subList(0, 3) : sortedAgents;
    }
        
        //samma som tidigare klasser
        public static void updateSubClass(HashMap<String, String> map, String oldType, String newType) throws InfException {
            String tableName = newType; // The new type's table name
            String agentID = map.get("Agent_ID"); // Getting the agent's ID

            
            String sql = "INSERT INTO " + swedify(tableName) + " (Agent_ID";

            // Check for specific fields based on new agent type
            if (newType.equals("KontorsChef")||newType.equals("Kontorschef")) {
                String officeName = map.get("Kontorsbeteckning");
                sql += ", Kontorsbeteckning) VALUES (" + agentID + ", '" + officeName + "')";
            } else if (newType.equals("Områdeschef")) {
                String controlAreaId = map.get("ControlAreaId");
                sql += ", Omrade) VALUES (" + agentID + ", " + controlAreaId + ")";
            } else {
          
                sql += ") VALUES (" + agentID + ")";
                if(db.fetchSingle("Select Agent_ID from faltagent where Agent_ID = "+agentID)!=null){sql="";}
            }
            if(sql.length()>0){db.insert(sql);}
            if(!oldType.equals("Agent")){

  
            sql = "DELETE FROM " + swedify(oldType) + " WHERE Agent_ID = " + agentID;
            db.delete(sql);}
        }

}
    //Innreklass areas, samma som tidiare men unika värden
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
        
        
        public static void offLoad(){
        areaList.clear();
        
        }
        
        public static void addNew(HashMap<String, String> map)throws InfException {
            String Query = buildInsertQuery("omrade", map);
            db.insert(Query);
            Area area = new Area(map);
            areaList.put(area.getId(), area); 
             
        }
        
        public static void delete(ArrayList<Integer> list) throws InfException {
            for(int ID:list){
            db.delete("Delete from omrade where Omrades_ID =" + ID);
            areaList.remove(ID);
            
        }
    }
    }

    //inreklass utilitiesHandler, samma upplägg som alien men mindre antal metoder
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
   
    //Innre klass för kopping mellan agent och utrustning
    public class AgentUtilityHandler {
        public static HashMap<Integer, AgentUtils> agentUtilsMap = new HashMap<>();

        public static void loadList() throws InfException {
            if(!agentUtilsMap.isEmpty()){
                agentUtilsMap.clone();
            }
            if (Agents.agentList.isEmpty()) {
                Agents.LoadList();
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
        
        //Matar in en utrustninng och får ut info om den
        public static HashMap<String, String> getUtilityInfo(Utilities utility) {
            HashMap<String, String> statusInfo = new HashMap<>();
            AgentUtils agentUtil = agentUtilsMap.get(utility.getID());//hämtar utrustningsobjektet

            if (agentUtil != null) {//Om agentUtil inte är null så är den upptagen
                statusInfo.put("Status", "Utlånad");
                statusInfo.put("Borrower", agentUtil.getAgent().getName()); //namn på agent
                statusInfo.put("Date", agentUtil.getBorrowingDate().toString());//datum för lån
            } else {//ledig
                statusInfo.put("Status", "Tillgänglig");
                statusInfo.put("Borrower", null);
                statusInfo.put("Date", null);}
            return statusInfo;
        }
        
        //returnerar  en hashmap med utrustning som en agent har i lån
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
        
        //samma som tidigare
        public static void remove(ArrayList<Integer> idList) throws InfException {
            for(int id : idList){
                AgentUtils item = agentUtilsMap.get(id);
                db.delete("delete from innehar_utrustning where Agent_ID = " + item.getAgent().getId() + " and Utrustnings_ID = "+ item.getUtility().getID());
                agentUtilsMap.remove(item.getUtility().getID());
            } 
           
        }
        
        //metod för att lägga in ny koppling, lån(när en agent klickar på en utrusting för att låna)
        public static void addNew(ArrayList<Utilities> utilList) throws InfException {
            HashMap<String,String> inputMap = new HashMap<>();
            int AgentID = UserSession.getInstance().getUserId();//tar inloggade agents id för lånet
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
        
        public static void offLoad(){
            agentUtilsMap.clear();
        }
    }

}