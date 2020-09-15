package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    private Calendar dateAjout;

    @ManyToMany(mappedBy="articles")
    private List<Commande> commandes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JointureArticleFormat",
            joinColumns = { @JoinColumn(name = "fk_Article") },
            inverseJoinColumns = { @JoinColumn(name = "fk_Format") })
    private List<Format> formats = new ArrayList<>();

    @ManyToMany(mappedBy = "articles")
    private List<Artiste> artistes = new ArrayList<>();

    @OneToMany(mappedBy = "article")
    private List<Image> images = new ArrayList<>();

    @ManyToOne
    private Orientation orientation;

    @ManyToMany
    @JoinTable(name = "JointureArticleTheme",
            joinColumns = { @JoinColumn(name = "fk_Article") },
            inverseJoinColumns = { @JoinColumn(name = "fk_Theme") })
    private List<Theme> themes = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JointureArticleTag",
            joinColumns = { @JoinColumn(name = "fk_Article") },
            inverseJoinColumns = { @JoinColumn(name = "fk_Tag") })
    private List<Tag> tags = new ArrayList<>();
}
