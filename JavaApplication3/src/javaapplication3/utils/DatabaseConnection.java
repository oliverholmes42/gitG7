/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author mopaj
 */

//Databasklass som skapar kopplingen och används som referens genom hela projektet.
public class DatabaseConnection {
    public static InfDB dbInstance;

    private DatabaseConnection() { 
       
    }
    
    //Hämta nuvarande instance, instancierar om de inte finns
    public static InfDB getInstance() {
        if (dbInstance == null) {
            try {
                dbInstance = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            } catch (InfException e) {
                
            }
        }
        return dbInstance;
    }
}
