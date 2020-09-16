package com.formation.kartina_spring.repositories;

import com.formation.kartina_spring.models.JointureArticleFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JointureArticleFormatRepository extends JpaRepository<JointureArticleFormat, Long> {
}
