/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
public class Area {
    private String AID;
    private String name;
    private float size;

    // Parameterless constructor
    public Area() {
    }

    // Constructor with parameters
    public Area(String AID, String name, float size) {
        this.AID = AID;
        this.name = name;
        this.size = size;
    }

    // Getter for AID
    public String getAID() {
        return AID;
    }

    // Setter for AID
    public void setAID(String AID) {
        this.AID = AID;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for size
    public float getSize() {
        return size;
    }

    // Setter for size
    public void setSize(float size) {
        this.size = size;
    }
}

