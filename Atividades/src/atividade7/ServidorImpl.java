package atividade7;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorImpl implements Validadora{
    
    Pessoa p;
    
    public ServidorImpl() {}

    @Override
    public boolean validarPessoa(Pessoa pessoa) throws RemoteException {
        this.p = pessoa;
        System.out.println("Nome: "+p.getNome()+"\nIdade: "+p.getIdade());
        return true;
    }

    public static void main(String[] args) {
        try {
            
            ServidorImpl s = new ServidorImpl();
            
            Validadora stub = (Validadora)UnicastRemoteObject.exportObject(s, 0);
           
            
            Registry registro = LocateRegistry.createRegistry(1099);
            
            registro.bind("metodosValidadores", stub);
            
            System.out.println("Servidor aguardando requisições...");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
