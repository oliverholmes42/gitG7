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

public class Quarantine {
    private LocalDate start;
    private LocalDate end;

    // Constructor with parameters
    public Quarantine(LocalDate start, LocalDate end) {
        this.start = start;
        this.end = end;
    }

    // Getter for start date
    public LocalDate getStart() {
        return start;
    }

    // Setter for start date
    public void setStart(LocalDate start) {
        this.start = start;
    }

    // Getter for end date
    public LocalDate getEnd() {
        return end;
    }

    // Setter for end date
    public void setEnd(LocalDate end) {
        this.end = end;
    }
}

