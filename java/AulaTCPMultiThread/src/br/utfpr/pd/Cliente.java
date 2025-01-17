package br.utfpr.pd;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente {

    public static Socket conexao;
    public static DataInputStream entrada;
    public static DataOutputStream saida;

    public static void main(String[] args) {
        try {
            while (true) {
                conexao = new Socket("localhost", 2000);
                //String informacao = JOptionPane.showInputDialog("Digite seu nome");
                String informacao = "nome";
                saida = new DataOutputStream(conexao.getOutputStream());
                saida.writeUTF(informacao);
                Thread.sleep(2);

                entrada = new DataInputStream(conexao.getInputStream());
                System.out.println("Servidor enviou: " + entrada.readUTF());
                conexao.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
