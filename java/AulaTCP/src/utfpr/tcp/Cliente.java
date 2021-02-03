package utfpr.tcp;

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
            // conectar com servidor
            conexao = new Socket("localhost",4000);
            
            // enviar dados ao servidor
            String dados = JOptionPane.showInputDialog("Digite o seu nome");
            saida = new DataOutputStream(conexao.getOutputStream());
            saida.writeUTF(dados);
            
            // receber resposta do servidor
            entrada = new DataInputStream(conexao.getInputStream());
            String resultado = entrada.readUTF();
            
            // exibir dados ao cliente
            System.out.println("Dados recebidos : "+resultado);
            
            // fechar conexao
            conexao.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
