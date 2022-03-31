package com.corso.java.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data //crea i getters and setters con le variabili che abbiamo istanziato
@NoArgsConstructor //crea il costruttore senza parametri
@Builder
@AllArgsConstructor
public class Employee implements CommandLine{

    private int id;
    private String name;
    private String lastName;


    @Override
    public void readFromInput() {

            Scanner sc = new Scanner(System.in);

            System.out.print("Insert nome");
            this.name = sc.nextLine();
            System.out.print("Insert last name:");
            this.lastName = sc.nextLine();

    }
}
