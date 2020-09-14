package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.FinitionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Finition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Float finitionId;

    @Enumerated(EnumType.STRING)
    private FinitionEnum finitionEnum;
}