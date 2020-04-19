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
public class ContaCorrente implements Conta{

    private int valor = 0;
    
    @Override
    public int getValor() {
        return this.valor;
    }

    @Override
    public void setValor(int valor) {
        this.valor = valor;
    }
    
}
