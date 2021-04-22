/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.tcp.objeto;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author User
 */
public class ObjServidor {

    private static Socket socket;
    private static ServerSocket server;
    private static ObjectInputStream entrada;

    public static void main(String[] args) {

        try {

            server = new ServerSocket(50000);
            System.out.println("Aguardando requisições...");
            socket = server.accept();
            while (true) {

                entrada = new ObjectInputStream(socket.getInputStream());

                ObjCliente p = (ObjCliente) entrada.readObject();
                System.out.println("================================================");
                System.out.println("Nome: " + p.getNome() + "\nEndereço: " + p.getEndereco()+"\n\n");                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
