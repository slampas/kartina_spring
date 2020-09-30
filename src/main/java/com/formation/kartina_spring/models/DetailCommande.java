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
    private DetailCommandeId id = new DetailCommandeId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("commandeId")
    private Commande commande;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("articleId")
    private Article article;

    @Column(nullable = false)
    private Integer quantiteArticle;

    @OneToOne
    private Format format;

    @OneToOne
    private Finition finition;

    @OneToOne
    private Cadre cadre;
}
