package com.corso.java.olympic;

import lombok.*;

import java.util.List;
import java.util.Scanner;


@Data @NoArgsConstructor @Builder @AllArgsConstructor @ToString
public class Athlete {

    private int code;
    private String name;
    private String nation;
    private String birthDate;
    private double height;

    public Athlete(String name, String nation, String birthDate, double height) {
        this.name = name;
        this.nation = nation;
        this.birthDate = birthDate;
        this.height = height;
    }

    public void readAthlete(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert name:");
        this.name = sc.nextLine();
        System.out.println("Insert nation:");
        this.nation = sc.nextLine();
        System.out.println("Insert birth date:");
        this.birthDate = sc.nextLine();
        System.out.println("Insert height:");
        String h = sc.nextLine();
        this.height = Double.parseDouble(h);

    }

    //DA FINIRE
    public List<Athlete> findTallAthletes(double H){
        String q = "SELECT height FROM athletes";
        return null;
    }

}
