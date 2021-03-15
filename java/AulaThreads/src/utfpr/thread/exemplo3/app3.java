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

class Thread4 extends Thread{    
        
    public Thread4(){
        
    }
    
    @Override
    public void run() {
        try{
            for(int i=0;i<1000;i++){
                System.out.println("Executando!!");
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e){
            System.out.println("Thread Interrompida");
        }
    }
    
}


class Thread5 implements Runnable{

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Faça algo!!");
        }
        System.out.println("Terminou!!");
    }
    
}

public class app3 {
    
    public static void main(String[] args) {
        //Thread t1= new Thread(new Thread4());
        //t1.start();
        //t1.interrupt();
        
        Thread  t2=new Thread(new Thread5());
        t2.start();
        utfpr.thread.utils.Utils.gastarTempo(1000);
        t2.interrupt();
    }
    
}
