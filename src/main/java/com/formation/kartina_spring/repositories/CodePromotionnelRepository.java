package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.CodePromotionnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodePromotionnelRepository extends JpaRepository<CodePromotionnel, Long> {
}
