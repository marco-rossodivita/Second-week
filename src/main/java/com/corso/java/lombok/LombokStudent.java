package com.corso.java.lombok;

import lombok.*;


@Data @Builder
public class LombokStudent {

    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private int age;
    private boolean enabled;


}
