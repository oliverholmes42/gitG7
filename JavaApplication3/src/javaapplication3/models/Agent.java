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
import javaapplication3.utils.ObjectManager;

public class Agent {
    private int agentID;
    private String name;
    private String telephone;
    private LocalDate recruitmentDate;
    private String admin;
    private String email;
    private String password;
    private Area area;
    public static InfDB db;

    // Constructor
    public Agent(HashMap<String, String> agentMap, Area area) {
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
  
    
    public void setAgent_ID(int newAgentID) {
        ObjectManager.Agents.updateField(agentID, "Agent_ID" , newAgentID);
        agentID= newAgentID;
    }

    public void setName(String newName) {
        ObjectManager.Agents.updateField(agentID, "Namn" , newName);
        name = newName;
 
    }

    public String getName() {
        return name;
    }
    
    public String getTelephone() {
        return telephone; 
    }

    public void setTelephone(String newTelephone) {
        ObjectManager.Agents.updateField(agentID, "Telefon", newTelephone);
        telephone = newTelephone;
 
    }

    public LocalDate getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(LocalDate newRecruitmentDate) {
        ObjectManager.Agents.updateField(agentID,"Anstallningsdatum" , newRecruitmentDate);
        recruitmentDate = newRecruitmentDate; 
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String newAdmin) {
        ObjectManager.Agents.updateField(agentID,"Administrator" , newAdmin);
        admin = newAdmin;
    
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        ObjectManager.Agents.updateField(agentID, "Epost", newEmail);
        email = newEmail;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        ObjectManager.Agents.updateField(agentID,"Losenord", newPassword);
        password = newPassword;
  
    }    

    public Area getArea() {
        return area;
    }

    public void setLocation(Area newArea) {
        ObjectManager.Agents.updateField(agentID,"Omrade", newArea);
        area = newArea; 
    }
}
