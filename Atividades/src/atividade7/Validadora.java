package atividade7;


import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Validadora extends Remote {
    
    boolean validarPessoa(Pessoa pessoa) throws RemoteException;
    
}
