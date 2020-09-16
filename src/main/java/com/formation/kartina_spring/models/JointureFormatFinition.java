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
    @EmbeddedId
    private JointureFormatFinitionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("formatId")
    private Format format;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("finitionId")
    private Finition finition;

    @Column(nullable = false)
    private Float coefficientPrix;
}