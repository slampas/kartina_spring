package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.JointureFinitionCadre;
import com.formation.kartina_spring.repositories.JointureFinitionCadreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JointureFinitionCadreService {
    private JointureFinitionCadreRepository jointureFinitionCadreRepository;

    @Autowired
    public JointureFinitionCadreService(JointureFinitionCadreRepository jointureFinitionCadreRepository) {
        this.jointureFinitionCadreRepository = jointureFinitionCadreRepository;
    }

    public void save(JointureFinitionCadre jointureFinitionCadre) {
        jointureFinitionCadreRepository.save(jointureFinitionCadre);
    }

    public List<JointureFinitionCadre> findAll() {
        return jointureFinitionCadreRepository.findAll();
    }
}
