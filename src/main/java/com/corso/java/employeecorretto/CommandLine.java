package com.corso.java.employeecorretto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class CommandLine implements Runnable{

    DBOperator dbo = new DBOperator();
    Scanner sc = Scanner_Singleton.getInstance();

    @Override
    public void run() {

        int x;
        do{
            System.out.println("\nScegli l'operazione: \n" +
                    "1 - Mostra tutti\n" +
                    "2 - Inserisci nuovo\n" +
                    "3 - Modifica\n" +
                    "4 - Elimina\n" +
                    "-1 - esci");
            x = sc.nextInt();
            switch (x){
                case 1:
                    try {
                        dbo.showAll();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    dbo.insert();
                    break;
                case 3:
                    dbo.update();
                    break;
                case 4:
                    try {
                        dbo.delete();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case -1: System.exit(0);
            }
        } while(x!= -1);
    }

}
