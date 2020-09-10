package utfpr.rmi.exemplo3;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Implementacao implements Servicos {

    public List<Usuario> usuarios;
    
    public Implementacao(){
        usuarios = new ArrayList<Usuario>();
    }

    @Override
    public boolean cadastrar(String nome, int ID) throws RemoteException {        
        if (!UserExists(nome, ID)) {
            Usuario user = new Usuario();
            user.setNome(nome);
            user.setId(ID);
            usuarios.add(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String consultar(String nome, int ID) throws RemoteException {        
        if (UserExists(nome, ID))
            return "Retorno da consulta:\n" + nome + "\n" + ID;

        return "Retorno da consulta: Usuario nao encontrado.\n";
    }

    public boolean UserExists(String nome, int ID) {
        for (Usuario user : usuarios) {
            if (user.getNome().equals(nome) && user.getId() == ID) {
                return true;
            }
        }
        return false;
    }
}
