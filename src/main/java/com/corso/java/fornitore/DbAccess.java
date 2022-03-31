package com.corso.java.fornitore;

import java.sql.*;
import com.corso.java.connectionDB.DBConstant;

/**
 * Scrivere un app che crea la tabella FORNITORI
 *
 * codice varchar 20 notnull
 * nome varchar 20 notnull
 * indirizzo varchar 30 notnull
 * citta varchar 20 notnull
 */

public class DbAccess implements db<ResultSet>{

    private Connection connection;
    private Statement statement;
    private PreparedStatement ps;
    private ResultSet rs;


    /**
     * Crea un TABLE denominato FORNITORI con i campi dentro
     * @throws SQLException
     */
    public void createTableFornitori() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        connection = startConnection();

        String q = "CREATE TABLE `db`.`fornitori` (" +
                "  `idFornitori` INT NOT NULL," +
                "  `name` VARCHAR(20) NOT NULL," +
                " `indirizzo` VARCHAR(30) NOT NULL, "+
                " `citta` VARCHAR(20) NOT NULL, " +
                "  PRIMARY KEY (`idFornitori`));";

        statement = connection.createStatement();
        statement.executeUpdate(q);

        this.close();

    }

    /**
     * Inserisco variabili nella tabella fornitori
     */
    public void populateFornitori() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        connection = startConnection();

        String q = "INSERT INTO jdbc.fornitori VALUES ('001', 'Ladroni', 'Via Ostense', 'Roma'), ('002', 'Risparmietti', 'Viale Marconi', 'Roma'), " +
                " ('010', 'Teloporto', 'Via Roma', 'Milano');";

        ps = connection.prepareStatement(q);

        if(ps.executeUpdate()!=0) System.out.println("Aggiunto tutto");
        else System.out.println("Failed");

        this.close();
    }



    @Override
    public void readDatabase() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        this.connection = startConnection();

        statement = this.connection.createStatement();

        rs = statement.executeQuery("SELECT * FROM fornitori");

        ResultSetMetaData md = rs.getMetaData();

        while(rs.next()){
            System.out.println("");
            for(int i=0; i < md.getColumnCount(); i++){
                System.out.println(rs.getString(i));
            }
        }

        this.close();
    }

    /**
     * Chiude tutte le connessioni aperte
     * @throws SQLException
     */
    @Override
    public void close() throws SQLException {
        if(statement != null)
            statement.close();
        if(rs != null)
            rs.close();
        if(connection != null)
            connection.close();
        if(ps != null)
            ps.close();
    }

    public Connection startConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Connection conn = null;

        Class.forName(DBConstant.DB_MYSQL_URL).newInstance();
        conn = DriverManager.getConnection(DBConstant.DB_URL,DBConstant.DB_USER,DBConstant.DB_PASSWORD);

        return connection;
    }
}



