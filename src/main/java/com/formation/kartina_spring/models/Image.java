package com.formation.kartina_spring.models;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long image_id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String url;

    @Column(length = 8)
    private Long hauteur;

    @Column(length = 8)
    private Long largeur;
}
