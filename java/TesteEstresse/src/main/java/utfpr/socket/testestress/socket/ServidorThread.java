/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.testestress.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author User
 */
public class ServidorThread extends Thread {

    private static Socket conexao;
    private static ServerSocket servidor;

    private DataInputStream entrada;
    private DataOutputStream saida;    

    
    public void run() {
        try {
            entrada = new DataInputStream(conexao.getInputStream());
            saida = new DataOutputStream(conexao.getOutputStream());

            // Recebimento dos dados
            String dado = entrada.readUTF();
            
            //Envio dos dados (resultado)           
            saida.writeUTF(dado.toUpperCase());
            // fecha conexão
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    public static void main(String[] args) {

        try {
            System.out.println("Servidor abrindo a porta 50000...");
            servidor = new ServerSocket(50000);
            while (true) {
                System.out.println("Servidor aguardando conexões...");
                conexao = servidor.accept();
                System.out.println("Cliente se conectou...");
                new ServidorThread().start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static boolean validaCpf(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }

        return calculoDigito(cpf);
    }

    private static boolean calculoDigito(String cpf) {
        int soma, resto;

        for (int dg = 0; dg < 2; dg++) {
            soma = 0;
            resto = 0;

            for (int cont = 0; cont < cpf.length() - (2 - dg); cont++) {
                soma += ((10 + dg) - cont) * (Character.getNumericValue(cpf.charAt(cont)));
            }

            resto = soma % 11;

            if (resto < 2) {
                // digito menor que dois é igual a zero
                if (Character.getNumericValue(cpf.charAt(cpf.length() - (2 - dg))) == 0) {
                    continue;
                } else {
                    return false;
                }
            } else {
                int digito = Character.getNumericValue(cpf.charAt(cpf.length() - (2 - dg)));

                int sub = 11 - resto;

                if (sub == digito) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
    
}
