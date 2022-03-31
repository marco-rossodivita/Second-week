package com.corso.java.fornitore;

import java.sql.SQLException;

public class DBRunner{

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        DbAccess dba = new DbAccess();

        dba.createTableFornitori();
        dba.readDatabase();
        dba.populateFornitori();
        dba.readDatabase();
    }
}
