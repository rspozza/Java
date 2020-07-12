package atividade2;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    private Socket conexao;
    private DataInputStream entrada;

    public Servidor(Socket conexao) {
        this.conexao = conexao;
    }

    @Override
    public void run() {        
        String frase;
        
        System.out.println("Atendendo requisição.");
        
        try {
             entrada = new DataInputStream(conexao.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }        

        while (true) {
            try {
                frase = entrada.readUTF();
                if (frase.equalsIgnoreCase("sair")) {
                    System.out.println("Fechando conexão com cliente...");
                    conexao.close();       
                    break;
                } else {
                    System.out.println(frase);
                }
            } catch (IOException e) {
                e.printStackTrace();                
            }
        }

    }

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(50000);
            System.out.println("Servidor escutando a porta 50000...\n\n");            
            while (true) {
                System.out.println("Aguardando conexões...\n\n");
                Socket conexao = server.accept();
                Servidor sThread = new Servidor(conexao);
                System.out.println("Algum cliente se conectou...");
                sThread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
