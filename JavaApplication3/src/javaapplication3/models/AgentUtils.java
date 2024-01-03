package javaapplication3.models;

import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template          
 */

/**
 *
 * @author aiham, albin,oliver, vilson
 */

    
    public class AgentUtils {
    private Agent agent;
    private Utilities utility;
    private LocalDate borrowingDate;

    public AgentUtils(Agent agent, Utilities utility, LocalDate borrowingDate) {
        this.agent = agent;
        this.utility = utility;
        this.borrowingDate = borrowingDate;
    }

    // Getters and setters
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Utilities getUtility() {
        return utility;
    }

    public void setUtility(Utilities utility) {
        this.utility = utility;
    }

    public LocalDate getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(LocalDate borrowingDate) {
        this.borrowingDate = borrowingDate;
    }
}




