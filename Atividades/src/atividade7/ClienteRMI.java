package atividade7;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClienteRMI {
    
    public static void main(String[] args) {
        
        try {
            
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
            Validadora stub = (Validadora) registro.lookup("metodosValidadores");
            
            Pessoa p = new Pessoa("João Carlos", 30);
            
            if (stub.validarPessoa(p)){
                System.out.println("Servidor recebeu os dados corretamente");
            }else{
                System.out.println("Ocorreram problemas para enviar os dados");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
