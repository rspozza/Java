package utfpr.thread.exemplo6;

public class Consumidor implements Runnable {    
    
    public Buffer locacaoCompartilhada;

    public Consumidor(Buffer bufferCompartilhado) {
        this.locacaoCompartilhada = bufferCompartilhado;
    }

    @Override
    public void run() {
        int soma = 0;
        for (int i = 0; i <= 10; i++) {
            System.out.println("Consumidor lendo...");
            utfpr.thread.utils.Utils.gastarTempoRandomico(3000);
            soma += locacaoCompartilhada.get();
        }
        System.out.println("\n\n\nConsumidor terminou com soma = " + soma);
    }

}
