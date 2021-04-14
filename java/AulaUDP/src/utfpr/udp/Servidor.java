package utfpr.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Servidor {
    
    public static DatagramSocket dgSocket;
    public static DatagramPacket dgPacket;
    
    public static InetAddress endereco;
    
    private static final String nome = "Universidade Tecnológica Federal do Paraná";
    
    public static void main(String[] args) {
        
        try { 
        
            dgSocket = new DatagramSocket(10000);
        
            byte[] msg = new byte[128];
            
            dgPacket = new DatagramPacket(msg, msg.length);
            
            System.out.println("Servidor pronto...");
            
            dgSocket.receive(dgPacket);
            
            String solicitacao = new String(dgPacket.getData());
            
            if(solicitacao.contains("Meu nome")) {
                
                endereco = dgPacket.getAddress();
                int porta = dgPacket.getPort();
                
                System.out.println("IP recebido do cliente: "+endereco.toString());                
                System.out.println("Porta recebida do cliente: "+porta);                
                                
                msg = new byte[128];                
                msg = nome.getBytes();
                
                dgPacket = new DatagramPacket(msg, msg.length, endereco, porta);                
                dgSocket.send(dgPacket);
                
            }
            
        } catch(Exception e) {
            
        }
    }
    
}
