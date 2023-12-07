/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting {
    private String MID;   // Meeting ID
    private String name;  // Name of the Meeting
    private LocalDate date;  // Date of the Meeting
    private LocalTime time;  // Time of the Meeting

    // Constructor without parameters
    public Meeting() {
    }

    // Constructor with parameters
    public Meeting(String MID, String name, LocalDate date, LocalTime time) {
        this.MID = MID;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    // Getter for MID
    public String getMID() {
        return MID;
    }

    // Setter for MID
    public void setMID(String MID) {
        this.MID = MID;
    }

    // Getter for name
    public String getname() {
        return name;
    }

    // Setter for name
    public void setname(String name) {
        this.name = name;
    }

    // Getter for date
    public LocalDate getDate() {
        return date;
    }

    // Setter for date
    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Getter for time
    public LocalTime getTime() {
        return time;
    }

    // Setter for time
    public void setTime(LocalTime time) {
        this.time = time;
    }
}

