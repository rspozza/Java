package utfpr.rmi.exemplo1;

import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor{

    
    public static void main(String args[]){
        try{            
            
            Implementacao imp=new Implementacao();
            
            OlaRMI conexao = (OlaRMI)UnicastRemoteObject.exportObject(imp, 0);           
            
            Registry registro = LocateRegistry.createRegistry(1099);
            
            registro.bind("classeOlaMundo", conexao);
            
            System.out.println("Servidor RMI aguardando requisições...");            
        }
        catch(Exception e){
            System.out.println("Exceção remota: " + e);
        }
    }
}