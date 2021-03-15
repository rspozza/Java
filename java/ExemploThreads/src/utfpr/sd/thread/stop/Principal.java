
package utfpr.sd.thread.stop;

public class Principal {
    
    public static void main(String[] args) {
        
        Thread2 t1 = new Thread2();
        t1.start();
        t1.interrupt();
    }
    
    
}

















