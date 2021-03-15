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
public class app1 {
    
    // Classe Thread e Runnable
    // formas de instanciar
    
    public static void main(String[] args) {                
        ThreadEx1 t1= new ThreadEx1();
        t1.start();
        Thread t2 = new Thread(new ThreadEx2());
        t2.start();        
        System.out.println("Programa Principal");
    }
    
}
