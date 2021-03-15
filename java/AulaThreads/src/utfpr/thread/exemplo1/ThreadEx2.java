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
public class ThreadEx2 implements Runnable{

    @Override
    public void run() {
        System.out.println("Implements Runnable");
        for(int i=0;i<10;i++){
            System.out.println("Ri = "+i);
        }
    }
    
}
