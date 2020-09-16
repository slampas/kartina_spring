package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.JointureFinitionCadre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointureFinitionCadreRepository extends JpaRepository<JointureFinitionCadre, Long> {
}
