package com.eazybytes.cards.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity //indique que c'est une entité
@Table(name = "Cards")
@Data
public class Cards {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "card_id") //CREERA LA COLONNE DANS LA DB LORSQUE L'APPLICATION DEMARRE, SI LA COLONNE EXISTE DEJA, IL NE FERA RIEN
    private int cardId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private int totalLimit;

    @Column(name = "amount_used")
    private int amountUsed;

    @Column(name = "available_amount")
    private int availableAmount;

    @Column(name = "create_dt")
    private LocalDate createDt;

}
