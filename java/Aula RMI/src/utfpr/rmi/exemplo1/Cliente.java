package utfpr.rmi.exemplo1;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import utfpr.rmi.exemplo2.Validadora;

public class Cliente {
    public static void main(String args[]){
        try{
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);
            
            OlaRMI stub = (OlaRMI) registro.lookup("classeOlaMundo");
            
            String retorno = stub.olaMundo();
            System.out.println("Servidor retornou: "+retorno);
        }
        catch(Exception e){
            System.out.println("Exceção remota: " + e);
        }
    }
}
