/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.thread.exemplo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author User
 */
// uso do executorService
// grupo e sequencial
public class app3 {

    public static void main(String[] args) {
        int numeroThreads = utfpr.thread.utils.Utils.processadorCore();
        System.out.println("Cores "+numeroThreads);
        ExecutorService executar = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executar.execute(new ThreadEx2());
        }        
        executar.shutdown();
    }

}
