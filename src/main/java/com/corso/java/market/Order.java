package com.corso.java.market;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;


@Data @NoArgsConstructor @Builder @AllArgsConstructor
public class Order {

    private int idOrder;
    private Person person;

    public void readOrder() {



    }
}
