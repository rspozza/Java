package utfpr.rmi.exemplo2;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ClienteRMI {
    
    public static void main(String[] args) {
        
        try {
            
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
            Validadora stub = (Validadora) registro.lookup("metodosValidadores");
            
            System.out.print("O CPF 05342888876 está ");
            if (stub.validarCPF("05342888876")){
                System.out.println("correto!");
            }else{
                System.out.println("incorreto!");
            }
            System.out.println("O número 10 é " + stub.maiorMenorZero(10));
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
