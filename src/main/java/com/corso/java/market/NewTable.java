package com.corso.java.market;

import com.corso.java.utils.DB;

import java.io.IOException;
import java.sql.SQLException;

public class NewTable extends DB implements Runnable{


    @Override
    public void run() {
        try {
            conn = this.startConnection();

            rp.read("market.properties");

            String q1 = rp.getProperties().getProperty("createTable_P");
            String q2 = rp.getProperties().getProperty("createTable_O");

            statement = conn.createStatement();
            statement.executeUpdate(q1);
            statement.executeUpdate(q2);
            L.info("tables made");


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }
}
