package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.FinitionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private FinitionEnum finitionEnum;

    @ManyToMany(mappedBy="finitions")
    private List<Format> formats = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JointureFinitionCadre",
            joinColumns = { @JoinColumn(name = "fk_Finition") },
            inverseJoinColumns = { @JoinColumn(name = "fk_Cadre") })
    private List<Cadre> cadres = new ArrayList<>();
}