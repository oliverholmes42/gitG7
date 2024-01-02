/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3.utils;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.GUI.panels.AlienPanel;
import javaapplication3.GUI.panels.LocationPanel;
import javaapplication3.models.Alien;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;
import static javaapplication3.GUI.panels.AlienPanel.tableModel;
import javaapplication3.models.Area;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;


/**
 *
 * @author vilso
 */
public class ResultTableManager {
    
    public static InfDB db;
    
    
    //Denna del av filen tillhör AlienPanel
    
    //Filtreringsmetod
    public static void createQueryUsingFilters(JComboBox area, JComboBox race, JComboBox year, JComboBox month) throws InfException{
        for (Alien item : ObjectManager.Aliens.alienList.values()) {

            if (item.getLocation().getName() == area.getSelectedItem() || area.getSelectedIndex() == 0) {
                if (Integer.toString(item.getRegistrationDate().getYear()).equals(year.getSelectedItem()) || year.getSelectedIndex() == 0) {
                    if (item.getRegistrationDate().getMonthValue() == month.getSelectedIndex() || month.getSelectedIndex() == 0) {
                        String[] row = {
                            Integer.toString(item.getID()),
                            "",
                            item.getName(),
                            item.getTelephone(),
                            item.getEmail(),
                            item.getRegistrationDate().toString(),
                            item.getLocation().getName(),
                            item.getResponsibleAgent().getName()
                        };

                        AlienPanel.tableModel.addRow(row);
                    }
                }
            }
        }
    }
    //Rensa-filter-knappen
    public static void clearFilterMethod(JComboBox area, JComboBox race, JComboBox year, JComboBox month){
        area.setSelectedIndex(0);
        race.setSelectedIndex(0);
        year.setSelectedIndex(0);
        month.setSelectedIndex(0);
    }
    //Startar upp tabellen med all generell information
    public static void loadTableForAliens(){
        for (Alien item : ObjectManager.Aliens.alienList.values()) {
            String[] row = {
                Integer.toString(item.getID()),
                "",
                item.getName(),
                item.getTelephone(),
                item.getEmail(),
                item.getRegistrationDate().toString(),
                item.getLocation().getName(),
                item.getResponsibleAgent().getName()
            };
            tableModel.addRow(row);
        }
    }
    //Ställer in rätt årsspann för vilka registreringsdatum som finns i databasen
    public static void addYearsToComboBoxMethod(JComboBox selectedYear){
        int minYear = Integer.MAX_VALUE;
        int maxYear = Integer.MIN_VALUE;

        for (Alien alien : ObjectManager.Aliens.alienList.values()) {
            LocalDate registrationDate = alien.getRegistrationDate();
            int year = registrationDate.getYear();

            if (year < minYear) {
                minYear = year;
            }
            if (year > maxYear) {
                maxYear = year;
            }
        }
        //Lägg till alla år mellan det lägsta och högsta värdet i JComboBoxen
        for (int year = minYear; year <= maxYear; year++) {
            selectedYear.addItem(Integer.toString(year));
        }
    }

///////////////////////////////////////////////////////////////////////////////////
    
    //Denna del av filen tillhör RegisterNewAlienPopupV2
    
    /*
    //Denna metod ska hantera innehållet från formuläret och skicka in det i databasen som en ny alien
    public static void registerNewAlienConfirm(JTextField name, JTextField email, JTextField number, JLabel dynamicText, JComboBox area, JComboBox agent, JComboBox race, JSpinner value) throws InfException{
        int newAlienID = Integer.parseInt(db.fetchSingle("SELECT MAX(Alien_ID) FROM alien"))+1;
        LocalDate localdate = LocalDate.now();
        String dateNow = localdate.toString();
        String column = getColumn(dynamicText.getText());
        
        
        if (name.getText().isEmpty() || email.getText().isEmpty() || number.getText().isEmpty() || agent.getEditor().getItem().toString().isEmpty() || area.getEditor().getItem().toString().isEmpty()){
            if(race.getEditor().getItem().toString().isEmpty()){
                JOptionPane.showMessageDialog(null, "Vänligen ange information om Alien du vill registrera med detta formulär");
            }
        } else{
            String query = "INSERT INTO alien (Alien_ID, Namn, Telefon, Epost, Registreringsdatum, Plats, Ansvarig_Agent) VALUES (" + newAlienID + name.getText() + number.getText() + email.getText() + dateNow + area.getEditor().getItem().toString() + agent.getEditor().getItem().toString() + ")";
             db.insert(query);
            if (!column.equals("null")){
                String secondQuery = "INSERT INTO " + race.getEditor().getItem().toString() + " (Alien_ID, "+ column +") VALUES ("+ newAlienID + value +")";
                db.insert(secondQuery);
            }
        }
        ObjectManager.Aliens.createNew(map, location, agent);
    }*/
    
    private static String getColumn(String column){
        switch (column){
            case "Antal Boogies:":
                return "Antal_Boogies";
            case "Antal Armar:":
                return "Antal_Armar";
            case "Ange längd (m):":
                return "Langd";
            default:
                return "null";
        }
    }
    
    //När man väljer vilken art av alien man ska registrera så kommer det upp olika alternativ
    public static void activateValueInputForSpecies(JComboBox race, JLabel text, JSpinner value){
        
        if(race.getSelectedIndex() == 0){
                text.setText("Antal Boogies:");
                text.setVisible(true);
                value.setVisible(true);
                value.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 20.0d, 1d));
            }
            if(race.getSelectedIndex() == 1){
                text.setText("Antal Armar:");
                text.setVisible(true);
                value.setVisible(true);
                value.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 20.0d, 1d));
            }
            if(race.getSelectedIndex() == 2){
                text.setText("Ange längd (m):");
                text.setVisible(true);
                value.setVisible(true);
                value.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, 20.0d, 0.1d));
            }
        
    }    
}
    


