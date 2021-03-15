package utfpr.sd.thread.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MensagemTask extends TimerTask {
    
    private final Date currentTime = new Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("'Hora:' HH:mm:ss");

    @Override
    public void run() {
        currentTime.setTime(System.currentTimeMillis());
        System.out.println(sdf.format(currentTime));
    }
    
}
