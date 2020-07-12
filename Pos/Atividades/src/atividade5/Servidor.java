package atividade5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    public static void main(String[] args) {

        try {
            Piada piada = new Piada();

            DatagramSocket dgSocket = new DatagramSocket(40000);

            byte[] msg = new byte[128];

            DatagramPacket dgPacket = new DatagramPacket(msg, msg.length);
            System.out.println("Iniciando servidor na porta 40000");
            while (true) {
                System.out.println("Aguardando conexões...");
                dgSocket.receive(dgPacket);
                
                String solicitacao = new String(dgPacket.getData());
                
                System.out.println("Solicitação recebida");
                
                if (solicitacao.contains("Mande uma piada")) {

                    InetAddress endereco = dgPacket.getAddress();
                    int porta = dgPacket.getPort();

                    msg = new byte[128];

                    String novaPiada = piada.lerPiada();

                    if (novaPiada == null) {
                        novaPiada = "Sem mais piadas para enviar";
                    }

                    msg = novaPiada.getBytes();

                    dgPacket = new DatagramPacket(msg, msg.length, endereco, porta);
                    dgSocket.send(dgPacket);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
