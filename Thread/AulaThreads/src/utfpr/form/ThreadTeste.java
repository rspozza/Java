package utfpr.form;

import javax.swing.JTextArea;

public class ThreadTeste extends Thread{
    
    private JTextArea jTA;
    
    public ThreadTeste(){}
        
    public ThreadTeste(JTextArea jTarea){
        this.jTA = jTarea;
    }
        
    public void run(){
        for(int i=0;i<10;i++){
            jTA.append("Valor :"+i+"\n");
            System.out.println("Valor :"+i);
        }
    }
    
}
