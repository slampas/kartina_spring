package com.formation.kartina_spring.models;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String url;

    @Column(length = 8)
    private Long hauteur;

    @Column(length = 8)
    private Long largeur;

    @ManyToOne
    private Article article;
}
