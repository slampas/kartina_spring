package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ArticleFormat")
public class JointureArticleFormat {

    @EmbeddedId
    private JointureArticleFormatId id = new JointureArticleFormatId();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("articleId")
    //@JoinColumn(name = "article_id")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("formatId")
    //@JoinColumn(name = "format_id")
    private Format format;

//    @Column(nullable = false)
//    private Float coefficientPrix;

    @Column(nullable = false)
    private Integer quantiteDispo;
}
