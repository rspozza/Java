package projeto01.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Servidor {
    
    private static Socket socket;
    private static ServerSocket server;
    
    private static DataInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
        
        try {
        
    //Criar porta de recepção
            server = new ServerSocket(50000);
            socket = server.accept();
            System.out.println("Aguardando requisições...");
    
    //Criar os fluxos de entrada e saída
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());
            
    //Recebimento do valor inteiro
            int valor = entrada.readInt();            
            System.out.println("Recebeu o valor "+valor+" do cliente.");
    
    //Processamento do valor
            String resultado = "";
            if(valor > 0)
                resultado = "O valor enviado é maior que 0";
            else
                resultado = "O valor enviado é menor que 0";
    
    
    //Envio dos dados (resultado)
            saida.writeUTF(resultado);
            System.out.println("Desligando o servidor...");
            socket.close();
            
        } catch(Exception e) {
            
        }
        
    }
    
    
    

    
}
