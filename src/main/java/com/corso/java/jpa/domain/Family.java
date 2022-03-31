package com.corso.java.jpa.domain;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Family {

    //stiamo buildando la tabella Famiglia, con un campo di nome description, e un id "id"
    //però una persona può avere una famiglia, e una famiglia può avere più persone

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="family_id")
    private String id;

    @Column(length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;

    //si fa praticamente il processo inverso
    //abbiamo creato una mappatura, una relazione
}
