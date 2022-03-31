package com.corso.java.employee;

import com.corso.java.utils.LOG;
import com.corso.java.utils.ReadProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable implements Runnable{

    static LOG L = LOG.getInstance();
    private Connection connection;
    private Statement statement;
    private ReadProperties1 rp = new ReadProperties1();
    private SingleT singleT = SingleT.getInstance();

    public void run() {

        try{
            connection = singleT.getConnection();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            String q = "CREATE TABLE IF NOT EXISTS `jdbc`.`employees` (\n" +
                    "  `id` INT NOT NULL,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `lastname` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));";

            statement = connection.createStatement();
            statement.executeUpdate(q);

        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try {
                this.closeAll();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }

    }



    private void closeAll() throws SQLException {
        if(statement != null) statement.close();
        if(connection != null) connection.close();
    }
}
