/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.monitoramento;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Principal {
    
    public static void main(String[] args) {
        try {
            //new Planta().lerDados(new URL("https://api.thingspeak.com/channels/1306748/fields/1.json?results=2"));
            new Planta().lerDados(new URL("https://api.thingspeak.com/channels/1306748/status.json"));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
