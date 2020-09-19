package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.OrientationEnun;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Orientation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orientationId;

    @Column(length = 100, nullable = false)
    private OrientationEnun nom;

    @OneToMany(mappedBy = "orientation")
    private List<Article> articles = new ArrayList<>();
}
