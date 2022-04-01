package com.corso.java.utils;

import java.sql.*;

public class DBConnection {
    private static ReadProperties readProperties;
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;
    private static LOG L = LOG.getInstance();

    /**
     * make a connection to db and return a statement
     * example: Statement statement = DBConnection.connect();
     *
     * @return
     * @throws SQLException
     */
    public static Statement connect() throws SQLException {
        try {
            if (statement == null) {
                readProperties = new ReadProperties();
                Class.forName(DBConfig.DB_MYSQL_URL).newInstance();
                connection = DBConfig.connect();
                statement = connection.createStatement();
            } else {
                L.debug("You have invoked more times DBConnection.connect();");
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            L.err("SQLException: " + ex.getMessage());
        }

        return statement;
    }

    public static void close() throws SQLException {
        if (resultSet != null)
            resultSet.close();

        if (statement != null)
            statement.close();

        if (preparedStatement != null)
            preparedStatement.close();

        if (connection != null)
            connection.close();
    }

    public static void main(String[] args) throws SQLException {
        Statement statement = DBConnection.connect();
    }
}