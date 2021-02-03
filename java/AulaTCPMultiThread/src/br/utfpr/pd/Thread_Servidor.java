package br.utfpr.pd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Servidor extends Thread {

    public Socket conexao_cli;
    public DataInputStream entrada;
    public DataOutputStream saida;
    
    public Thread_Servidor(Socket cnx){
        conexao_cli = cnx;
    }
    
    @Override
    public void run() {

        try {
            entrada = new DataInputStream(conexao_cli.getInputStream());
            String dados = entrada.readUTF();
            
            dados = dados.toUpperCase();
            
            saida = new DataOutputStream(conexao_cli.getOutputStream());
            saida.writeUTF(dados);
            conexao_cli.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Thread_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
