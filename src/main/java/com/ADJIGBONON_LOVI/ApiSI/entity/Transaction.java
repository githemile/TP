package com.ADJIGBONON_LOVI.ApiSI.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

// Classe Transaction
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    private Double montant;
    private String type;

    // Relation avec la classe Compte
    @ManyToOne
    private Compte compte;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }



    // ... getters and setters
}