/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.exemplo1;

/**
 *
 * @author User
 */
public class app2 {

    // instanciar de outras maneiras as threads
    public static void main(String[] args) {
        System.out.println("Instanciar Threads");

        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Ti=" + i);
                    }
                }
            }.start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Ri=" + i);
                    }
                }

            }).start();
        }
    }

}
