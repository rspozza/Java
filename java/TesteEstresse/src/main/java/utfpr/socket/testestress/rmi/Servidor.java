package utfpr.socket.testestress.rmi;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor implements OlaRMI{

    @Override
    public String olaMundo() throws RemoteException {
        return("Ola clienteRMI Local!");
    }
    
    public static void main(String args[]){
        try{
            Servidor serv = new Servidor();
            
            OlaRMI conexao = (OlaRMI)UnicastRemoteObject.exportObject(serv, 0);           
            
            Registry registro = LocateRegistry.createRegistry(1099);
            
            registro.bind("classeOlaMundo", conexao);
            
            System.out.println("Servidor RMI aguardando requisições...");
            
        }
        catch(Exception e){
            System.out.println("Exceção remota: " + e);
        }
    }
}