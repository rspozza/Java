package br.utfpr.pd;

import static br.utfpr.pd.Servidor.conexao;
import static br.utfpr.pd.Servidor.servidor;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor_Simples {

    public static ServerSocket servidor;
    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            servidor = new ServerSocket(2000);
            System.out.println("Servidor pronto");
            while (true) {
                System.out.println("Aguardando conexão...");
                conexao = servidor.accept();

                entrada = new DataInputStream(conexao.getInputStream());
                String dados = entrada.readUTF();

                dados = dados.toUpperCase();

                saida = new DataOutputStream(conexao.getOutputStream());
                saida.writeUTF(dados);
                conexao.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
