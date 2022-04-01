package com.corso.java.olympic;

import com.corso.java.utils.DB;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Operations extends DB implements Repository<Athlete> {


    /**
     *
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void insert() throws IOException, SQLException {

        Athlete athlete = new Athlete();
        athlete.readAthlete();

        Connection connection = this.startConnection(); //dalla utils DB

        rp.read("oly.properties");

        ps = connection.prepareStatement(rp.getProperties().getProperty("insert"));


        ps.setString(1, athlete.getName());
        ps.setString(2, athlete.getNation());
        ps.setString(3, athlete.getBirthDate());
        ps.setDouble(4, athlete.getHeight());


        if(ps.executeUpdate() != 0)
            L.info("Aggiunto");
        else
            L.info("Non aggiunto");

        ps.clearParameters();
    }

    /**
     *
     * @param athlete
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void update(Athlete athlete) throws IOException, SQLException {

        conn = this.startConnection();
        rp.read("oly.properties");

        ps = conn.prepareStatement(rp.getProperties().getProperty("update"));


        ps.setString(1, athlete.getName());
        ps.setString(2, athlete.getNation());
        ps.setString(3, athlete.getBirthDate());
        ps.setDouble(4, athlete.getHeight());

        if(ps.executeUpdate() != 0)
            L.info("Aggiunto");
        else
            L.info("non aggiunto");

        ps.clearParameters();
    }

    /**
     *
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void delete() throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);

        conn = this.startConnection();
        rp.read("oly.properties");

        ps = conn.prepareStatement(rp.getProperties().getProperty("delete"));

        System.out.println("Insert athlete code to delete: ");
        ps.setInt(1, sc.nextInt());

        if(ps.executeUpdate() != 0)
            L.info("Eliminato ");
        else
            L.info("non Eliminato");

        ps.clearParameters();

        this.closeAll();
    }

    /**
     *
     * @throws IOException
     * @throws SQLException
     */
    @Override
    public void findAll() throws IOException, SQLException {

        ResultSet rs = null;
        Statement statement = null;

        conn = this.startConnection();
        rp.read("oly.properties");

        statement = conn.createStatement();

        rs = statement.executeQuery(rp.getProperties().getProperty("select"));

        this.printer(rs);

        this.closeAll();
    }

    /**
     *
     * @throws SQLException
     * @throws IOException
     */
    @Override
    public void findByPrimaryKey() throws SQLException, IOException {

        Scanner sc = new Scanner(System.in);

        conn = this.startConnection();
        rp.read("oly.properties");

    }

}
