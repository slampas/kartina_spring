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
    private Float finitionId;

    @Enumerated(EnumType.STRING)
    private FinitionEnum finitionEnum;

    @ManyToMany
    @JoinTable(name = "JointureFormatFinition",
            joinColumns = @JoinColumn(name = "finitionId"),
            inverseJoinColumns = @JoinColumn(name = "formatId"))
    private List<Format> formats = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JointureFinitionCadre",
            joinColumns = @JoinColumn(name = "finitionId"),
            inverseJoinColumns = @JoinColumn(name = "cadreId"))
    private List<Cadre> cadres = new ArrayList<>();
}