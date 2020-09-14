package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Artiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long artiste_id;

    @Column(nullable = false)
    private  String biographie;

    @Column(nullable = false)
    private  String nom;

    @Column(nullable = false)
    private  String prenom;

    @Column
    private  String  nationalite;
}
