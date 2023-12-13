/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication3;

import java.util.logging.Logger;
import java.util.logging.Level;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * 
 *
 * @author mopaj
 */
public class JavaApplication3 {

    private static InfDB db;
    
    public static void main(String[] args) throws InfException{
        
        //Initializing the connection for the database MiB_DATABASE:
        try{
            db = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        }catch(InfException e){
            Logger.getLogger(JavaApplication3.class.getName()).log(Level.SEVERE, null, e);
        }
        loginInputValidation.db = db;
        new LoginPage(db).setVisible(true);
        
        
    }
    
}
