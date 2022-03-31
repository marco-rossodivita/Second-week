package com.corso.java.employee;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertIntoT {

    private Connection connection = null;
    private ReadProperties1 rp = new ReadProperties1();
    private PreparedStatement ps = null;
    private SingleT singleT = SingleT.getInstance();
    private Employee e = new Employee();


    public void run(){

        try{
            connection = singleT.getConnection();

            e.readFromInput();
            ps = connection.prepareStatement("INSERT INTO employees (`id`, `name`, `lastname`) VALUES (?,?,?);");
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getLastName());

            } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            this.closeAll();
        }
    }



    private void closeAll()  {
        try {
            if (ps != null)
                ps.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
