/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.utils;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Utils {
    private static Random random = new Random();
    
    public static Long retornaTempo(){
        return System.currentTimeMillis();
    }
    
    public static int processadorCore(){
        return Runtime.getRuntime().availableProcessors();        
    }
    
    public static int retornaValor(int minimo, int maximo){        
        return minimo+random.nextInt(maximo-minimo);
    }
    
    public static int retornaValor(){        
        return random.nextInt();
    }
    
    public static void gastarTempo(int valor){
        try {
            Thread.sleep(valor);
        } catch (InterruptedException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void gastarTempoRandomico(int valor){
        try {            
            Thread.sleep(random.nextInt(valor));
        } catch (InterruptedException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String[] dadosThread(Thread t){
        String[] dados= new String[5];
        dados[0] = t.getName();
        dados[1] = t.getId()+"";
        dados[2] = t.getPriority()+"";
        dados[3] = t.getState()+"";
        dados[4] = t.isAlive()+"";
        return dados;
    }
    
    public static void mostraDados(Thread t){
        String[] dados = dadosThread(t);
        System.out.println("Dados Thread");
        System.out.println("Nome: "+dados[0]);
        System.out.println("ID: "+dados[1]);
        System.out.println("Prioridade: "+dados[2]);
        System.out.println("Estado: "+dados[3]);
        System.out.println("Alive: "+dados[4]);
    }
}
