/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.models;

/**
 *
 * @author aiham
 */
public class Utilities {
    private String UtilityID;
    private String Name;

    
    
    public Utilities(String UtilityID, String Name, String Description){  
        
        this.UtilityID = UtilityID;
        this.Name = Name;

    }
    
    public void setName(String Name){
    this.Name = Name;
    }
    
    public void setUtilityID(String UtilityID){
    this.UtilityID = UtilityID;
    }
     
    public String getName(){
    return Name;
    }
    
    public String getID(){
    return UtilityID;
    }
}
