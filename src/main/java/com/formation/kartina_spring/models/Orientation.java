package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.OrientationEnun;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Orientation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orientation_id;

    @Column(length = 100, nullable = false)
    private OrientationEnun nom;

    @OneToMany(mappedBy = "orientation")
    private List<Article> articles = new ArrayList<>();
}
