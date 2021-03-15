package utfpr.sd.thread;

import java.util.Random;

public class ImprimeTarefa implements Runnable{
    
  private int sleepTime; 
  private String threadName; 
  private static Random generator = new Random();

  public ImprimeTarefa(String name) {
    threadName = name; 
    sleepTime = generator.nextInt(5000); 
// valor randomico entre 0 e 5 segundos
  } 

  public void run() {
    try {      // colocar thread para dormir por tempo de sleepTime 
      System.out.println(threadName+" dormindo por "+sleepTime+" millisecs.\n");
      Thread.sleep(sleepTime); // colocar thread para esperar
    } 
    catch ( InterruptedException exception ) {
      exception.printStackTrace();
    } 
    System.out.printf(threadName+" acordando\n");
  }
    
}
