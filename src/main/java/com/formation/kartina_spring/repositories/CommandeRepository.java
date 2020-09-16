package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository  extends JpaRepository<Commande, Long> {
}
