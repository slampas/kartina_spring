package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.FormatEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@NaturalIdCache
@Cache(
        usage = CacheConcurrencyStrategy.READ_WRITE
)
public class Format {
    @Id
    @GeneratedValue
    private Long formatId;

    @NaturalId
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormatEnum formatEnum;


    @OneToMany(
            mappedBy = "format",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JointureArticleFormat> articles = new ArrayList<>();

    @OneToMany(
            mappedBy = "format",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JointureFormatFinition> finitions = new ArrayList<>();
}