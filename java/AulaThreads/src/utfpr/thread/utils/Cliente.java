/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.utils;

/**
 *
 * @author User
 */

public class Cliente {
    private String nome;
    private String fone;
    private int idade;

    public Cliente() {
        nome = "não informado";
        fone = "não informado";
        idade = 0;
    }

    public Cliente(String nm, String fon, int id) {
        nome = nm;
        fone = fon;
        idade = id;
    }
    
    public boolean Maior() {
        if (getIdade() >= 18) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }
}
