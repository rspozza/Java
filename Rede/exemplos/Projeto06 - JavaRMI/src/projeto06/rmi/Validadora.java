package projeto06.rmi;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Validadora extends Remote {
    
    boolean validarCPF(String CPF) throws RemoteException;
    
    String maiorMenorZero(int valor) throws RemoteException;
    
}
