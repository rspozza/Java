package utfpr.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Cliente {
    
    public static DatagramSocket dgSocket;    
    public static DatagramPacket dgPacket;
    
    public static InetAddress endereco;
    
    public static void main(String[] args) {
        
        try {
            
            dgSocket = new DatagramSocket();
            byte[] msg = new byte[128];
            
            String solicitacao = "Meu nome";
            msg = solicitacao.getBytes();
            
            endereco = InetAddress.getByName("localhost");
            
            dgPacket =  new DatagramPacket(msg, msg.length, endereco, 10000);
            
            dgSocket.send(dgPacket);  
            
            System.out.println("Mensagem enviada...");
            
            msg = new byte[128];
            
            dgPacket = new DatagramPacket(msg, msg.length);
            
            dgSocket.receive(dgPacket);
            
            String nome = new String(dgPacket.getData());
            System.out.println("Meu nome é: " + nome);
            
            
        } catch(Exception e) {
            
        }
        
    }
    
}
