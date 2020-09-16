package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.Finition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinitionRepository extends JpaRepository<Finition, Long> {
}
