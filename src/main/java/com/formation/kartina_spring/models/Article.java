package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleRef;

    @NaturalId
    private String name;

    @NaturalId
    @Column(nullable = false)
    private String nom;

    @NaturalId
    @Column(columnDefinition = "TEXT")
    private String description;

    @NaturalId
    @Column(nullable = false, length = 10)
    private Float prixBase;

    @NaturalId
    @Temporal(TemporalType.DATE)
    private Calendar dateAjout;

    @OneToMany(
            mappedBy = "article",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetailCommande> commandes = new ArrayList<>();

    @OneToMany(
            mappedBy = "article",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JointureArticleFormat> formats = new ArrayList<>();

    @ManyToMany(mappedBy = "articles")
    private List<Artiste> artistes = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    private List<Image> images = new ArrayList<>();

    @ManyToOne
    private Orientation orientation;

    @ManyToMany
    @JoinTable(name = "JointureArticleTheme",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "theme_id")})
    private List<Theme> themes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JointureArticleTag",
            joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private List<Tag> tags = new ArrayList<>();
}
