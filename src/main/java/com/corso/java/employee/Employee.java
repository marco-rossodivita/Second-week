package com.corso.java.employee;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.PreparedStatement;
import java.util.Scanner;

@Data
@Builder
@NoArgsConstructor
public class Employee implements CommandLine{

    private int id;
    private String name;
    private String lastName;

    public Employee(int id, String name, String lastName) {
        this.id=id;
        this.name=name;
        this.lastName=lastName;
    }

    @Override
    public Employee readFromInput() {

            System.out.println("|Inserimento variabili|");
            Scanner sc = new Scanner(System.in);

            System.out.println("Insert id:");
            this.id = sc.nextInt();

            System.out.println("Insert nome");
            this.name = sc.nextLine();

            System.out.println("Insert last name:");
            this.lastName = sc.nextLine();

            return (new Employee(id, name, lastName));

    }
}
