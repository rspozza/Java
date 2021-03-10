package utfpr.socket.testestress.rmi;

import java.rmi.*;

public interface OlaRMI extends Remote {
    public String olaMundo() throws RemoteException;
}
