package atividade6;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    public static void enviaMensagem(String mensagem, String ipAddress, int porta) throws IOException {
        DatagramSocket conexao = new DatagramSocket();
        InetAddress grupo = InetAddress.getByName(ipAddress);
        byte[] msg = mensagem.getBytes();
        DatagramPacket packet = new DatagramPacket(msg, msg.length, grupo, porta);
        conexao.send(packet);
        conexao.close();
    }

    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 5; i++) {
            enviaMensagem(i+" mensagem multicast", "230.0.0.0", 10000);
        }
        enviaMensagem("OK", "230.0.0.0", 10000);
    }
}
