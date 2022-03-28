package com.corso.CreateTable;

import java.sql.*;

public class DbAccess implements db<ResultSet>{

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private String DB_DRIVER_URL = "com.mysql.cj.jdbc.Driver";
    private String DB_PSW = "lol123";
    private String DB_USER = "root";
    private String DB_URL = "jdbc:mysql://localhost/jdbc?";


    public void readDatabase(){
        try{
            Class.forName(DB_DRIVER_URL).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PSW);

            String sql = "CREATE TABLE `JDBC`.`persona` (" +
                    "  `idpersona` INT NOT NULL" +
                    "  `name` VARCHAR(45) NULL" +
                    " `name` VARCHAR(45) NULL" +
                    "  PRIMARY KEY (`idpersona`));";

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void close() throws SQLException {

        if(resultSet != null)
            resultSet.close();

        if(statement != null)
            statement.close();

        if(connection != null)
            connection.close();

        if(preparedStatement != null)
            preparedStatement.close();
    }


}



