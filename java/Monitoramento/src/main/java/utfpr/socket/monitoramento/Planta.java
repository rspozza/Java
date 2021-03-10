/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.monitoramento;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author User
 */
public class Planta {

    public void lerDados(URL url) throws MalformedURLException, IOException {
        //URL url = new URL("http://example.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        System.out.println("Soil moisture "+con.getHeaderField("Soil moisture"));
        System.out.println("Name "+con.getHeaderField("Name"));
        System.out.println("Tudo "+con.getResponseMessage());
    }

}
