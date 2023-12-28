/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import oru.inf.InfDB;


/**
 *
 * @author mopaj
 */
public class UserSession {
    private static InfDB db;
    private static UserSession instance;
    private int userId;
    private int type;
    private String name;

    private UserSession() {}

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }
    
    public void stopSession() {
        userId = -1;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
    
    public int getType(){
        return type;
    }
    
    public void setType(int type){
        this.type=type;
    }
    
    public String getName(){
        return name;
    }
    
     public void setName(String name){
        this.name = name;
    }
    
    
}

