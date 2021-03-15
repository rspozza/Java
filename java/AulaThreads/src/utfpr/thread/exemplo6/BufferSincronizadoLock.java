package utfpr.thread.exemplo6;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
// Acesso sincronizado para um variavel compartilhada

public class BufferSincronizadoLock implements Buffer {

// Variaval acessLock para controlar acesso ao buffer
    private Lock controleAcesso = new ReentrantLock();

// condições para acesso de leitura e escrita
    private Condition podeEscrever = controleAcesso.newCondition();
    private Condition podeLer = controleAcesso.newCondition();

// objeto comparilhado pelas threads do produtor e consumidor    
    private int buffer = -1; 

// flag para o buffer ocupado
    private boolean ocupado = false; 

// Metodo para inserir valor no buffer
    public void set(int value) {
        controleAcesso.lock(); // Controle de acesso. Bloqueia esse objeto

        try {
// Enquanto buffer não está vazio, colocar esta thread em estado de espera
            while (ocupado) {
                System.out.println("Produtor tenta escrever.");
                mostraEstado("Buffer cheio.\nProdudor espera.");
                podeEscrever.await();// espera até buffer ficar vazio
            } // end while

            buffer = value; // colocar a variavel buffer com novo valor

// Com isso, o produtor não pode armazenar outro valor até o consumidor 
// ler o valor inserido no buffer
            ocupado = true;

            mostraEstado("Produtor escreve " + buffer);

// Sinal para a thread esperar para ler do buffer
            podeLer.signal();
        } // fim do try
        catch (InterruptedException exception) {
            exception.printStackTrace();
        } // fim do catch
        finally {
            controleAcesso.unlock(); // Controle de acesso. Desbloqueia esse objeto.
        } // fim do  finally
    } // fim do método set

// Metodo para retornar valor do buffer
    public int get() {
        int readValue = 0; // inicializa o valor de leitura do buffer
        
        controleAcesso.lock(); // Controle de acesso. Bloqueia esse objeto

        try {
// Enquanto o buffer não tiver dados para ler o consumir irá para o 
// estado de espera.
            while (!ocupado) {
                System.out.println("Consumidor tenta ler.");
                mostraEstado("Buffer vazio.\nConsumidor espera.");
                podeLer.await(); // espera até buffer ter dados para serem lidos
            }

//Indica que o produtor pode colocar informação no buffer porque o consumidor 
// já efetuou a leitura do buffer
            ocupado = false;

            readValue = buffer; // retorna valor do buffer
            mostraEstado("Consumidor leu " + readValue);

// Sinal para a thread esperando o buffer estar cheio
            podeEscrever.signal();
        } // fim do try

// Se a thread for interrompida irá gerar exceção
        catch (InterruptedException exception) {
            exception.printStackTrace();
        } // fim do catch
        finally {
            controleAcesso.unlock(); // Controle de acesso. Bloqueia esse objeto
        } // fim do finally

        return readValue;
    } // fim do método get

// método para simplificar a exibição dos dados na tela
    public void mostraEstado(String operation) {
        System.out.println(operation + "\t\t" + buffer + "\t\t" + ocupado + "\n");
    }
}