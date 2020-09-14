package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.CadreEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cadre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cadreId;

    @Enumerated(EnumType.STRING)
    private CadreEnum cadreEnum;
}