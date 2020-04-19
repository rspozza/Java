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
public class TestaConta {
    
    public static void main(String[] args) {
        ContaCorrente cc=new ContaCorrente();
        ContaPoupanca cp= new ContaPoupanca();
        GerenciadorContas gc= new GerenciadorContas(cp);
        gc.setValor(10);
        System.out.println("Valor:"+gc.getValor());
                
    }
    
}
