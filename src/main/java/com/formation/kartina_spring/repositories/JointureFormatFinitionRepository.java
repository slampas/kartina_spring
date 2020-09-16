package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.JointureFormatFinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointureFormatFinitionRepository extends JpaRepository<JointureFormatFinition, Long> {
}
