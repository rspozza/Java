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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Servidor extends Thread {

    private static ArrayList<BufferedWriter> clientes;
    private static ServerSocket server;
    private String nome;
    private Socket con;
    private InputStream in;
    private InputStreamReader inr;
    private BufferedReader bfr;
    
    public Servidor(Socket con){
        this.con = con;
        try {
            in = con.getInputStream();
            inr = new InputStreamReader(in);
            bfr = new BufferedReader(inr);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void run(){
        OutputStream ou = null;
        try {
            String msg;
            ou = this.con.getOutputStream();
            Writer ouw = new OutputStreamWriter(ou);
            BufferedWriter bfw = new BufferedWriter(ouw);
            clientes.add(bfw);
            nome = msg = bfr.readLine();
            
            while(!"Sair".equalsIgnoreCase(msg) && msg !=null){
                msg = bfr.readLine();
                sendToAll(bfw, msg);
                System.out.println(msg);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    public void sendToAll(BufferedWriter bwSaida, String msg) throws IOException{
        BufferedWriter bwS;
        
        for(BufferedWriter bw: clientes){
            bwS = (BufferedWriter)bw;
            if(!(bwSaida == bwS)){
                bw.write(nome + " -> "+msg+"\r\n");
                bw.flush();
            }
        }
    }
    
    public static void main(String[] args) {
        try {
            server = new ServerSocket(2000);
            clientes = new ArrayList<BufferedWriter>();
            System.out.println("Servidor aguardando requisições...");
            while(true){
                Socket con = server.accept();
                System.out.println("Cliente conectado...");
                new Servidor(con).start();                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
