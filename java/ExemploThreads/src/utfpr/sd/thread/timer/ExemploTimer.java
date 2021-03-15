package utfpr.sd.thread.timer;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class ExemploTimer {

    private static final long HORA_CHEIA = 60000; // 60s
    private static final long INTERVALO_CHEIO = 60000; // 60s
    private static final SimpleDateFormat sdf = new SimpleDateFormat("'Hora atual:' HH:mm:ss");
    
    public static void main(String[] args) throws IOException {
        System.out.println("Execução iniciada");
        System.out.println(sdf.format(new Date()));
        long atraso = HORA_CHEIA - new Date().getTime() % HORA_CHEIA;
        
        Timer timer = new Timer("hora-cheia-timer");
        timer.scheduleAtFixedRate(new MensagemTask(), atraso, INTERVALO_CHEIO);
        
        System.out.println("Pressione Enter para terminar...");
        System.in.read();
        timer.cancel();
        
        System.out.println("Execução finalizada");
        System.out.println(sdf.format(new Date()));
    }

}
