package projeto03.thread;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Cliente {
    
    private static Socket socket;
    
    private static DataInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
        
        try {
            
            socket = new Socket("127.0.0.1", 50000);
            
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());
            
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            System.out.print("Digite uma frase: ");
//            String frase = br.readLine();
            String frase = JOptionPane.showInputDialog("Digite uma frase");
            
            saida.writeUTF(frase);
            
            String novaFrase = entrada.readUTF();
            
            System.out.println("Frase recebida do servidor: "+novaFrase);
            
            socket.close();
            
        } catch(Exception e) {
            
        }
        
    }
    
}
