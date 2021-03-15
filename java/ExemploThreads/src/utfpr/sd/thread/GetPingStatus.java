/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.sd.thread;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Crunchify.com
 *
 */
public class GetPingStatus {

    private static final int MYTHREADS = 30;

    public static void main(String args[]) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
        String[] hostList = {"http://crunchify.com", "http://yahoo.com",
            "http://www.ebay.com", "http://google.com",
            "http://www.example.co", "https://paypal.com",
            "http://bing.com/", "http://techcrunch.com/",
            "http://mashable.com/", "http://thenextweb.com/",
            "http://wordpress.com/", "http://wordpress.org/",
            "http://example.com/", "http://sjsu.edu/",
            "http://ebay.co.uk/", "http://google.co.uk/","123",
            "http://www.wikipedia.org/",
            "http://en.wikipedia.org/wiki/Main_Page"};

        for (int i = 0; i < hostList.length; i++) {

            String url = hostList[i];
            Runnable worker = new MyRunnable(url);
            executor.execute(worker);
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {

        }
        System.out.println("\nTodas as threads terminaram");
    }

    
}
