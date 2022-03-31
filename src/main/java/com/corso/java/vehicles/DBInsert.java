package com.corso.java.vehicles;

import com.corso.java.utils.DB;
import com.corso.java.utils.LOG;
import com.corso.java.utils.ReadProperties;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class DBInsert implements Runnable {

    static LOG L = LOG.getInstance();
    private Connection connection = null;
    private ReadProperties rp = new ReadProperties();
    private PreparedStatement ps = null;
    private DB db = new DB();

    public void run(){

        try{
            connection = db.startConnection();
            for(int i=0; i<1; i++){
                ps = connection.prepareStatement("INSERT INTO auto (`marchio`, `nazione`, `fatturato`, `dipendenti`) VALUES (?,?,?,?);");
                Scanner sc = new Scanner(System.in);

                System.out.println("Inserisci marchio");
                ps.setString(1, sc.nextLine());

                System.out.println("nInserisci nazione");
                ps.setString(2, sc.nextLine());

                System.out.println("Inserisci fatturatoo");
                ps.setInt(3, sc.nextInt());

                System.out.println("Inserisci dipendenti");
                ps.setInt(4, sc.nextInt());

                if (ps.executeUpdate() != 0) L.info("Aggiunto ");
                else L.info("non aggiunto");

                ps.clearParameters();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }


    private void closeAll()  {
        try {
            if (ps != null) ps.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
