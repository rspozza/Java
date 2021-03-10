/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.diversos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// probing whois.iana.org might give the right
// whois server

public class Dominio {

    public static void main(String[] args) throws IOException {

        var domainName = "amazon.com.br";
        //var whoisServer = "whois.nic.me";
        var whoisServer = "whois.nic.br";
        int port = 43;

        try (var socket = new Socket(whoisServer, port)) {

            try (var writer = new PrintWriter(socket.getOutputStream(), true)) {

                writer.println(domainName);

                try (var reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()))) {

                    String line;

                    while ((line = reader.readLine()) != null) {

                        System.out.println(line);
                    }
                }
            }
        }
    }
}
