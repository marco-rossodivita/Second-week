package com.corso.java.employeecorretto;

import lombok.*;

@Data @NoArgsConstructor @Builder @AllArgsConstructor @ToString
public class Employe {

    private int id;
    private String name;
    private String lastName;
}
