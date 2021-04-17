/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.socket.sistemas.sudoku;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ThreadVerifica implements Runnable {

    int[] coluna;
    String tipo = "null";
    int valor = 0;

    public ThreadVerifica() {
    }

    public ThreadVerifica(int[] coluna) {
        this.coluna = coluna;
    }

    public ThreadVerifica(String t, int v, int[] coluna) {
        this.tipo = t;
        this.valor = v;
        this.coluna = coluna;
    }

    public boolean verifica() {
        Arrays.sort(coluna);        
        for (int i = 0; i < coluna.length - 1; i++) {
            if (coluna[i] == coluna[i + 1]) {                
                return false;
            }
        }
        return true;
    }

    @Override
    public void run() {
        System.out.println(this.tipo + " - " + this.valor + " = " + this.verifica());
    }

    // métodos auxiliares
    public void exibeMatriz(int[] n) {
        for (int i = 0; i < n.length; i++) {
            System.out.print("[");
            System.out.print(n[i]);
            System.out.println("]");
        }
        System.out.println();
    }

    public void aguarda() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadVerifica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
