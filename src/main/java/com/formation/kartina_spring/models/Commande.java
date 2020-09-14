package com.formation.kartina_spring.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Calendar date;

    private Integer prixTotalHt;

    private Integer TVA;

    @Temporal(TemporalType.DATE)
    private Calendar date_livraison;

    @Temporal(TemporalType.DATE)
    private Calendar date_paiement;

    @ManyToOne
    private Utilisateur user;

    @ManyToMany
    private List<Article> articles  = new ArrayList<>();

    @ManyToOne
    private CodePromotionnel codePromotionnel;
}