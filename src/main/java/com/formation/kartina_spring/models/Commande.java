package com.formation.kartina_spring.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToMany
    @JoinTable(name = "DetailCommande",
            joinColumns = @JoinColumn(name = "commandeId"),
            inverseJoinColumns = @JoinColumn(name = "articleRef"))
    private List<Article> articles = new ArrayList<>();

    @ManyToOne
    private CodePromotionnel codePromotionnel;
}