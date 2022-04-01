package com.corso.java.connectionDB;

import com.corso.java.utils.LOG;

import java.sql.*;

public class DBConnection {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            LOG L = LOG.getInstance();
            //Stringa del driver "com.."
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            //localhost è dove facciamo girare il DB, inquesto caso locale

            connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER,
                    DBConstant.DB_PASSWORD);

            statement = connection.createStatement();

            resultSet = statement.executeQuery(DBConstant.DB_SELECT_STUDENTE);

            ResultSetMetaData md = resultSet.getMetaData();

            while(resultSet.next()){
                for(int i = 1; i <= md.getColumnCount(); i++)
                    L.info(resultSet.getString(i));
            }

        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e){
            System.out.println("SQLException: " + e.getMessage());
        } finally{
          close(resultSet,statement,connection);
        }

    }

    private static void close(ResultSet resultSet, Statement statement, Connection connection) throws SQLException{

        if(resultSet != null)
            resultSet.close();

        if(statement != null)
            statement.close();

        if(connection != null)
            connection.close();
    }

    /**
     * connessione a db -> registrazione del driver (mysql come db)
     * creare una connessione al db attraverso il DriverManager -> ritorna un oggetto
     * della classe Connection
     */

    /**
     * Operazioni CRUD sono le seguenti:
     * C -> create
     * R -> read
     * U - update
     * D -> delete
     */
}
