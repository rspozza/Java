package utfpr.sd.thread.daemon;

public class Principal {       
    
    
    public static void main(String[] args) {        
        Thread t = new Thread(new Thread1());
        t.setDaemon(true);
        t.start();        
        
    }

}
