
package utfpr.thread.exemplo5;

public class ThreadContador implements Runnable{
    
    private Conta cont;
    private String nome;
    private int tempo=10;
    
    public ThreadContador(){}    

    public ThreadContador(int tempo, String nome, Conta cont){
        this.tempo=tempo;
        this.cont=cont;
        this.nome=nome;
    }
        
    public ThreadContador(String nome, Conta cont){
        this.cont=cont;
        this.nome=nome;
    }
    
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            cont.decC();    
            utfpr.thread.utils.Utils.gastarTempoRandomico(tempo);
        }
        System.out.println(nome+" C = "+cont.mostraC());
    }
    
}
