package com.formation.kartina_spring.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleRef;
    
    
    @Column(nullable = false)
    private String name;
 
 
 
    /**doublon  à voir avec marc antoine**/
    @Column(nullable = false)
    private String nom;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Float prixBase;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
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
