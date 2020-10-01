package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.FormatEnum;
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
public class Format {
    @Id
    @GeneratedValue
    private Long formatId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormatEnum formatEnum;

    private Float coefficientPrix;

    @ManyToMany
    private List<Finition> finitions = new ArrayList<>();

    @OneToMany(
            mappedBy = "format",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JointureArticleFormat> articles = new ArrayList<>();
}