/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.tcpMessage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Cliente extends Thread{

    private static final long serialVersionUID = 1L;
    private Socket socket;
    private OutputStream ou;
    private Writer ouw;
    private BufferedWriter bfw;
    private String nome = "cliente";
    private String mensagem = "ola mundo";
    
    public Cliente() {

    }

    public void run(){
        this.escutar();
    }
    
    public void conectar() {

        try {
            socket = new Socket("localhost", 2000);
            ou = socket.getOutputStream();
            ouw = new OutputStreamWriter(ou);
            bfw = new BufferedWriter(ouw);
            bfw.write("Cliente \r\n");
            bfw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensagem(String msg) {

        try {
            if (msg.equals("Sair")) {
                bfw.write(nome+" desconectado \r\n");
                System.out.println("Desconectado...");
            }else{
                bfw.write(msg+"\r\n");
                System.out.println(nome+" diz -> "+mensagem);
            }
            bfw.flush();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escutar(){
        try {
            InputStream in = socket.getInputStream();
            InputStreamReader inr = new InputStreamReader(in);
            BufferedReader bfr = new BufferedReader(inr);
            String msg = "";
            
            while(!"Sair".equalsIgnoreCase(msg)){
                if(bfr.ready()){
                    msg = bfr.readLine();
                    if(msg.equals("Sair"))
                        System.out.println("Servidor caiu...");
                    else
                        System.out.println(msg);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public void sair(){
        enviarMensagem("Sair");
        try {
            bfw.close();
            ouw.close();
            ou.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Cliente app = new Cliente();
        app.conectar();
        new Cliente().start();
        app.enviarMensagem("Teste");
        app.sair();
    }

}
