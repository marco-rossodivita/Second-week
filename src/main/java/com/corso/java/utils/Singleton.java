package com.corso.java.utils;

public class Singleton {
    /**
     * Instance
     */
    public static Singleton instance = null;

    /**
     * constructor
     */
    Singleton() {}

    /**
     * @return instance
     */
    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
