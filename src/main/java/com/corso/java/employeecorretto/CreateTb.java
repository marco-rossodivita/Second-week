package com.corso.java.employeecorretto;

import com.corso.java.utils.DB;

import java.io.IOException;
import java.sql.SQLException;

public class CreateTb extends DB implements Runnable {

    @Override
    public void run() {
        try {
            conn = this.startConnection();

            rp.read("sql.properties");
            String q = rp.getProperties().getProperty("createTable");

            statement = conn.createStatement();
            statement.executeUpdate(q);
            L.info("tabella creata");


        } catch (SQLException | IOException e) {
            L.info("-----------tabella NON creata----------");
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }
}
