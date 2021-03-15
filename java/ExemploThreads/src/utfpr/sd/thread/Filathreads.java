package utfpr.sd.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Filathreads {

    public static void main(String[] args) {
// criando e nomeando cada thread
        ImprimeTarefa tarefa1 = new ImprimeTarefa("thread 1");
        ImprimeTarefa tarefa2 = new ImprimeTarefa("thread 2");
        ImprimeTarefa tarefa3 = new ImprimeTarefa("thread 3");

        System.out.println("Inicializando threads");

// criando ExecutorService para gerenciar threads
        ExecutorService threadExecutor = Executors.newFixedThreadPool(1);
// Cria um pool com número fixo de threads e fila ilimitada de tarefas 
//        ExecutorService threadExecutor = Executors.newCachedThreadPool();
// Cria um pool de threads sem limite, com recuperação automática de threads 
//(threads que já terminaram as tarefas são reutilizados para novas tarefas e 
// novos threads são criados só se não houver thread "velho" disponível)
// Uma boa opção quando há muitas tarefas pequenas a executar assincronamente.
// Threads não usados por 60 segundos são removidos
//        ExecutorService threadExecutor = Executors.newSingleThreadExecutor(); 
// Cria um thread único em background com fila ilimitada de tarefas
// As tarefas serão executadas sequencialmente
// inicializando threads e colocando no estado de executar
        threadExecutor.execute(tarefa1); // start task1
        threadExecutor.execute(tarefa2); // start task2
        threadExecutor.execute(tarefa3); // start task3  

        threadExecutor.shutdown();
// finaliza gerencidor mas permite que todas as threads sejam executadas

        System.out.println("Threads iniciadas, "
                + "programa principal finalizado\n");
    }
}
