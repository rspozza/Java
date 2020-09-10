package utfpr.rmi.exemplo3;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Servicos extends Remote {
    
    boolean cadastrar(String nome, int ID) throws RemoteException;
    
    String consultar(String nome, int ID) throws RemoteException;
    
}