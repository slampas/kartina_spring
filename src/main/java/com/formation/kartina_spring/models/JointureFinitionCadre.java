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
    @EmbeddedId
    private JointureFinitionCadreId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("finitionId")
    private Finition finition;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cadreId")
    private Cadre cadre;

    @Column(nullable = false)
    private Float coefficientPrix;
}