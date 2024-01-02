package javaapplication3.models;

import java.util.Date;
import java.util.HashMap;
import static javaapplication3.models.Agent.db;
import oru.inf.InfDB;
import javaapplication3.utils.DatabaseConnection;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template          
 */

/**
 *
 * @author aiham, albin,oliver, vilson
 */
public class OwnsUtilities{
    
    private Date utkvitteringsdatum;
    private Agent agent_ID;
    private Utilities utrustnings_ID;

    public OwnsUtilities(Date uttagningsdatum, Agent agentID ,Utilities utilitiesID){ 
        this.utkvitteringsdatum = uttagningsdatum;
        this.agent_ID = agentID;
        this.utrustnings_ID = utilitiesID;
    }
        
    public void setUttagningsDatum(Date uttagningsdatum){
        this.utkvitteringsdatum = uttagningsdatum;
    }
    
    public Date getUttagningsDatum(){
        return utkvitteringsdatum;
    }
}    



