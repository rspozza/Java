package br.utfpr.pd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static ServerSocket servidor;
    public static Socket conexao;

    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(2000);
            System.out.println("Servidor pronto");
            while (true) {
                System.out.println("Aguardando conexão...");
                conexao = servidor.accept();
                new Thread_Servidor(conexao).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
