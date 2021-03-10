/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.diversos;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteHora {

    public static void main(String[] args) throws IOException {

        var hostname = "3.br.pool.ntp.org";
        int port = 13;

        try {
            Socket socket = new Socket(hostname, port);
            InputStreamReader reader = new InputStreamReader(socket.getInputStream());
            
            int character;
            
            StringBuilder output = new StringBuilder();
            
            System.out.println("Time is");
            
            while ((character = reader.read()) != -1) {
                output.append((char) character);
            }

            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
