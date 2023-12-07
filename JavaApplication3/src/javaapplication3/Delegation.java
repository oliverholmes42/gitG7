/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
public class Delegation {
    private String DID;  // Delegation ID
    private String name; // Name of the Delegation


    // Constructor with parameters
    public Delegation(String DID, String name) {
        this.DID = DID;
        this.name = name;
    }

    // Getter for DID
    public String getDID() {
        return DID;
    }

    // Setter for DID
    public void setDID(String DID) {
        this.DID = DID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
}

