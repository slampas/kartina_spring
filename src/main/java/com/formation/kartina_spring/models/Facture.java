package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Calendar;
import java.util.GregorianCalendar;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factureId;

    @Column(nullable = false)
    private Integer prixHt;

    @Column(nullable = false)
    private Integer TVA;

    @Column(nullable = false)
    private String paiementId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dateLivraison;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar datePaiement;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String userForname;

    @Email
    @Column(length = 100, nullable = false)
    private String userEmail;

    @Column(columnDefinition = "TEXT")
    private String description;


    /*a voir avec marc-antoine pourquoi ce setter ?*/
	public void setDate(GregorianCalendar gregorianCalendar) {
	}
}
