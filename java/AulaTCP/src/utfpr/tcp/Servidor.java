package utfpr.tcp;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static ServerSocket servidor;
    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;
    
    public static void main(String[] args) {
        
        try {
            // iniciar meu servidor
            servidor = new ServerSocket(4000);
            System.out.println("Servidor pronto...");
            
            // receber conexoes
            conexao = servidor.accept();
            entrada = new DataInputStream(conexao.getInputStream());
            String dados = entrada.readUTF();
            
            // realizar o processamento dos pedidos
            dados = dados.toUpperCase();
            
            // enviar respostas ao cliente
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(dados);
            
            // fechar conexao
            conexao.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
