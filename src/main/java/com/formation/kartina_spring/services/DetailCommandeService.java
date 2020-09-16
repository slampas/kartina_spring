package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.DetailCommande;
import com.formation.kartina_spring.repositories.DetailCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailCommandeService {
    private DetailCommandeRepository detailCommandeRepository;

    @Autowired
    public DetailCommandeService(DetailCommandeRepository detailCommandeRepository) {
        this.detailCommandeRepository = detailCommandeRepository;
    }

    public void save(DetailCommande detailCommande) {
        detailCommandeRepository.save(detailCommande);
    }

    public List<DetailCommande> findAll() {
        return detailCommandeRepository.findAll();
    }
}
