package com.corso.java.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConsoleHandler {

    private Scanner scanner;

    public void start(){
        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleHandler ch = new ConsoleHandler(scanner);
        }
    }

}