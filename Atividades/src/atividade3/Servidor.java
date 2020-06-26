package atividade3;


import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    
    private static Socket conexao;
    private static ServerSocket servidor;
    
    private static ObjectInputStream entrada;
    private static DataOutputStream saida;
    
    public static void main(String[] args) {
   
        String aviso = "Dados recebidos corretamente!";
        
        try {
            System.out.println("Servidor abrindo a porta 50000...");
            servidor = new ServerSocket(50000);
            System.out.println("Servidor aguardando conexões...");
            conexao = servidor.accept();
            
            entrada = new ObjectInputStream(conexao.getInputStream());
            saida = new DataOutputStream(conexao.getOutputStream());
            
            Pessoa p = (Pessoa) entrada.readObject(); 
            System.out.println("Dados Recebidos do cliente:\n");
            System.out.println("Nome: " + p.getNome() + "\nIdade: " + p.getIdade());
            saida.writeUTF(aviso);
            
            conexao.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
