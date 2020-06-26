package atividade1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    private static Socket socket;
    private static ServerSocket server;

    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {

        try {

            //Criar porta de recepção
            server = new ServerSocket(50000);

            System.out.println("Aguardando cliente...");

            socket = server.accept();

            //Criar os fluxos de entrada e saída
            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());

            //Recebimento da string
            String cpf = entrada.readUTF();

            String resultado = "";

            // valida o cpf
            if (validaCpf(cpf)) {
                resultado = "TRUE";
            } else {
                resultado = "FALSE";
            }

            //Envio dos dados (resultado)
            saida.writeUTF(resultado);

            socket.close();

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
