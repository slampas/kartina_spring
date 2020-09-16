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
public class JointureArticleFormatId implements Serializable {
    @Column(name = "article_id")
    private Long articleId;

    @Column(name = "format_id")
    private Long formatId;
}
