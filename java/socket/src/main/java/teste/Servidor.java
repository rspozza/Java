package teste;



import java.io.IOException;
import java.net.*;

public class Servidor {

    //private static final String PIADA = "O que cai em pé e corre deitado? R: A chuva!";
    private static final String PIADA = "Sem piadas";

    public static void main(String[] args) throws IOException {

        DatagramSocket serverSocket = new DatagramSocket(7777);
        byte[] mensagem = new byte[1024];

        while(true) {
            DatagramPacket pacoteReceber = new DatagramPacket(mensagem, mensagem.length);

            serverSocket.receive(pacoteReceber);

            String msg = new String(pacoteReceber.getData());
            System.out.println("A mensagem recebida eh: " + msg);

            InetAddress inetAddress = pacoteReceber.getAddress();
            int porta = pacoteReceber.getPort();

            mensagem = PIADA.getBytes();

            DatagramPacket pacoteEnviar = new DatagramPacket(mensagem, mensagem.length, inetAddress, porta);

            serverSocket.send(pacoteEnviar);
        }

    }

}
