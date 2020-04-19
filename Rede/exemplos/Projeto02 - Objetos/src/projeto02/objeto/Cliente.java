package projeto02.objeto;


import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {
    
    private static Socket socket;
    
    private static ObjectOutputStream saida;
    
    public static void main(String[] args) {
        
        try {
            
            socket = new Socket("127.0.0.1", 50000);
            
            saida = new ObjectOutputStream(socket.getOutputStream());
            
            Pessoa pessoa = new Pessoa("Henrique", 30);
            
            System.out.println("Enviando objeto Pessoa para o servidor com os dados:\n"+pessoa.getNome()+"\n"+pessoa.getIdade());
            
            saida.writeObject(pessoa);
            
            socket.close();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
