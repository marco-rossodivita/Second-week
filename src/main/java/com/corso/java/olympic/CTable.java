package com.corso.java.olympic;

import com.corso.java.utils.DB;

import java.io.IOException;
import java.sql.SQLException;

public class CTable extends DB {

    public void createTable() {
        try {
            conn = this.startConnection();

            rp.read("oly.properties");
            String q = rp.getProperties().getProperty("createTable");

            statement = conn.createStatement();
            statement.executeUpdate(q);
            L.info("table made");


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }
}
