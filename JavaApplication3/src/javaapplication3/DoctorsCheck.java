/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

import java.time.LocalDate;

/**
 *
 * @author mopaj
 */
import java.time.LocalDate;

public class DoctorsCheck {
    private String LID;
    private Boolean isApproved;
    private LocalDate date;

    // Constructor
    public DoctorsCheck(String LID, Boolean isApproved, LocalDate date) {
        this.LID = LID;
        this.isApproved = isApproved;
        this.date = date;
    }

    // Getter for LID
    public String getLID() {
        return LID;
    }

    // Setter for LID
    public void setLID(String LID) {
        this.LID = LID;
    }

    // Getter for isApproved
    public Boolean getIsApproved() {
        return isApproved;
    }

    // Setter for isApproved
    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    // Getter for date
    public LocalDate getDate() {
        return date;
    }

    // Setter for date
    public void setDate(LocalDate date) {
        this.date = date;
    }
}

