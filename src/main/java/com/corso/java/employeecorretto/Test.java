package com.corso.java.employeecorretto;

public class Test {

    public static void main(String[] args) {
        CreateTb ct = new CreateTb();
        CommandLine cm = new CommandLine();

        Thread t = new Thread(ct);
        t.setPriority(1);

        ct.run();
        cm.run();
    }
}
