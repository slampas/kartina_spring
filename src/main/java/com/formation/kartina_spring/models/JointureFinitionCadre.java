package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JointureFinitionCadre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finitionCadreId;

    @Column(nullable = false)
    private Long finitionId;

    @Column(nullable = false)
    private Long cadreId;

    private Float coefficientPrix;
}