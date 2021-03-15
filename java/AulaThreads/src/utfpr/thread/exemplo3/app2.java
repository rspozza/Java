/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.exemplo3;

/**
 *
 * @author User
 */

class Thread3 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Thread executando...");
        }
    }
    
}


public class app2 {

    public static void main(String[] args) {        
        Thread t1=new Thread(new Thread3());
        t1.setName("Teste");
        t1.setPriority(10);
        t1.start();
        
        utfpr.thread.utils.Utils.mostraDados(t1);
        
    }
    
}
