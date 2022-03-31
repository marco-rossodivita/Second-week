package com.corso.java.employee;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleT {

    Connection connect;
    ReadProperties1 rp = new ReadProperties1();
    public static SingleT instance = null;

    private SingleT(){};

    public static SingleT getInstance(){
        if(instance == null){
            instance = new SingleT();
        }
        return instance;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, IOException {
        rp.read();
        String url = rp.getProperties().getProperty("db.mysql.url");
        Class.forName(url).newInstance();
        connect = DriverManager.getConnection(rp.getProperties().getProperty("db.url"), rp.getProperties().getProperty("db.username"),rp.getProperties().getProperty("db.password"));

        return connect;
    }
}
