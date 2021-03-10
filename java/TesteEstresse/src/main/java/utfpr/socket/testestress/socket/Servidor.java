package utfpr.socket.testestress.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static Socket conexao;
    private static ServerSocket servidor;

    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {

        try {

            //Criar porta de recepção
            servidor = new ServerSocket(50000);

            System.out.println("Aguardando cliente...");

            while (true) {
                conexao = servidor.accept();

                //Criar os fluxos de entrada e saída
                entrada = new DataInputStream(conexao.getInputStream());
                saida = new DataOutputStream(conexao.getOutputStream());

                // Recebimento dos dados
                String dado = entrada.readUTF();

                //Envio dos dados (resultado)           
                saida.writeUTF(dado.toUpperCase());
                // fecha conexão
                conexao.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
