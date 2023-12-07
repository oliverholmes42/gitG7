/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
public class AlienUtilities {
    private String AUID;  // Alien Utility ID
    private String name;  // Name of the Alien Utility
    private AlienUtilityType type;


    // Constructor with parameters
    public AlienUtilities(String AUID, String name, AlienUtilityType type) {
        this.AUID = AUID;
        this.name = name;
        this.type = type;
    }

    // Getter for AUID
    public String getAUID() {
        return AUID;
    }

    // Setter for AUID
    public void setAUID(String AUID) {
        this.AUID = AUID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }
    
    public AlienUtilityType getType() {
        return type;
    }

    // Setter for type
    public void setType(AlienUtilityType type) {
        this.type = type;
    }
}

