package com.corso.java.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@Data @NoArgsConstructor @Builder @AllArgsConstructor
public class Person {

    private int id;
    private String name;
    private String lastName;
    private int age;

    public void readPerson() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Insert name");
        this.name = sc.nextLine();
        System.out.print("Insert last name:");
        this.lastName = sc.nextLine();
        System.out.println("Insert age: ");
        String a = sc.nextLine();
        this.age = Integer.parseInt(a);

    }
}
