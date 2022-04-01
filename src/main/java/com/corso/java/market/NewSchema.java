package com.corso.java.market;

import com.corso.java.utils.DB;

import java.io.IOException;
import java.sql.SQLException;

public class NewSchema extends DB implements Runnable{


    @Override
    public void run() {
        try {
            conn = this.startConnection();

            rp.read("market.properties");
            String q = rp.getProperties().getProperty("createSchema");

            statement = conn.createStatement();
            statement.executeUpdate(q);
            L.info("schema added");


        } catch (SQLException | IOException e) {
            L.info("schema not added");
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }
}
