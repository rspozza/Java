package utfpr.thread.exemplo6;

public class Produtor implements Runnable {
    
    private Buffer locacaoCompartilhada;

    public Produtor(Buffer bufferCompartilhado) {
        this.locacaoCompartilhada = bufferCompartilhado;
    }

    @Override
    public void run() {
        int soma = 0;

        for (int i = 0; i <= 10; i++) {
            System.out.println("Produtor escrevendo...");
            utfpr.thread.utils.Utils.gastarTempoRandomico(3000);
            locacaoCompartilhada.set(i);
            soma += i;
        }
        System.out.println("\n\n\n Produtor terminou com soma = " + soma);
    }

}
