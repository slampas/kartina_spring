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

    private Float coefficientPrix;
}