package utfpr.socket.socket;

import java.io.*;
import java.net.*;

public class Servidor{
public static void main(String args[]) throws IOException{
    ServerSocket servidor=new ServerSocket(5000);
    System.out.println("Aguardando conexão...");
    try{
        Socket conexao=servidor.accept();
        PrintWriter saida = new PrintWriter(conexao.getOutputStream(),true);        
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        System.out.println("Cliente conectado..");
        while(true){
            System.out.println("Enviar mensagem:");
            saida.println(teclado.readLine());
            System.out.println(entrada.readLine());
        }
    }
    finally{}
    }
}
   
