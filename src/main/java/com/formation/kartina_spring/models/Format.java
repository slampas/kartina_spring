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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formatId;

    @Enumerated(EnumType.STRING)
    private FormatEnum formatEnum;


    @ManyToMany(mappedBy="formats")
    private List<Article> articles = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "JointureFormatFinition",
            joinColumns = { @JoinColumn(name = "fk_Format") },
            inverseJoinColumns = { @JoinColumn(name = "fk_Finition") })
    private List<Finition> finitions = new ArrayList<>();
}