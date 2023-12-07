/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author mopaj
 */
public class Planet {
    private String PID;
    private String name;
    private String politicStatus;
    private String peaceStatus;
    
    public Planet(String ID, String name, String politicStatus, String peaceStatus)
    {
        this.PID = ID;
        this.name = name;
        this.politicStatus = politicStatus;
        this.peaceStatus = peaceStatus;
    }
    
    public void setPID(String ID)
    {
        this.PID = ID;
    }
    
    public String getPID()
    {
        return PID;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setpoliticStatus(String politicStatus)
    {
        this.politicStatus = politicStatus;
    }
    
    public String politicStatus()
    {
        return politicStatus;
    }
    
    public void setPeaceStatus(String peaceStatus)
    {
        this.peaceStatus = peaceStatus;
    }
    
    public String getPeaceStatus()
    {
        return peaceStatus;
    }
    
    
}
