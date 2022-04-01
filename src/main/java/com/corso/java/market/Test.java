package com.corso.java.market;

import com.corso.java.market.NewSchema;

public class Test {

    public static void main(String[] args) {
        //OK
        NewSchema ns = new NewSchema();
        Thread t1 = new Thread(ns);
        t1.setPriority(1);
        ns.run();

        //OK
        NewTable nt = new NewTable();
        Thread t2 = new Thread(nt);
        t2.setPriority(2);
        nt.run();


    }

}
