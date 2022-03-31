package com.corso.java.employeecorretto;

import com.corso.java.connectionDB.DBConstant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOperator_Singleton {

    public static DBOperator_Singleton instance = null;
    private Connection conn = null;
    private PreparedStatement ps = null;

    /**
     * Constructor
     */
    private DBOperator_Singleton(){}

    /**
     * @method getInstance
     * crea l'istanza della classe
     * @return instance
     */
    public static DBOperator_Singleton getInstance(){
        if(instance == null)
            synchronized (DBOperator_Singleton.class) {
                instance = new DBOperator_Singleton();
            }
        return instance;
    }




    public void getPreparedStatement(String query) throws SQLException {
        try {
            conn = startConnection();
            ps = conn.prepareStatement(query);

            if (ps.executeUpdate() != 0) System.out.println("Prepared statement executed");
            else System.out.println("Failed");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeConnection();
        }
    }


    /**
     * @method closeConnection
     * chiude tutte le connessione aperte
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        if (conn != null) conn.close();
        if (ps != null) ps.close();
    }

    /**
     * @method startConnection
     * crea una nuova connessione al database
     * @return la connessione al db
     */
    public Connection startConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_USER, DBConstant.DB_PASSWORD);
        } catch ( SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
