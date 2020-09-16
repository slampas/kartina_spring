package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
}
