/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.exemplo2;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class tabelaThread implements Runnable {

    private JTable tabela;
    private int linha;

    public tabelaThread() {
    }

    public tabelaThread(JTable t, int l) {
        this.tabela = t;
        this.linha = l;
    }

    @Override
    public void run() {        
        int valor = utfpr.thread.utils.Utils.retornaValor(50, 500);
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        for (int i = 0; i < 1000; i++) {
            utfpr.thread.utils.Utils.gastarTempo(valor);
            modelo.setValueAt(""+i, linha, 1);
        }
    }

}
