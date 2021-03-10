/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.monitoramento;

import com.angryelectron.thingspeak.*;

public class ThingExample {

    public static void main(String[] args) throws Exception {
        String apiWriteKey = "your-channel-write-key";
        Channel channel = new Channel(1, apiWriteKey);        
        try {            
            // write something
            Entry writeEntry = new Entry();
            writeEntry.setField(1, "Hello");            
            // read it back
            Entry readEntry = channel.getLastChannelEntry();
            System.out.println(readEntry.getField(1));
        } catch(Exception ex) {
            System.out.println(ex);
        } 
    }
    
}