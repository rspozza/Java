
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class BatePapo extends Thread {
    
    private static String usuario = null;
    private static InetAddress endereco;
    private static int porta;
    
    @Override
    public void run() {
        
        try {
            
            byte[] msg = new byte[128];
            
            MulticastSocket socket = new MulticastSocket(porta);
            
            socket.joinGroup(endereco);
            
            while(true) {
                
                DatagramPacket dgPacket =
                        new DatagramPacket(msg, msg.length);
                
                socket.receive(dgPacket);
                
                String mensagem = new String(dgPacket.getData());
                
                if(!mensagem.contains(usuario)) {
                    System.out.println("\n" + mensagem + "\n");
                    System.out.print("Digite a mensagem: ");
                }
                
                msg = new byte[128];
                
            }
            
        } catch(Exception e) {
            
        }
        
    }
    
    public static void main(String[] args) {
        
        if(args.length != 2) {
            System.out.println("Parametros estão incorretos!\n java BatePapo <endereco_multicast> <porta>");
            System.exit(1);
        }
        
        try {
            
            porta = Integer.parseInt(args[1]);
            endereco = InetAddress.getByName(args[0]);
            
            BatePapo bp = new BatePapo();
            bp.start();
            
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            
            System.out.print("Digite o seu nome: ");
            usuario = br.readLine();
            
            MulticastSocket socket = new MulticastSocket();
            socket.joinGroup(endereco);
            
            byte[] msg = new byte[128];
            
            while(true) {
                
                System.out.print("Digite a mensagem: ");
                String mensagem = br.readLine();
                
                if(mensagem.equals("sair")) {
                    System.exit(0);
                }
                
                mensagem = usuario + " diz: " + mensagem;
                
                msg = mensagem.getBytes();
                
                DatagramPacket dgPacket =
                        new DatagramPacket(msg, msg.length, endereco, porta);
                
                socket.send(dgPacket);
            }
            
            
            
        } catch(Exception e) {
            
        }
        
    }
    
    
}
