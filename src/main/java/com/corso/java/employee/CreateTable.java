package com.corso.java.employee;


import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable extends Thread{

    public void run(Statement st) throws SQLException {
        String q = "CREATE TABLE IF NOT EXISTS jdbc.Employee " +
                "(ID INT not NULL, " +
                " Name VARCHAR(255), " +
                " LastName VARCHAR(255), " +
                " PRIMARY KEY(ID))";
        st.executeUpdate(q);
    }

}
