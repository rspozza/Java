package utfpr.thread.exemplo5;

public class app1 {
    
    public static void main(String[] args) {
        //Contador cont=new Contador();
        ContadorSincronizado cont=new ContadorSincronizado();
        for(int i=0;i<10;i++)
            new Thread(new ThreadContador(10,"t"+i,cont)).start();
        
    }
    
}
