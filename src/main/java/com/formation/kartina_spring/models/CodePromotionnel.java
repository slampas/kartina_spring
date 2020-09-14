package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CodePromotionnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code_id;

    @Column(columnDefinition = "text")
    private String description;

    private String date_limite;
}
