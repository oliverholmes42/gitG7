/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package javaapplication3.utils;
 
 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import javax.xml.bind.DatatypeConverter;







/**
 *
 * @author mopaj
 */
public class textSender {
     static void sendSMS (String receiver, String message) {
    try {
        // Construct POST data
        String data = URLEncoder.encode("from", "UTF-8") + "=" + URLEncoder.encode("MIBAdmin", "UTF-8");
        data += "&" + URLEncoder.encode("to", "UTF-8") + "=" + URLEncoder.encode(receiver, "UTF-8");
        data += "&" + URLEncoder.encode("message", "UTF-8") + "=" + URLEncoder.encode(message, "UTF-8");
    
        // Make HTTP POST request
        URL url = new URL("https://api.46elks.com/a1/SMS");
        URLConnection conn = url.openConnection();

        String username = "a5a5e1e4871c69f3df8c93e4acf832c15";
        String password = "6BD60977D92372A7149F067B9FF94D8A";
        String base64string = DatatypeConverter.printBase64Binary((username + ":" + password).getBytes("UTF-8"));
        String basicAuth = "Basic " + base64string;
        conn.setRequestProperty("Authorization", basicAuth);
        conn.setRequestProperty("Content-Length", Integer.toString(data.getBytes("UTF-8").length));
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();

        // Handle response data here (currently, just print out response)
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
          System.out.println(line);
        }
        wr.close();
        rd.close();
    } catch (Exception e) {
    }
  }
    
    public static void main(String[] args) {
        sendSMS("+46733572208","Välkommen Agent!\nDitt Lösenord är: 'HibGfqP'\nSpara detta på en säker plats.\n\nMIB");
    
    }
    
}
