package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DetailCommandeId implements Serializable {

    @Column(name = "commande_id")
    private Long commandeId;

    @Column(name = "article_id")
    private Long articleId;
}