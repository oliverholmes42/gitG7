/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;




/* Denna fil haterar problematiken kring åtkomster vid inloggning i applikationen. För att kunna identifiera vad för inloggningstyp som angetts
 * och för att kunna se vad för åtkomst som ska ges till den som loggar in, tilldelas varje agentobjekt och alienobjekt ett typ-ID för att programmet
 * ska veta vad för åtkomst som som inloggaren får. */
public class UserSession {

    private static UserSession instance;
    private int userId;
    private int type;
    private String name;

    private UserSession() {
    }

    // Returnerar instansen. Om instansvärdet är null skapas en ny instans istället. 
    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    // Rensar värdet för instansen vid exempelvis utloggning.
    public void stopSession() {
        userId = -1;
    }

    // Setter för userID
    public void setUserId(int userId) {
        this.userId = userId;
    }

    // Getter för userID
    public int getUserId() {
        return userId;
    }

    // Getter för Type
    public int getType() {
        return type;
    }

    // Setter för Type
    public void setType(int type) {
        this.type = type;
    }

    // Getter för namn
    public String getName() {
        return name;
    }

    // Setter för namn
    public void setName(String name) {
        this.name = name;
    }
}
