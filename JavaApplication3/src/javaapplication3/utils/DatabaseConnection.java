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
public class DatabaseConnection {
    public static InfDB dbInstance;

    private DatabaseConnection() { 
        // Private constructor to prevent external instantiation
    }

    public static InfDB getInstance() {
        if (dbInstance == null) {
            try {
                dbInstance = new InfDB("mibdb", "3306", "mibdba", "mibkey");
            } catch (InfException e) {
                e.printStackTrace();  // Handle exception appropriately
            }
        }
        return dbInstance;
    }
}
