package com.corso.java.recursion;

public class FactiorialRecursive {

    public static int factRecursive(int n){

        if(n == 1) return 1;
        return n * factRecursive(n-1);
    }

    public static int fib(int n){

        if(n == 1) return 1;
        if(n == 2) return 1;
        return (fib(n - 1) + fib(n - 2));
    }

    public static void main(String[] args) {
        System.out.println(FactiorialRecursive.factRecursive(4));
        System.out.println(FactiorialRecursive.fib(7));
    }
}
