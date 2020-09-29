package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Facture;
import com.formation.kartina_spring.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void delete(Long ref) {
        factureRepository.deleteById(ref);
    }


    public Optional<Facture> findById(Long ref) {
        return factureRepository.findById(ref);
    }

}
