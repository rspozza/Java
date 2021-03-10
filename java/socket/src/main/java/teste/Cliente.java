package teste;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

public class Cliente {

    private static boolean acabouPiadas = false;
    

    public static void main(String[] args) {

        while(!acabouPiadas){
            solicitaPiadaServidor();
        }
        System.out.println("Fim de execução!");

    }

    private static void solicitaPiadaServidor() {

        try {

            DatagramSocket socketCliente = new DatagramSocket();
            InetAddress endereco = InetAddress.getByName("localhost");
            int porta = 7777;
            byte[] mensagemEnvio = new byte[1024];

            //Envio de mensagemEnvio
            String mensagem = "Quero uma piada.";
            mensagemEnvio = mensagem.getBytes();
            DatagramPacket pacoteEnvio = new DatagramPacket(mensagemEnvio, mensagemEnvio.length, endereco, porta);
            socketCliente.send(pacoteEnvio);

            //Recebimento
            byte[] mensagemRecebida = new byte[1024];
            DatagramPacket pacoteRecebido = new DatagramPacket(mensagemRecebida, mensagemRecebida.length);

            socketCliente.receive(pacoteRecebido);

            //String mensagemRetorno = new String(pacoteRecebido.getData());            
            String mensagemRetorno =  new String(pacoteRecebido.getData());                                                
            
            System.out.println(mensagem);            

           if(mensagemRetorno.contains("Sem piadas")){                          
                acabouPiadas = true;
            }else{
                System.out.println("DIFERENTE");
           }

            socketCliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}