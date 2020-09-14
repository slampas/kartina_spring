package com.formation.kartina_spring.models;

import com.formation.kartina_spring.enums.FormatEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
}