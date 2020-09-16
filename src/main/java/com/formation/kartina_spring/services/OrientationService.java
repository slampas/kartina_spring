package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Orientation;
import com.formation.kartina_spring.repositories.OrientationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrientationService {
    private OrientationRepository orientationRepository;

    @Autowired
    public OrientationService(OrientationRepository orientationRepository) {
        this.orientationRepository = orientationRepository;
    }

    public void save(Orientation orientation) {
        orientationRepository.save(orientation);
    }

    public List<Orientation> findAll() {
        return orientationRepository.findAll();
    }
}
