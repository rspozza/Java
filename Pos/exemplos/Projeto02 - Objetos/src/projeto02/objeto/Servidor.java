package projeto02.objeto;


import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    private static Socket socket;
    private static ServerSocket server;
    
    private static ObjectInputStream entrada;
    
    public static void main(String[] args) {
   
        try {
            System.out.println("Abrindo porta 50000...");
            server = new ServerSocket(50000);
            
            System.out.println("Aguardando requisições...");
            
            socket = server.accept();
            
            entrada = new ObjectInputStream(socket.getInputStream());
            
            Pessoa p = (Pessoa) entrada.readObject(); 
            
            System.out.println("Recebeu dados do objeto Pessoa de cliente");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++");
            
            System.out.println("Nome:\t " + p.getNome() + "\nIdade:\t " + p.getIdade());
            
            System.out.println("\nEncerrando servidor...");
            
            socket.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
