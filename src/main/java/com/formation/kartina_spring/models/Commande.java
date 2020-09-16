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
    @Column(nullable = false)
    private Calendar date;

    @Column(nullable = false)
    private Integer prixTotalHt;

    @Column(nullable = false)
    private Integer TVA;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dateLivraison;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar datePaiement;

    @ManyToOne
    @JoinColumn(nullable = false) //Il ne peut pas exister de commande sans user
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