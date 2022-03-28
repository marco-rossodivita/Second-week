package com.corso.CreateTable;

public class DBRunner{

    public static void main(String[] args) {

        DbAccess dbAccess = new DbAccess();
        dbAccess.readDatabase();
    }
}
