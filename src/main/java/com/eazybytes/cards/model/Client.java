package com.eazybytes.cards.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity //entite va faire le mapping entre la table et la classe, il va creer la table dans la db
@Table(name = "Client")
@Data //pour generer les getter et setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "create_dt")
    private LocalDate createDt;

    // Constructor
    public Client(String name, String email, LocalDate createDt) {
        this.name = name;
        this.email = email;
        this.createDt = createDt;
    }

    // No-args constructor for JPA
    public Client() {
    }


}
