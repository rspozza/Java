package atividade8;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Validadora extends Remote{

	boolean validarCpf(String CPF) throws RemoteException;
	
}
