package utfpr.rmi.exemplo1;

import java.rmi.*;

public interface OlaRMI extends Remote {
    public String olaMundo() throws RemoteException;
}
