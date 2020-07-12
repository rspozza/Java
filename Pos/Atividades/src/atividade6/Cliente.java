package atividade6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Cliente implements Runnable {

    public static void main(String[] args) {
        Thread t = new Thread(new Cliente());
        t.start();
    }

    public void receiveUDPMessage(String ip, int porta) {
        byte[] buffer = new byte[1024];
        try {
            MulticastSocket socket = new MulticastSocket(10000);
            InetAddress grupo = InetAddress.getByName("230.0.0.0");
            socket.joinGroup(grupo);
            while (true) {
                System.out.println("Aguardando por mensagens...");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), packet.getOffset(), packet.getLength());
                System.out.println("[Mensagem multicast UDP recebida] >> " + msg);
                if ("OK".equals(msg)) {
                    System.out.println("Sem mais mensagens : desconectando... " + msg);
                    break;
                }
            }
            socket.leaveGroup(grupo);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            receiveUDPMessage("230.0.0.0", 10000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
