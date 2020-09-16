package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.Cadre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadreRepository  extends JpaRepository<Cadre, Long> {
}
