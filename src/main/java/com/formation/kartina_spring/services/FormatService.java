package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Format;
import com.formation.kartina_spring.repositories.FormatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatService {
    private FormatRepository formatRepository;

    @Autowired
    public FormatService(FormatRepository formatRepository) {
        this.formatRepository = formatRepository;
    }

    public void save(Format format) {
        formatRepository.save(format);
    }

    public List<Format> findAll() {
        return formatRepository.findAll();
    }
}
