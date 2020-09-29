package com.formation.kartina_spring.controllers.admin;

import com.formation.kartina_spring.models.Utilisateur;
import com.formation.kartina_spring.services.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/utilisateurs")
public class AdminUtilsateurControlleur {


    private final UtilisateurService utilisateurService ;

    @Autowired
    public AdminUtilsateurControlleur(UtilisateurService utilisateurService) {
        this.utilisateurService  = utilisateurService ;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        model.addAttribute("fragment", "utilisateur/index");
        return "admin/index";
    }

    @GetMapping("add")
    public String getCreateArticle(Model model, Utilisateur facture){
        model.addAttribute("action", "/add");
        model.addAttribute("fragment", "utilisateur/form");
        return "admin/index";
    }
    
}
