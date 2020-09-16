package com.formation.kartina_spring.services;

import com.formation.kartina_spring.models.Commande;
import com.formation.kartina_spring.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    private CommandeRepository commandeRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    public void save(Commande commande) {
        commandeRepository.save(commande);
    }

    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }
}
