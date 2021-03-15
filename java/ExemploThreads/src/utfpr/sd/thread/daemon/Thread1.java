package utfpr.sd.thread.daemon;

import java.io.IOException;
import java.io.InputStream;

public class Thread1 implements Runnable {

    public Thread1() {
    }

    @Override
    public void run() {

        String cmd;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().contains("windows")) {
            cmd = "cmd /c c: & cd \\windows & dir";
        } else {
            cmd = "ls /usr -alR";
        }

        byte[] saida = new byte[1024];
        int nRead;
        Runtime rt = Runtime.getRuntime();
        Process proc;
        try {
            proc = rt.exec(cmd);
            InputStream is = proc.getInputStream();
            while ((nRead = is.read(saida)) != -1) {
                System.out.print(new String(saida, 0, nRead));
            }
            System.out.println("Processo terminado com status " + proc.exitValue());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
