package utfpr.thread.exemplo6;

public class BufferNaoSincronizado implements Buffer{

    private int buffer = -1;
    
    @Override
    public void set(int valor) {
        mostraEstado("Produtor escreve "+valor);
        this.buffer=valor;
    }

    @Override
    public int get() {
       mostraEstado("Consumidor leu "+buffer);
       return buffer;
    }
    
    public void mostraEstado(String operation) {
        System.out.println(operation + "\t\t" + buffer + "\n");
    }
    
}
