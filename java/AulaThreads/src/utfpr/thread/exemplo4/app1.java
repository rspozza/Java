
package utfpr.thread.exemplo4;

import java.util.logging.Level;
import java.util.logging.Logger;

// join 

public class app1 {

    private int contador = 0;
    
    public static void main(String[] args) {
        app1 p=new app1();
        p.executaThreads();
    }
    
    public void executarContador(){        
        contador++;
    }
    
    public void executaThreads(){
        
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                utfpr.thread.utils.Utils.gastarTempo(utfpr.thread.utils.Utils.retornaValor(1, 5));
                for(int i=0;i<1000;i++)
                    executarContador();
            }
            
        });
        
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                utfpr.thread.utils.Utils.gastarTempo(utfpr.thread.utils.Utils.retornaValor(1, 3));
                for(int i=0;i<1000;i++)
                    executarContador();
            }
            
        });
        
        t1.start();
        t2.start();       
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(app1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Contador = "+this.contador);
    }
    
}
