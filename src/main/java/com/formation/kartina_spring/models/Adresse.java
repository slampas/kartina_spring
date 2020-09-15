package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adresseId;

    @Column(length = 10)
    private String num;

    @Column(length = 10)
    private String voie;

    @Column(length = 40)
    private String complementVoie;

    private String ville;

    @Column(length = 10)
    private Long codePostal;

    @Column(length = 100)
    private String pays;

    @Column(length = 50)
    private String nomAdresse;

    //Liaison
    @OneToOne(mappedBy = "adresse")
    @JoinColumn(nullable = false) //Il ne peut pas exister d'adresse sans utilisateur
    private Utilisateur user;
}
