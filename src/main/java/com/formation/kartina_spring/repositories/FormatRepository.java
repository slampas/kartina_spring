package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.Format;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatRepository extends JpaRepository<Format, Long> {
}
