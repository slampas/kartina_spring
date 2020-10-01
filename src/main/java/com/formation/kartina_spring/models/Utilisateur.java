package com.formation.kartina_spring.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur {

    @Id
    @Column(nullable = false, length = 150)
    private String email;

    @Column(length = 10, nullable = false)
    private String civilite;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(length = 16, nullable = false)
    private String telephone;

    @Transient
    private String password;

    @Column(length = 150, nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String salt;

    //Liaison entre tables
    @ManyToOne
    @JoinColumn(nullable = false) //Il ne peut pas d'user sans role
    private UserType role;

    @OneToOne(cascade = CascadeType.ALL)
    private Adresse adresse;

    @ManyToOne(cascade = CascadeType.ALL)
    private Artiste artiste;

    @OneToMany(mappedBy = "user")
    private List<Commande> commandes = new ArrayList<>();
}
