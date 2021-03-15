package utfpr.thread.exemplo2;

import javax.swing.JTextArea;

public class contadorThread extends Thread{
    
    private JTextArea jTA;
    
    public contadorThread(){}
        
    public contadorThread(JTextArea jTarea){
        this.jTA = jTarea;
    }
        
    public void run(){
        for(int i=0;i<10;i++){
            jTA.append("Valor :"+i+"\n");
            System.out.println("Valor :"+i);
        }
    }
    
}
