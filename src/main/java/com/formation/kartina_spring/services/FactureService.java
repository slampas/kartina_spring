package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Facture;
import com.formation.kartina_spring.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {
    private FactureRepository factureRepository;

    @Autowired
    public FactureService(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    public void save(Facture facture) {
        factureRepository.save(facture);
    }

    public List<Facture> findAll() {
        return factureRepository.findAll();
    }
}
