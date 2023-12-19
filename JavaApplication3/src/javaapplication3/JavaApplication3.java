/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import javaapplication3.utils.loginInputValidation;
import javaapplication3.GUI.LoginPage;
import javaapplication3.models.Area;
import javaapplication3.utils.DatabaseConnection;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Denna fil är huvudprogrammet och hanterar logiken kring hur programmet styrs från start till slut.
 *
 * @author oliver, aiham, albin, vilson
 */
public class JavaApplication3 {

    private static InfDB db;
    
    public static void main(String[] args) throws InfException{
        
        //Initialisering utav databasuppkoppling:
        db = DatabaseConnection.getInstance();
        
        loginInputValidation.db = db; //Kopplar databasen till loginsidan "loginInputValidation".
        new LoginPage().setVisible(true); //Initialiserar loginsidan som förstasida "LoginPage".
        
        Area lol = new Area(1);
        System.out.println(lol.getName());
        
    }
    
}
