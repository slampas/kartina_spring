package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Commande {

    @Id
    @GeneratedValue
    private Long commandeId;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    private Integer prixTotalHt;

    private Integer TVA;

    @Temporal(TemporalType.DATE)
    private Calendar dateLivraison;

    @Temporal(TemporalType.DATE)
    private Calendar datePaiement;

    @ManyToOne
    private Utilisateur user;

    //https://vladmihalcea.com/the-best-way-to-map-a-many-to-many-association-with-extra-columns-when-using-jpa-and-hibernate/
    @OneToMany(
            mappedBy = "commande",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetailCommande> articles = new ArrayList<>();

    @ManyToOne
    private CodePromotionnel codePromotionnel;
}