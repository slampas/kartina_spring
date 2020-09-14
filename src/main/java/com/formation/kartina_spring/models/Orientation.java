package com.formation.kartina_spring.models;

import com.formation.kartina_spring.emums.OrientationEnun;

import javax.persistence.*;

@Entity
public class Orientation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orientation_id;

    @Column(length = 100, nullable = false)
    private OrientationEnun nom;
}
