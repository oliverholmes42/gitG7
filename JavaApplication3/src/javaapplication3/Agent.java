/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.time.LocalDate;

public class Agent {
    private int agentID;
    private String name;
    private String telephone;
    private LocalDate recruitmentDate;
    private char Admin;
    private String email;
    private String password;
    private Area area; 

    // Constructor
    public Agent(int agentID, String name, String telephone, LocalDate recruitmentDate, char Admin, String email, String password, Area area) {
        this.agentID = agentID;
        this.name = name;
        this.telephone = telephone;
        this.recruitmentDate = recruitmentDate;
        this.Admin = Admin;
        this.email = email;
        this.password = password;
        this.area = area;
    }

    // Getters and Setters
    public int getAgent_ID() {
        return agentID;
    }

    public void setAgent_ID(int agentID) {
        this.agentID = agentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getRecruitmentDate() {
        return recruitmentDate;
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }

    public char getAdmin() {
        return Admin;
    }

    public void setAdmin(char Admin) {
        this.Admin = Admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Area getArea() {
        return area;
    }

    public void setLocation(Area area) {
        this.area = area;
    }
}
