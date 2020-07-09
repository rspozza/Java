package projeto03.thread;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread {
    
    private Socket socket;
    
    public Servidor(Socket conexao) {
        this.socket = conexao;
    }
    
    @Override
    public void run() {
        
        try {
            DataInputStream entrada = 
                    new DataInputStream(socket.getInputStream());
            
            String frase = entrada.readUTF();
            
            String novaFrase = frase.toUpperCase();
            System.out.println("Enviando frase para cliente...");
            DataOutputStream saida =
                    new DataOutputStream(socket.getOutputStream());
            
            saida.writeUTF(novaFrase);
            
            socket.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        
        try {
            System.out.println("Abrindo porta 50000...");
            ServerSocket server = new ServerSocket(50000);
            System.out.println("Aceitando conexões...");
            while(true) {
                
                Socket conexao = server.accept();
                Servidor sThread = new Servidor(conexao);
                System.out.println("Algum cliente se conectou...");
                sThread.start();                
            }
        
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
