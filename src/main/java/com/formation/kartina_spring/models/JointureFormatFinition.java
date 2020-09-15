package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JointureFormatFinition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formatFinitionId;

    @Column(nullable = false)
    private Long formatId;

    @Column(nullable = false)
    private Long finitionId;

    private Float coefficientPrix;
}