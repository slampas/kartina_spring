package com.formation.kartina_spring.models;

import com.formation.kartina_spring.emums.RoleUtilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long type_id;

    @Enumerated(EnumType.STRING)
    private RoleUtilisateur user_emun;
}
