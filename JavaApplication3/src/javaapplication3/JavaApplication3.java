/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javaapplication3.utils.loginInputValidation;
import javaapplication3.GUI.LoginPage;
import javaapplication3.models.*;
import javaapplication3.utils.DatabaseConnection;
import javaapplication3.utils.ObjectManager;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Denna fil är huvudprogrammet och hanterar logiken kring hur programmet styrs från start till slut.
 *
 * @author oliver, aiham, albin, vilson
 */
public class JavaApplication3 {

    
    public static void main(String[] args) throws InfException{
        
        //Initialisering utav databasuppkoppling:
        new LoginPage().setVisible(true); //Initialiserar loginsidan som förstasida "LoginPage".
        
        ObjectManager.Agents.LoadList();
        //HashMap<Integer,Agent> map = ObjectManager.Agents.agentList;

        System.out.println(2);
        
         
        
    }
    
}