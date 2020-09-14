package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Calendar;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factureId;

    private Integer prixHt;

    private Integer TVA;

    private String paiementId;

    @Temporal(TemporalType.DATE)
    private Calendar dateLivraison;

    @Temporal(TemporalType.DATE)
    private Calendar datePaiement;

    private String userName;
    private String userForname;

    @Email
    @Column(length = 100)
    private String userEmail;

    @Column(columnDefinition = "TEXT")
    private String description;
}
