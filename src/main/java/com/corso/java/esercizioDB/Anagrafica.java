package com.corso.java.esercizioDB;

import com.corso.java.utils.LOG;

import java.io.IOException;
import java.sql.*;

import static com.corso.java.esercizioDB.Constant.*;

public class Anagrafica {


    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        LOG L = LOG.getInstance();

        //ReadProps readProps = new ReadProps();
        //readProps.init();



        Class.forName(DB_MYSQL_URL).newInstance();
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);



        statement = connection.createStatement();


        statement.executeUpdate(Constant.DB_CREATE_DEPARTMENT);

        statement.executeUpdate(Constant.DB_CREATE_ANAGRAFICA);

        statement.executeUpdate(Constant.DB_INSERT_ANAGRAFICA);
        statement.executeUpdate(Constant.DB_INSERT_ANAGRAFICA2);
        statement.executeUpdate(Constant.DB_INSERT_ANAGRAFICA3);

        resultSet = statement.executeQuery("SELECT * FROM dipartimento.anagrafica");

        ResultSetMetaData md = resultSet.getMetaData();

        while(resultSet.next()){
            for(int i = 1; i <= md.getColumnCount(); i++)
                L.info(resultSet.getString(i));
        }

        resultSet.close();
        statement.close();
        connection.close();


    }

 }

