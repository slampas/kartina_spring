package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetailCommande {
    @EmbeddedId
    private DetailCommandeId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("commandeId")
    private Commande commande;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articleId")
    private Article article;

    @Column(nullable = false)
    private Integer quantiteArticle;

    @Column(length = 100, nullable = false)
    private String format;

    @Column(length = 100, nullable = false)
    private String finition;

    @Column(length = 100, nullable = false)
    private String cadre;
}
