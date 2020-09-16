package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.DetailCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailCommandeRepository  extends JpaRepository<DetailCommande, Long> {
}
