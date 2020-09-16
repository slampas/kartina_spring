package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.JointureArticleFormat;
import com.formation.kartina_spring.repositories.JointureArticleFormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JointureArticleFormatService {
    private JointureArticleFormatRepository jointureArticleFormatRepository;

    @Autowired
    public JointureArticleFormatService(JointureArticleFormatRepository jointureArticleFormatRepository) {
        this.jointureArticleFormatRepository = jointureArticleFormatRepository;
    }

    public void save(JointureArticleFormat jointureArticleFormat) {
        jointureArticleFormatRepository.save(jointureArticleFormat);
    }

    public List<JointureArticleFormat> findAll() {
        return jointureArticleFormatRepository.findAll();
    }
}
