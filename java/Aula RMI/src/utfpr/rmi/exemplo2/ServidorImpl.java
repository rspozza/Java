package utfpr.rmi.exemplo2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class ServidorImpl implements Validadora{
    
    public ServidorImpl() {       
    }

    @Override
    public boolean validarCPF(String CPF) throws RemoteException {
        return CPF.length() == 11;
    }

    @Override
    public String maiorMenorZero(int valor) throws RemoteException {
        if(valor>0) {
            return "maior que zero!";
        } else
            return "menor ou igual a zero!";           
    }

    public static void main(String[] args) {
        try {
            
            ServidorImpl s = new ServidorImpl();
            
            Validadora stub = (Validadora)UnicastRemoteObject.exportObject(s, 0);           
            
            Registry registro = LocateRegistry.createRegistry(1099);
            
            registro.bind("metodosValidadores", stub);
            
            System.out.println("Servidor RMI está pronto!");
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
