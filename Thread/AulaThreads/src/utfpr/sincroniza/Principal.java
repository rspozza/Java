package utfpr.sincroniza;

public class Principal {

    private int contador = 0;
    
    public static void main(String[] args) {
        Principal p=new Principal();
        p.executaThreads();
    }
    
    public synchronized void executarContador(){
        contador++;
    }
    
    public void executaThreads(){
        
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<1000;i++)
                    executarContador();
            }
            
        });
        
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
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
            ex.printStackTrace();
        }
        
        System.out.println("Contador = "+this.contador);
    }
    
}
