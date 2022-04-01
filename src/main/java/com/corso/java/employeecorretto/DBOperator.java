package com.corso.java.employeecorretto;

import com.corso.java.annotation.Logger;
import com.corso.java.utils.DB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBOperator extends DB {

    Scanner sc = Scanner_Singleton.getInstance();

    /**
     * Inserimento di una riga nella tabella
     */
    @Logger(item = "We are into insert")
    public void insert(){

        try{
            conn = this.startConnection();
            rp.read("sql.properties");

            Employe e = new Employe();

            //preso da sql.properties, è il comando insert per la tabella Employee
            ps = conn.prepareStatement(rp.getProperties().getProperty("insert"));

            System.out.println("Inserisci nome:");
            e.setName(sc.nextLine());

            System.out.println("Inserisci cognome:");
            e.setLastName(sc.nextLine());

            //l'insert di sql.proprerties ha i valori ?,?.. quindi li inseriamo da terminale
            ps.setString(1, e.getName());
            ps.setString(2, e.getLastName());

            if(ps.executeUpdate() != 0)
                L.info("Aggiunto");
            else
                L.info("Non aggiunto");

            ps.clearParameters();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll();
        }
    }

    /**
     * aggiorna riga nel table employees, inserendo l'id
     */
    public void update(){
        try{
            conn = this.startConnection();
            rp.read("sql.properties");

            ps = conn.prepareStatement(rp.getProperties().getProperty("update"));

            System.out.println("Inserire l'id dell'impiegato da modificare:");
            ps.setInt(3, sc.nextInt());

            System.out.println("Inserire nuovo nome:");
            ps.setString(1, sc.nextLine());

            System.out.println("Inserire nuovo cognome:");
            ps.setString(2, sc.nextLine());

            if(ps.executeUpdate() != 0)
                L.info("Aggiunto");
            else
                L.info("non aggiunto");

            ps.clearParameters();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * elimina una riga nella tabella employee, utilizzando l'id
     */
    public void delete() throws IOException, SQLException {

        conn = this.startConnection();
        rp.read("sql.properties");

        ps = conn.prepareStatement(rp.getProperties().getProperty("delete"));

        System.out.println("Inserire l'id dell'impiegato da eliminare: ");
        ps.setInt(1, sc.nextInt());

        if(ps.executeUpdate() != 0)
            L.info("Eliminato ");
        else
            L.info("non Eliminato");

        ps.clearParameters();

        this.closeAll();
    }

    /**
     * stampa tutte le righe della tabella employees
     */
    public void showAll() throws IOException, SQLException {
        ResultSet rs = null;
        Statement statement = null;

        conn = this.startConnection();
        rp.read("sql.properties");

        statement = conn.createStatement();

        rs = statement.executeQuery(rp.getProperties().getProperty("select"));

        this.printer(rs);

        this.closeAll();
    }
}
