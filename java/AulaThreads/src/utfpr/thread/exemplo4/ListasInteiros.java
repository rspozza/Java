/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.exemplo4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ListasInteiros {
    Object bloquei1 = new Object();
    Object bloquei2 = new Object();

    Random randomico = new Random();

    List<Integer> lista1 = new ArrayList<Integer>();
    List<Integer> lista2 = new ArrayList<Integer>();

    public void acrescentaLista1() {
        synchronized (bloquei1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListasInteiros.class.getName()).log(Level.SEVERE, null, ex);
            }
            lista1.add(randomico.nextInt());
        }
    }

    public void acrescentaLista2() {
        synchronized (bloquei2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(ListasInteiros.class.getName()).log(Level.SEVERE, null, ex);
            }
            lista2.add(randomico.nextInt());
        }
    }

    public void executarListas() {
        for (int i = 0; i < 1000; i++) {
            acrescentaLista1();
            acrescentaLista2();
        }
    }

    public void principal() {

        long tInicial = System.currentTimeMillis();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                executarListas();
            }

        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                executarListas();
            }

        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ListasInteiros.class.getName()).log(Level.SEVERE, null, ex);
        }

        long tFinal = System.currentTimeMillis();
        System.out.println("Tempo total: " + (tFinal - tInicial));
        System.out.println("Lista1 = " + lista1.size()
                + ", Lista2 = " + lista2.size());
    }
}
