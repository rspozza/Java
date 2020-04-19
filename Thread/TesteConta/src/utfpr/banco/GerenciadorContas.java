/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.banco;

/**
 *
 * @author pozza
 */
public class GerenciadorContas {
 
    private Conta conta;
    
    public GerenciadorContas(){}
    
    public GerenciadorContas(Conta conta){
        this.conta = conta;
    }
    
    public int getValor(){
        return this.conta.getValor();
    }
    
    public void setValor(int valor){
        this.conta.setValor(valor);
    }
    
}
