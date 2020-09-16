package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.Artiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtisteRepository  extends JpaRepository<Artiste, Long> {
}
