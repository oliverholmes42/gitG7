/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import javaapplication3.GUI.MainPage;
import javaapplication3.GUI.addDialogs.RegisterNewAgentDialog;
import javaapplication3.GUI.addDialogs.RegisterNewAlienDialogPopupV2;
import javaapplication3.GUI.addDialogs.RegisterNewAreaDialog;
import javaapplication3.GUI.addDialogs.RegisterNewPasswordDialog;
import javaapplication3.GUI.addDialogs.RegisterNewUtilitiesDialog;
import javaapplication3.GUI.editDialogs.editAgentDialog;
import javaapplication3.GUI.editDialogs.editAlienDialog;
import javaapplication3.GUI.editDialogs.editLocationDialog;
import javaapplication3.GUI.editDialogs.returnEquipmentDialog;
import javaapplication3.GUI.panels.AgentPanel;
import javaapplication3.GUI.panels.AlienPanel;
import javaapplication3.GUI.panels.AlienProfilePanel;
import javaapplication3.GUI.panels.AreaPanel;
import javaapplication3.GUI.panels.EquipmentPanel;
import javaapplication3.GUI.panels.LocationPanel;
import javaapplication3.GUI.panels.ProfilePanel;
import javaapplication3.models.Agent;
import javaapplication3.models.Alien;
import javaapplication3.models.Location;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author vilso
 */
public class PopupHandler {
    
    public static InfDB db = DatabaseConnection.getInstance();

    public static void addNewUtilitesPopup(MainPage Parent) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private PopupHandler(){
        
    }
    
    
    public static void addNewAlienPopup(MainPage Parent, AlienPanel home){
        new RegisterNewAlienDialogPopupV2(Parent, home, true).setVisible(true);
    }
    
    public static void editAlienPopup(MainPage Parent,AlienPanel home , Alien alien){
        new editAlienDialog(Parent,home, true, alien).setVisible(true);
    }
    
    public static void editAgentPopup(MainPage Parent, AgentPanel home, Agent agent) throws InfException{
        new editAgentDialog(Parent, home, true, agent).setVisible(true);
    }
    
    public static void addNewAgentPopup(MainPage Parent, AgentPanel home)throws InfException{
        new RegisterNewAgentDialog(Parent, home, true).setVisible(true);
    }
    
    public static void addNewAreaPopup(MainPage Parent, AreaPanel home) throws InfException{
        new RegisterNewAreaDialog(Parent,home, true).setVisible(true);
    }
    
    public static void addNewUtilitiesPopup(MainPage Parent, EquipmentPanel home) throws InfException{
        new RegisterNewUtilitiesDialog(Parent, home, true).setVisible(true);
    }
    
    public static void addNewPasswordPopup(MainPage Parent, Alien profile, AlienProfilePanel home){
        new RegisterNewPasswordDialog(Parent, profile, true, home).setVisible(true);
    }
    
     public static void addNewPasswordPopup(MainPage Parent, Agent profile, ProfilePanel home){
        new RegisterNewPasswordDialog(Parent, profile, true, home).setVisible(true);
    }
     
     public static void ediitLocationPopup(MainPage Parent, LocationPanel home, Location location) throws InfException{
        new editLocationDialog(Parent, true, home, location).setVisible(true);
    }
     
     public static void returnUtilityPopup(MainPage Parent,EquipmentPanel home) {
         new returnEquipmentDialog(Parent,home, true).setVisible(true);
     }
    
    
}