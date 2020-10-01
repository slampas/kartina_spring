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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long finitionId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FinitionEnum finitionEnum;

    private Float coefficientPrix;

    @ManyToMany
    private List<Cadre> cadres = new ArrayList<>();

    @ManyToMany(mappedBy = "finitions")
    private List<Format> formats = new ArrayList<>();
}