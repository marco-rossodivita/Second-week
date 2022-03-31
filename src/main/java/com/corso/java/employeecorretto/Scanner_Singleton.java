package com.corso.java.employeecorretto;

import java.util.Scanner;

public class Scanner_Singleton {

    public static Scanner instance;

    //synchronized è utile per il threading, permette ai thread di comunicare correttamente
    public static Scanner getInstance(){
        if(instance == null) {
            synchronized (DBOperator_Singleton.class){
                instance = new Scanner(System.in);
            }
        }
        return instance;
    }
}
