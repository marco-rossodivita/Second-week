package com.corso.java.db.multi.threading;

import com.corso.java.utils.LOG;

public class NumberPrinterAsRunnable implements Runnable{

    int min;
    int max;

    static LOG L= LOG.getInstance();

    public NumberPrinterAsRunnable(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        for(int i = min; i <= max; i++){
            L.info(String.valueOf(i));
        }
    }

}
