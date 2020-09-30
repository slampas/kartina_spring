package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.CadreEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;
import org.hibernate.annotations.Cache;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cadre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cadreId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CadreEnum cadreEnum;

    private Float coefficientPrix;

    @ManyToMany(mappedBy = "cadres")
    private List<Finition> finitions = new ArrayList<>();

//    @OneToMany(
//          //  mappedBy = "cadre",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<JointureFinitionCadre> finitions = new ArrayList<>();
}