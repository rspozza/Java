/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteEstrutura {

    Random randomico = new Random();

    List<Integer> lista1 = new ArrayList<Integer>();
    List<Integer> lista2 = new ArrayList<Integer>();

    public void preencheLista1() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(TesteEstrutura.class.getName()).log(Level.SEVERE, null, ex);
            }
            lista1.add(randomico.nextInt());
        }
    

    public void preencheLista2() {        
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(TesteEstrutura.class.getName()).log(Level.SEVERE, null, ex);
            }        
        lista2.add(randomico.nextInt());
    }

    public void processar() {
        for (int i = 0; i < 1000; i++) {
            preencheLista1();
            preencheLista2();
        }
    }

    public static void main(String args[]) {
        long tInicial = System.currentTimeMillis();
        TesteEstrutura t = new TesteEstrutura();
        t.processar();
        
        long tFinal = System.currentTimeMillis();

        System.out.println("Tempo total: " + (tFinal - tInicial));
        System.out.println("Tamanho lista1: " + t.lista1.size()
                + ", lista2: " + t.lista2.size());
    }
}
