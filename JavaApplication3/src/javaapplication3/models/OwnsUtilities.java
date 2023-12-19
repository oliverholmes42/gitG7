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
    
    private Date uttagningsdatum;
    private Agent agentID;
    private Utilities utilitiesID;

    public OwnsUtilities(Date uttagningsdatum, Agent agentID ,Utilities utilitiesID){ 
        this.uttagningsdatum = uttagningsdatum;
        this.agentID = agentID;
        this.utilitiesID = utilitiesID;
    }
        
    public void setUttagningsDatum(Date uttagningsdatum){
        this.uttagningsdatum = uttagningsdatum;
    }
    
    public Date getUttagningsDatum(){
        return uttagningsdatum;
    }
}    



