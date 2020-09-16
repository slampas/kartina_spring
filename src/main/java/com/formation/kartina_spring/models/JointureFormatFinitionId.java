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
public class JointureFormatFinitionId implements Serializable {

    @Column(name = "format_id")
    private Long formatId;

    @Column(name = "finition_id")
    private Long finitionId;
}
