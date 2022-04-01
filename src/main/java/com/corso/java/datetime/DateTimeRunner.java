package com.corso.java.datetime;

import com.corso.java.utils.LOG;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeRunner {

    public static void main(String[] args) throws ParseException {

        LOG L = LOG.getInstance();
        Date date = new Date();

        //Fri Apr 01 11:30:55 CEST 2022
        L.getInstance().info(date.toString());

        //Vediamo come formattare le date
        DateFormat format = DateFormat.getDateInstance();
        L.info(format.format(date));

        //venerdi 1 aprile 2022
        DateFormat format2 = DateFormat.getDateInstance(DateFormat.FULL);
        L.info(format2.format(date));

        //1 aprile 2022
        DateFormat format3 = DateFormat.getDateInstance(DateFormat.LONG);
        L.info(format3.format(date));

        //1 apr 2022
        DateFormat format4 = DateFormat.getDateInstance(DateFormat.MEDIUM);
        L.info(format4.format(date));

        // 01/04/22
        DateFormat format5 = DateFormat.getDateInstance(DateFormat.SHORT);
        L.info(format5.format(date));

        //i mesi sono sempre maiuscoli. Ci stampa 2022-04-01
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        L.info(simpleDateFormat.format(date));

        //01-04-2022
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MM-yyyy");
        L.info(simpleDateFormat2.format(date));

        //Orario corrente
        SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("hh:mm:ss");
        L.info(simpleDateFormat3.format(date));

        //Sun Sep 25 00:00:00 CET 1977
        String birthday = "25/09/1977";
        SimpleDateFormat birthdayFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date birthdayDay = birthdayFormatter.parse(birthday);
        L.info(birthdayFormatter.format(birthdayDay));

        L.info(String.valueOf(date.compareTo(birthdayDay)));
    }
}
