package utfpr.rmi.exemplo1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String args[]){
        try{
            //Registry registro = LocateRegistry.getRegistry("192.168.2.111", 1099);
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
