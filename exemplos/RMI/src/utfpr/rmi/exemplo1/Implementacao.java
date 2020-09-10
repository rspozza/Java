package utfpr.rmi.exemplo1;

import java.rmi.RemoteException;

public class Implementacao implements OlaRMI{

    @Override
    public String olaMundo() throws RemoteException {
        return "Ola Mundo";
    }
    
}
