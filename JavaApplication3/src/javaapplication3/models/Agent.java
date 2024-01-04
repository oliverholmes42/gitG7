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
    private int agent_ID;
    private String namn;
    private String telefon;
    private LocalDate anstallningsdatum;
    private String administrator;
    private String epost;
    private String losenord;
    private Area omrade;
    public static InfDB db;

    // Constructor
    public Agent(HashMap<String, String> agentMap, Area area) {
        this.agent_ID = Integer.parseInt(agentMap.get("Agent_ID"));
        this.namn = agentMap.get("Namn");
        this.losenord = agentMap.get("Losenord");
        this.telefon = agentMap.get("Telefon");
        this.epost = agentMap.get("Epost");
        this.administrator = agentMap.get("Administrator");
        this.anstallningsdatum = LocalDate.parse(agentMap.get("Anstallningsdatum"));
        this.omrade = area;
    }

    // Getters and Setters
    public int getId() {
        return agent_ID;
    }
  
    
    public void setAgent_ID(int newAgentID) {
        //ObjectManager.Agents.updateField(agent_ID, "Agent_ID" , newAgentID);
        agent_ID= newAgentID;
    }

    public void setName(String newName) {
        //ObjectManager.Agents.updateField(agent_ID, "Namn" , newName);
        namn = newName;
 
    }

    public String getName() {
        return namn;
    }
    
    public String getTelephone() {
        return telefon; 
    }

    public void setTelephone(String newTelephone) {
        //ObjectManager.Agents.updateField(agent_ID, "Telefon", newTelephone);
        telefon = newTelephone;
 
    }

    public LocalDate getRecruitmentDate() {
        return anstallningsdatum;
    }

    public void setRecruitmentDate(LocalDate newRecruitmentDate) {
        //ObjectManager.Agents.updateField(agent_ID, "Anstallningsdatum" , newRecruitmentDate.toString());
        anstallningsdatum = newRecruitmentDate; 
    }

    public String getAdmin(){
        return administrator;
                
    }

    public void setAdmin(String newAdmin) {
        //ObjectManager.Agents.updateField(agent_ID,"Administrator" , newAdmin);
        administrator = newAdmin;
    
    }

    public String getEmail() {
        return epost;
    }

    public void setEmail(String newEmail) {
        //ObjectManager.Agents.updateField(agent_ID, "Epost", newEmail);
        epost = newEmail;

    }

    public String getPassword() {
        return losenord;
    }

    public void setPassword(String newPassword) {
        //ObjectManager.Agents.updateField(agent_ID,"Losenord", newPassword);
        losenord = newPassword;
  
    }    

    public Area getArea() {
        return omrade;
    }

    public void setLocation(Area newArea) {
        //ObjectManager.Agents.updateField(agent_ID,"Omrade", newArea.getId());
        omrade = newArea; 
    }
}
