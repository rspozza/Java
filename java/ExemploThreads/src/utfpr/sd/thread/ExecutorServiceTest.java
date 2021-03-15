package utfpr.sd.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

	private static Future tarefa2 = null;
	private static Future tarefa3 = null;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
	   
		// Instancia a thread tarefa1
	    Runnable tarefa1 = new MyThread("Tarefa 1", 2, 100);
	    executor.execute(tarefa1);
	    for(int i = 0; i < 2; i++) {
	    	// Opção da thread não ter sido criado, cancelada ou completada
			if ((tarefa2 == null) || (tarefa2.isDone()) || (tarefa2.isCancelled())) {
				// Vai enviar uma tarefa para execução
				tarefa2 = executor.submit(new MyThread("Tarefa 2", 4, 200));
			}
	
			if ((tarefa3 == null) || (tarefa3.isDone()) || (tarefa3.isCancelled())) {
				tarefa3 = executor.submit(new MyThread("Tarefa 3", 5, 100));
			}
			// Se a tarefa for nula será finalizada
			if(tarefa2.get() == null) {
				System.out.println(i+1 + ") Tarefa 2 terminou com sucesso");
			} else {
				// caso não tenha sido finalizada a thread será cancelada
				tarefa2.cancel(true);
			}
			if(tarefa3.get() == null) {
				System.out.println(i+1 + ") Tarefa 3 terminou com sucesso");
			} else {
				tarefa3.cancel(true);
			}
	    }
	    executor.shutdown();
	    System.out.println("-----------------------");
	    // aguarda até que todas as threads tenham terminado
	    executor.awaitTermination(1, TimeUnit.SECONDS);
	    System.out.println("Todas as tarefas foram finalizadas!");
	
	}

}
