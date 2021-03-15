package utfpr.sd.thread.swing;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ThreadArea implements Runnable {

    JTextArea jTextThread;

    public ThreadArea() {

    }

    public ThreadArea(JTextArea jTextArea) {
        this.jTextThread = jTextArea;
    }

    @Override
    public void run() {

        for (int i = 0; i <= 5; i++) {
            jTextThread.append(" i = " + i + "\n");
        }

    }
}
