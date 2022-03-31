package com.corso.java.vehicles;


public class VehiclesRunner {

    public static void main(String[] args) throws InterruptedException {

        DBTableCreator tc = new DBTableCreator();
        DBInsert ti = new DBInsert();

        tc.run();
        Thread.sleep(1000);
        ti.run();



    }
    
}
