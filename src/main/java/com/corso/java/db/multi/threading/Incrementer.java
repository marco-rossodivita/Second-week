package com.corso.java.db.multi.threading;

public class Incrementer implements Runnable{

    private final int[] data;

    public Incrementer(int[] data){
        this.data = data;
    }

    @Override
    public void run() {
        for(int i = 0; i < data.length; i++){
            data[i] = data[i] + 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Incrementer((new int[10000])));
        thread.start();
        thread.join();
    }
}
