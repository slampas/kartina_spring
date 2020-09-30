package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.ToString;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleRef;

    @Column(nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 10)
    private Float prixBase;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Calendar dateAjout;

    @OneToMany(
            mappedBy = "article",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<DetailCommande> commandes = new ArrayList<>();

    @OneToMany(
            mappedBy = "article",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    private List<JointureArticleFormat> formats = new ArrayList<>();

    @ManyToMany(mappedBy = "articles")
    @ToString.Exclude
    private List<Artiste> artistes = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<Image> images = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private List<Orientation> orientation = new ArrayList<>();

    @ManyToMany(mappedBy = "articles")
    @ToString.Exclude
    private List<Theme> themes = new ArrayList<>();

    @ManyToMany(mappedBy = "articles")
    @ToString.Exclude
    private List<Tag> tags = new ArrayList<>();
}
