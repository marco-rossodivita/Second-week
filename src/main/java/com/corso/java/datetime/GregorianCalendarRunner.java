package com.corso.java.datetime;




import com.corso.java.utils.LOG;

import java.util.GregorianCalendar;

public class GregorianCalendarRunner {

    public static void main(String[] args) {
        GregorianCalendar actualDate = new GregorianCalendar();
        System.out.println(actualDate.getTime()); //current time

        int ore = actualDate.get(GregorianCalendar.HOUR);
        int minuti = actualDate.get(GregorianCalendar.MINUTE);
        int secondi = actualDate.get(GregorianCalendar.SECOND);
        int mese = actualDate.get(GregorianCalendar.MONTH);

        LOG L = LOG.getInstance();
        L.info(String.valueOf(ore)); //mi ritorna le ore
        L.info(String.valueOf(minuti));
        L.info(String.valueOf(secondi));
        L.info(String.valueOf(mese));

        GregorianCalendar data1 = new GregorianCalendar(2008, 11, 18);
        GregorianCalendar data2 = new GregorianCalendar(2007, 11, 18);

        if(data1.before(data2))
            L.info("data 1 precede data 1");
        else if(data1.after(data2))
            L.info("data 2 precede data 1");
        else
            L.info("sono uguali");

    }
}
