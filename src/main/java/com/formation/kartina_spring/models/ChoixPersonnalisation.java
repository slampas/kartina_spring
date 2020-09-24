package com.formation.kartina_spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor

//Pour l'autowire ?
@Component
public class ChoixPersonnalisation {
    private String format;
    private String finition;
    private String cadre;
}
