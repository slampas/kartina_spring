package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
@Data
@AllArgsConstructor
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
