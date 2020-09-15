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
public class CodePromotionnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeId;

    @Column(columnDefinition = "text")
    private String description;

    @Temporal(TemporalType.DATE)
    private Calendar dateLimite;

    @OneToMany(mappedBy = "codePromotionnel")
    private List<Commande> commande = new ArrayList<>();
}
