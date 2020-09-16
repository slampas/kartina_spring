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
public class JointureFinitionCadreId implements Serializable {
    @Column(name = "finition_id")
    private Long finitionId;

    @Column(name = "cadre_id")
    private Long cadreId;

}
