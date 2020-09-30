package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.models.ChoixPersonnalisation;
import com.formation.kartina_spring.services.ArticleService;
import com.formation.kartina_spring.utils.RemplissageBDDParcoursPhoto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    //Objet pour sauvegarde temporaire des choix
    private final ChoixPersonnalisation choixPersonnalisation;

    private ArticleService articleService;
    private RemplissageBDDParcoursPhoto remplissageBDDParcoursPhoto;

    @Autowired
    public IndexController(ChoixPersonnalisation choixPersonnalisation, ArticleService articleService, RemplissageBDDParcoursPhoto remplissageBDDParcoursPhoto
    ) {
        this.choixPersonnalisation = choixPersonnalisation;
        this.articleService = articleService;
        this.remplissageBDDParcoursPhoto = remplissageBDDParcoursPhoto;
    }

    //Index, page principale
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("fragment", "index");
        return "index";
    }

    //Page parcours des photographies
    @GetMapping("/explore")
    public String getPhotographies(Model model) {
        model.addAttribute("fragment", "parcours_photo");
        return "index";
    }

    //Page artiste
    @GetMapping("/artist")
    public String getArtiste(Model model) {
        model.addAttribute("fragment", "artiste");
        return "index";
    }

    @GetMapping("/remplissage")
    public String remplissage() {
        remplissageBDDParcoursPhoto.saveDBArticle();
        return "redirect:/";
    }
}
