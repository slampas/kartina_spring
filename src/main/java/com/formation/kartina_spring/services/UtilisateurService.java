package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Utilisateur;
import com.formation.kartina_spring.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    public void delete(Long ref) {
        utilisateurRepository.deleteById(ref);
    }


    public Optional<Utilisateur> findById(Long ref) {
        return utilisateurRepository.findById(ref);
    }


}
