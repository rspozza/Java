package atividade2;



import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Cliente {

    private static Socket socket;

    private static DataInputStream entrada;
    private static DataOutputStream saida;

    public static void main(String[] args) {

        try {

            socket = new Socket("127.0.0.1", 50000);

            entrada = new DataInputStream(socket.getInputStream());
            saida = new DataOutputStream(socket.getOutputStream());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String frase = "";

            while (!frase.equals("sair")) {
                System.out.print("\nDigite uma frase: ");
                frase = br.readLine();                
                saida.writeUTF(frase);
            }

            System.out.println("Fechando conexão com servidor");

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
