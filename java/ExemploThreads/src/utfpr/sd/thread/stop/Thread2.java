

package utfpr.sd.thread.stop;

public class Thread2 extends Thread{

    public String nome;
    
    public Thread2(){
        
    }
    
    public Thread2(String nome){
        this.nome = nome;
    }
    
    @Override
    public void run() {
        
        int i=0;
        try{
        while(true){
            System.out.println(" i = "+i);
            i++;
            if(this.isInterrupted()){
                throw new InterruptedException("A Thread parou");
            }
        }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
