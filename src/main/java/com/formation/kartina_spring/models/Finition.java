package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.FinitionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Finition {
    @Id
    @GeneratedValue
    private Long finitionId;

    @NaturalId
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FinitionEnum finitionEnum;

    @OneToMany(
            mappedBy = "finition",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JointureFormatFinition> formats = new ArrayList<>();

    @OneToMany(
            mappedBy = "finition",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JointureFinitionCadre> cadres = new ArrayList<>();
}