package com.corso.java.employee;

import com.corso.java.utils.ReadProperties;

import java.io.IOException;
import java.sql.*;

/**
 * -Creare Tabella
 * -Creare Interfaccia commandline, leggiamo dalla riga di comando
 * -leggere i dati dai file di properties
 * -multithreading
 * -implementare metodi inserimento, delete, modifica
 * -lombok, usare @Builder
 * -metodo print che stampi nome, cognome, id
 * -Creare un classe Employee che ha un id (primary-key), name, lastName.
 * -Anotation Logger che prende come parametri un singolo valore "value", una stringa
 */

public class Tester {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        ReadProperties rp = new ReadProperties();
        rp.read("application.properties");
        Class.forName(rp.getProperties().getProperty("db.mysql.url"));
        Connection con = DriverManager.getConnection(rp.getProperties().getProperty("db.url"),
                                                    rp.getProperties().getProperty("db.username"),
                                                    rp.getProperties().getProperty("db.password"));
        Statement stm = con.createStatement();

        CreateTable thrCreate = new CreateTable();
        thrCreate.run(stm);

        Tester.insertRow(con);
        Tester.insertRow(con);
        // Op.deleteRow(con);
        // Op.destroy(con);
        // ReadTable thrRead = new ReadTable();
        // thrRead.run(stm);

    }

    public static void insertRow(Connection con) throws SQLException {
        Employee emp = new Employee();
        emp.readFromInput();
        String q = "INSERT INTO Employee (ID, Name, LastName) VALUES (?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setInt(1, emp.getId());
        ps.setString(2, emp.getName());
        ps.setString(3, emp.getLastName());
        ps.executeUpdate();
    }
}
