package com.corso.java.vehicles;


import com.corso.java.utils.LOG;
import com.corso.java.utils.ReadProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTableCreator implements Runnable{

    static LOG L = LOG.getInstance();
    private Connection connection;
    private Statement statement;
    private ReadProperties rp = new ReadProperties();

    /**
     *
     */
    public void run() {

        try{
            connection = this.startConnection();
        } catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            String q = "CREATE TABLE IF NOT EXISTS `jdbc`.`auto` (" +
                    "  `idAuto` INT NOT NULL AUTO_INCREMENT," +
                    "  `marchio` VARCHAR(45) NOT NULL," +
                    " `nazione` VARCHAR(20) NOT NULL, " +
                    " `fatturato` INT NOT NULL, " +
                    " `dipendenti` INT NOT NULL, " +
                    "  PRIMARY KEY (`idAuto`));";

            statement = connection.createStatement();
            statement.executeUpdate(q);
        } catch(SQLException e){
            L.info("Tabella NON CREATA!!!");
            e.printStackTrace();
        } finally {
            try {
                this.closeAll();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }

    }


    private Connection startConnection() throws ClassNotFoundException, IOException {

        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc?", "root","lol123");

        } catch(SQLException e){
            e.printStackTrace();
        } catch(InstantiationException | IllegalAccessException e2){
            e2.printStackTrace();
        }

        return conn;
    }

    private void closeAll() throws SQLException {
        if(statement != null) statement.close();
        if(connection != null) connection.close();
    }

}
