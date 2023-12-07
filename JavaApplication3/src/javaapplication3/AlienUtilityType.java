/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
public class AlienUtilityType {
    private String AUTID;  // Alien Utility Type ID
    private String name;   // Name of the Alien Utility Type


    // Constructor with parameters
    public AlienUtilityType(String AUTID, String name) {
        this.AUTID = AUTID;
        this.name = name;
    }

    // Getter for AUTID
    public String getAUTID() {
        return AUTID;
    }

    // Setter for AUTID
    public void setAUTID(String AUTID) {
        this.AUTID = AUTID;
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

