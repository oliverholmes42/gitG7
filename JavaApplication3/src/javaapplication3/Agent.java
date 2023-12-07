/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
public class Agent {
    private String name;
    private String AGID;
    private String email;
    private String password;
    
    public Agent(String name,String ID, String email, String password)
    {
        this.name = name;
        this.AGID = ID;
        this.email = email;
        this.password = password;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for AGID
    public String getAGID() {
        return AGID;
    }

    // Setter for AGID
    public void setAGID(String AGID) {
        this.AGID = AGID;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
    
}