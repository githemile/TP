package com.ADJIGBONON_LOVI.ApiSI.entity;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance ;
    private String sexe;
    private String adresse;
    private String numeroTelephone;
    private String mail;
    private String nationalite;

    @OneToMany(mappedBy="client", cascade =CascadeType.ALL)
    @Nullable
    private List<Compte> comptes;




}
