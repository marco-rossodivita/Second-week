package com.corso.java.db.multi.threading;

import com.corso.java.utils.LOG;

public class ThreadNumberPrinter extends Thread{

    int min;
    int max;

    static LOG L= LOG.getInstance();

    public ThreadNumberPrinter(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void run(){
        for(int i = min; i <= max; i++){
            L.info(String.valueOf(i));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadNumberPrinter tp = new ThreadNumberPrinter(4,6);
        tp.start(); //fa parte della classe Thread
        tp.join();
        Thread.sleep(2000);//"Done" esce dopo 5 sec
        L.info("Done!");

        Thread currentThread = Thread.currentThread();
        currentThread.setName("current-thread");
        currentThread.setPriority(1);
        currentThread.run();
        Thread.sleep(10000);


        Thread thread = new Thread(tp);
        thread.setName("nostro-thread-");
        thread.start();
        thread.join();
        L.info("Done!");

        NumberPrinterAsRunnable np = new NumberPrinterAsRunnable(5,8);
        np.run();
        L.info("Done!");

    }
}
