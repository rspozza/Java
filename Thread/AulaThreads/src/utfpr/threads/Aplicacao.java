package utfpr.threads;

class ExecutaTarefa1 extends Thread{    

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Executa Tarefa1 : "+i);
        }
    }
}

class ExecutaTarefa2 extends Thread{    

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Executa Tarefa2 : "+i);
        }
    }
}


public class Aplicacao {
    
    public static void main(String[] args) {        
//        Thread t1=new Thread(new ExecutaTarefa1());
//        ExecutaTarefa2 t2=new ExecutaTarefa2();
        ExecutaTarefa1 t1=new ExecutaTarefa1();
        ExecutaTarefa2 t2=new ExecutaTarefa2();
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }        
        
        System.out.println("Fim da execução!!");
        
    }
    
}
