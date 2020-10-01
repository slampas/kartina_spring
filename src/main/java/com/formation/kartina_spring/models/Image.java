package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
=======
import javax.persistence.*;
@Data
@AllArgsConstructor
>>>>>>> feature/MAD_integration_parcours_achat
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Article article;
}
