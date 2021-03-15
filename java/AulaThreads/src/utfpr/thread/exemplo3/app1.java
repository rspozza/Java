/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.exemplo3;

import java.util.logging.Level;
import java.util.logging.Logger;

class Thread1 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Thread executando tarefa1");
        }
    }
    
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Thread executando tarefa2");
        }
    }
    
}

/**
 *
 * @author User
 */
public class app1 {

    public static void main(String[] args) {
        Thread t1=new Thread(new Thread1());
        Thread t2=new Thread(new Thread2());
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(app1.class.getName()).log(Level.SEVERE, null, ex);
        }        
        
        System.out.println("Programa Principal Finalizado");
    }
    
}
