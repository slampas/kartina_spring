package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Adresse;
import com.formation.kartina_spring.repositories.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseService {
    private AdresseRepository adresseRepository;

    @Autowired
    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public void save(Adresse adresse) {
        adresseRepository.save(adresse);
    }

    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }
}
