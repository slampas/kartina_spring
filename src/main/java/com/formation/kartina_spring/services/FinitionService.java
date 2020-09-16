package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Finition;
import com.formation.kartina_spring.repositories.FinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinitionService {
    private FinitionRepository finitionRepository;

    @Autowired
    public FinitionService(FinitionRepository finitionRepository) {
        this.finitionRepository = finitionRepository;
    }

    public void save(Finition finition) {
        finitionRepository.save(finition);
    }

    public List<Finition> findAll() {
        return finitionRepository.findAll();
    }
}
