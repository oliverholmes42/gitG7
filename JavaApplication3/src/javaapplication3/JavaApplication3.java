/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import javaapplication3.utils.loginInputValidation;
import javaapplication3.GUI.LoginPage;
import java.util.logging.Logger;
import java.util.logging.Level;
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
        try{
            db = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        }catch(InfException e){
            Logger.getLogger(JavaApplication3.class.getName()).log(Level.SEVERE, null, e);
        }
        
        loginInputValidation.db = db; //Kopplar databasen till loginsidan "loginInputValidation".
        new LoginPage(db).setVisible(true); //Initialiserar loginsidan som förstasida "LoginPage".
        
    }
    
}
