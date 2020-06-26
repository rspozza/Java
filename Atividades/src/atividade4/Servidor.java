package atividade4;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    public void run() {
        try{
        entrada = new ObjectInputStream(conexao.getInputStream());
        saida = new DataOutputStream(conexao.getOutputStream());

        Pessoa p = (Pessoa) entrada.readObject();
        System.out.println("Dados Recebidos do cliente:\n");
        System.out.println("Nome: " + p.getNome() + "\nIdade: " + p.getIdade());
        saida.writeUTF("Dados recebidos corretamente!");

        conexao.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static Socket conexao;
    private static ServerSocket servidor;

    private ObjectInputStream entrada;
    private DataOutputStream saida;

    public static void main(String[] args) {        

        try {
            System.out.println("Servidor abrindo a porta 50000...");
            servidor = new ServerSocket(50000);                        
            while(true){
                System.out.println("Servidor aguardando conexões...");
                conexao = servidor.accept();
                System.out.println("Cliente se conectou...");
                new Servidor().start();
            }            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
