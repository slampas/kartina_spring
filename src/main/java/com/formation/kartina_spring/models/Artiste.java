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
public class Artiste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long artisteId;

    @Column(nullable = false)
    private  String biographie;

    @Column(nullable = false)
    private  String nom;

    @Column(nullable = false)
    private  String prenom;

    @Column
    private  String  nationalite;

    @OneToMany(mappedBy = "artiste")
    private List<Utilisateur> users = new ArrayList<>();

    @ManyToMany
    private List<Article> articles = new ArrayList<>();
}
