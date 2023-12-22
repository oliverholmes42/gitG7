package javaapplication3.models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.HashMap;
import oru.inf.InfDB;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javaapplication3.utils.DatabaseConnection;

public class Agent {
    private int agentID;
    private String name;
    private String telephone;
    private LocalDate recruitmentDate;
    private String Admin;
    private String email;
    private String password;
    private Area area;
    public static InfDB db;

    // Constructor
    public Agent(HashMap<String, String> agentMap, LocalDate recruitmentDate, Area area) {
        this.agentID = agentID;
        this.name = agentMap.get("Namn");
        this.password = agentMap.get("Losenord");
        this.telephone = agentMap.get("Telefon");
        this.email = agentMap.get("Epost");
        this.Admin = agentMap.get("Administrator");
        this.recruitmentDate = LocalDate.parse(agentMap.get("Anstallningsdatum"));
        this.area = area;
    }

    // Getters and Setters
    public int getAgent_ID() {
        return agentID;
    }
  
    
    public void setAgent_ID(int agentID) {
        this.agentID = agentID;
    }

    public void setName(String name) {
       try{
        String query = "UPDATE agent SET Namn = '" + name + "' WHERE Agent_ID = " + agentID;
        db.update(query);
        this.name = name;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }    
    }

    public String getName() {
        return name;
    }
    
    public String getTelephone() {
        return telephone; 
    }

    public void setTelephone(String telephone) {
        try{
        String query = "UPDATE agent SET Telefon = '" + telephone + "' WHERE Agent_ID = " + agentID;
        db.update(query);
        this.telephone = telephone;
       }
       catch(Exception e){
       System.out.println(e.getMessage());
       }
        
    }

    public LocalDate getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        try{
        String query = "UPDATE agent SET Anstallningsdatum = " + recruitmentDate + " WHERE Agent_ID = " + agentID;
        db.update(query);
        this.telephone = telephone;
       }
       catch(Exception e){
       System.out.println(e.getMessage());
       }
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String Admin) {
try{
        String query = "UPDATE agent SET Administrator = '" + Admin + "' WHERE Agent_ID = " + agentID;
        db.update(query);
        this.Admin = Admin;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }     }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        try{
        String mailQuery = "UPDATE agent SET Epost = '" + email + "' WHERE Agent_ID = " + agentID;
        db.update(mailQuery);
        this.email = email;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       } 
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try{
        String query = "UPDATE agent SET Losenord = '" + password + "' WHERE Agent_ID = " + agentID;
        db.update(query);
        this.password = password;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }  
    }    

    public Area getArea() {
        return area;
    }

    public void setLocation(Area area) {
        try{
        String query = "UPDATE agent SET Omrade = " + area + " WHERE Agent_ID = " + agentID;
        db.update(query);
        this.area = area;
       }
       catch(Exception e){
       System.out.println(e.getMessage());
       }
    }
}
