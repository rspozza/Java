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
public class ThreadEx1 extends Thread{
    
    @Override
    public void run(){
        System.out.println("Extends Thread");
        for(int i=0;i<10;i++){
            System.out.println("Ti = "+i);
        }
    }
    
}
