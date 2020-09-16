package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Cadre;
import com.formation.kartina_spring.repositories.CadreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadreService {
    private CadreRepository cadreRepository;

    @Autowired
    public CadreService(CadreRepository cadreRepository) {
        this.cadreRepository = cadreRepository;
    }

    public void save(Cadre cadre) {
        cadreRepository.save(cadre);
    }

    public List<Cadre> findAll() {
        return cadreRepository.findAll();
    }
}
