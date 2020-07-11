/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utfpr.cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author pozza
 */
public class Cliente {
    
    static Socket s;
    static PrintWriter pw;
    
    public static void main(String[] args) {
        try{
            s = new Socket("tutorial", 8000);
            pw = new PrintWriter(s.getOutputStream());
            pw.write("Hello World");
            pw.flush();
            pw.close();
            s.close();
        }catch(UnknownHostException e){
            System.out.println("Fail");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("Fail");
            e.printStackTrace();
        }
    }
    
}
