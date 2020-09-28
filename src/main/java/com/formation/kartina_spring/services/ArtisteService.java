package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Artiste;
import com.formation.kartina_spring.repositories.ArticleRepository;
import com.formation.kartina_spring.repositories.ArtisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtisteService {
    private ArtisteRepository artisteRepository;

    @Autowired
    public ArtisteService(ArtisteRepository artisteRepository) {
        this.artisteRepository = artisteRepository;
    }

    public void save(Artiste artiste) {
        artisteRepository.save(artiste);
    }

    public List<Artiste> findAll() {
        return artisteRepository.findAll();
    }


    



}
