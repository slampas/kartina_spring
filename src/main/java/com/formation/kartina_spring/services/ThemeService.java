package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Theme;
import com.formation.kartina_spring.repositories.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {
    private ThemeRepository themeRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public void save(Theme theme) {
        themeRepository.save(theme);
    }

    public List<Theme> findAll() {
        return themeRepository.findAll();
    }
}
