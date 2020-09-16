package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.JointureFormatFinition;
import com.formation.kartina_spring.repositories.JointureFormatFinitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JointureFormatFinitionService {
    private JointureFormatFinitionRepository jointureFormatFinitionRepository;

    @Autowired
    public JointureFormatFinitionService(JointureFormatFinitionRepository jointureFormatFinitionRepository) {
        this.jointureFormatFinitionRepository = jointureFormatFinitionRepository;
    }

    public void save(JointureFormatFinition jointureFormatFinition) {
        jointureFormatFinitionRepository.save(jointureFormatFinition);
    }

    public List<JointureFormatFinition> findAll() {
        return jointureFormatFinitionRepository.findAll();
    }
}
