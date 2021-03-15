/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.exemplo2;

/**
 *
 * @author pozza
 */

// uso de swing
public class app1 {
    
    public static void main(String[] args) {
        contadorThread t1=new contadorThread();
        t1.start();
    }
    
}
