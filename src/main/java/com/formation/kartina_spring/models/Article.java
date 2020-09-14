package com.formation.kartina_spring.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Article {
    @Id
    private String ref;
}
