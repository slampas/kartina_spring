package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.Orientation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrientationRepository extends JpaRepository<Orientation, Long> {
}
