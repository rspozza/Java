/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.sd.thread;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author pozza
 */
public class MyRunnable implements Runnable {

        private final String url;

        MyRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {

            String result = "";
            int code = 200;
            try {
                URL siteURL = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                code = connection.getResponseCode();
                if (code == 200) {
                    result = "Conectou\t";
                } else if (code == 301) {
                    result = "Invalido HTTP\t";
                } else result = "Código desconhecido: "+code+"\t";
            } catch (Exception e) {
                result = "->Não conectou<-\t";
            }
            System.out.println(url + "\t\tStatus:" + result);
        }
    }
