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
    private List<Format> formats = new ArrayList<>();

    @ManyToMany
    private List<Cadre> cadres = new ArrayList<>();
}