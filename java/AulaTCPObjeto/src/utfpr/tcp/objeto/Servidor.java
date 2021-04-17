package utfpr.tcp.objeto;


import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    private static Socket socket;
    private static ServerSocket server;
    
    private static ObjectInputStream entrada;
    
    public static void main(String[] args) {
   
        try {
            
            server = new ServerSocket(50000);
            System.out.println("Aguardando requisições...");
            
            socket = server.accept();
            
            entrada = new ObjectInputStream(socket.getInputStream());
            
            Pessoa p = (Pessoa) entrada.readObject(); 
            
            System.out.println("Nome: " + p.getNome() + " Idade: " + p.getIdade());
            
            socket.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
