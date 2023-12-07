/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

/**
 *
 * @author aiham
 */
public class Utilities {
    private int Utility_ID;
    private String Description;
    private String Name;

    
    
    public Utilities(int Utility_ID, String Name, String Description){  
        
        this.Utility_ID = Utility_ID;
        this.Name = Name;
        this.Description = Description;

        
    }
    
    public void setName(String Name){
    this.Name = Name;
    }
    
    public void setDescription(String Description){
    this.Description = Description;
    }
    
    public void setUtilityID(int Utility_ID){
    this.Utility_ID = Utility_ID;
    }
    
    
    public String getName(){
    return Name;
    }
    
    public String getDescription(){
    return Description;
    }
    
    public int getID(){
    return Utility_ID;
    }
}
