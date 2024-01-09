/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;
import javaapplication3.GUI.LoginPage;
import oru.inf.InfException;

/**
 * Denna fil är huvudprogrammet och hanterar logiken kring hur programmet styrs från start till slut.
 *
 * @author oliver, aiham, albin, vilson
 */
public class JavaApplication3 {

    
    public static void main(String[] args) throws InfException{
        
        System.out.println(2);
        
        //Initialisering utav databasuppkoppling:
        new LoginPage().setVisible(true); //Initialiserar loginsidan som förstasida "LoginPage".
        

        System.out.println(2);
        
         
        
    }
    
}