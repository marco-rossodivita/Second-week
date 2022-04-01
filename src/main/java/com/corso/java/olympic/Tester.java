package com.corso.java.olympic;

import java.io.IOException;
import java.sql.SQLException;

public class Tester {

    public static void main(String[] args) throws SQLException, IOException {

        CTable ct = new CTable();
        ct.createTable();

        Operations op = new Operations();
        op.insert();
        op.delete();
        op.findAll();
        //op.update(new Athlete("Andrew","Italia","24/09/1990",1.82)); DA RIVEDERE
        //op.findByPrimaryKey(); DA RIVEDERE
    }
}
