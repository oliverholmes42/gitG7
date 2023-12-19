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
    private HashMap<String, String> Results;
    public static InfDB db;

    // Constructor
    public Agent(int agentID) {
        this.agentID = agentID;
        db = DatabaseConnection.getInstance();
        try {
        String agentQuery = "Select * from agent join omrade on agent.Omrade = omrade.Omrades.ID where Agent_ID =" + agentID;
        Results = db.fetchRow(agentQuery);
        this.password = Results.get("Losenord");
        this.email = Results.get("Epost");
        this.Admin = Results.get("Administrator");
        this.recruitmentDate = LocalDate.parse(Results.get("Anstallningsdatum"));
//        this.area = Results.get("Omrade");

        }
        catch(Exception e){
        }
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
        String nameQuery = "UPDATE agent SET Namn = '" + name + "' WHERE Agent_ID = " + agentID;
        db.update(nameQuery);
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
        String teleQuery = "UPDATE agent SET telefon = '" + telephone + "' WHERE Agent_ID = " + agentID;
        db.update(teleQuery);
        this.telephone = telephone;
       }
       catch(Exception e){
       System.out.println(e.getMessage());
       }
        
    }

    public String getRecruitmentDate() {
        return Results.get("Anstallningsdatum");
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public String getAdmin() {
        return Admin;
    }

    public void setAdmin(String Admin) {
try{
        String adminQuery = "UPDATE agent SET Administrator = '" + Admin + "' WHERE Agent_ID = " + agentID;
        db.update(adminQuery);
        this.Admin = Admin;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }     }

    public String getEmail() {
        return Results.get("Epost");
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
        return Results.get("Losenord");
    }

    public void setPassword(String password) {
        try{
        String passwordQuery = "UPDATE agent SET Losenord = '" + password + "' WHERE Agent_ID = " + agentID;
        db.update(passwordQuery);
        this.password = password;
       }
        catch(Exception e){
       System.out.println(e.getMessage());
       }  
    }    

    public String getArea() {
        return Results.get("Benamning");
    }

    public void setLocation(Area area) {
        this.area = area;
    }
}
