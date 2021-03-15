package utfpr.thread.exemplo6;

public class BufferSincronizadoWait implements Buffer {
// SynchronizedBuffer sincroniza acesso a um único inteiro compartilhado.

    private int buffer = -1;
// compartilhado pelas threads Produtor e Consumidor

    private boolean ocupado = false;
// controle do buffer ocupado

// metodo para inserir valor no buffer
    public synchronized void set(int value) {
// enquanto não houver posições vazias, coloca a thread em estado de espera
        while (ocupado) {
// envia informações de thread e de buffer para a saída, então espera
            try {
                System.out.println("Produtor tenta escrever");
                mostraEstado("Buffer cheio.\nProdutor espera.");
                wait();
            } // fim do try
            catch (InterruptedException exception) {
                exception.printStackTrace();
            } // fim do catch
        } // fim do while

        buffer = value; // configura novo valor de buffer
// indica que o produtor não pode armazenar outro valor
// até o consumidor recuperar valor atual de buffer
        ocupado = true;

        mostraEstado("Produtor escreve " + buffer);

        notify(); // instrui a thread em espera a entrar no estado executável
    } // fim do método set; libera bloqueio em SynchronizedBuffer

    // metodo para retornar valor do buffer
    public synchronized int get() {
// enquanto os dados não são lidos, coloca thread em estado de espera
        while (!ocupado) {
// envia informações de thread e de buffer para a saída, então espera
            try {
                System.out.println("Consumidor tenta ler.");
                mostraEstado("Buffer vazio.\nConsumidor espera.");
                wait();
            } // fim do try
            catch (InterruptedException exception) {
                exception.printStackTrace();
            } // fim do catch
        } // fim do while

// indica que a produtora pode armazenar outro valor
// porque a consumidora acabou de recuperar o valor do buffer 
        ocupado = false;

        int readValue = buffer; // armazena valor em buffer
        mostraEstado("Consumidor leu " + readValue);

        notify(); // instrui a thread em espera a entrar no estado executável

        return readValue;
    } // fim do método get; libera bloqueio em SynchronizedBuffer

// Metodo para exibir a operação atual e o estado de buffer
    public void mostraEstado(String operation) {
        System.out.println(operation + "\t\t" + buffer + "\t\t" + ocupado + "\n");
    }
}
