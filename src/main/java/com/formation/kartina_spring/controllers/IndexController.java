package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.models.ChoixPersonnalisation;
import com.formation.kartina_spring.services.ArticleService;
import com.formation.kartina_spring.services.FormatService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    //Objet pour sauvegarde temporaire des choix
    private final ChoixPersonnalisation choixPersonnalisation;

    private ArticleService articleService;

    @Autowired
    public IndexController(ChoixPersonnalisation choixPersonnalisation, ArticleService articleService) {
        this.choixPersonnalisation = choixPersonnalisation;
        this.articleService = articleService;
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


    //Page parcours achat
    @GetMapping("/oeuvre/{ref}")
    public String getOeuvre(
            Model model,
            @PathVariable Long ref
    ) {
        // TODO : Recherche de la photo par rapport à la ref de l'url


        // TODO : Recuperation du link


        // TODO : Recupération du nom de l'artiste, titre  oeuvre / description associés
        model.addAttribute("fragmentForm", "fragments :: format");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    //Recupération du format
    @PostMapping("/oeuvre/{ref}/finition")
    public String postOeuvreFinition(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "format") String format
    ) {

        System.out.println("Format : " + format);
        choixPersonnalisation.setFormat(format);
        System.out.println("Obj : " + choixPersonnalisation);
        model.addAttribute("format", format);
        model.addAttribute("fragmentForm", "fragments :: finition");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    //Recupération du finition
    @PostMapping("/oeuvre/{ref}/cadre")
    public String postOeuvreCadre(
            Model model,
            @PathVariable Long ref,
            @RequestParam(name = "finition") String finition

    ) {
        System.out.println("Finition : " + finition);
        choixPersonnalisation.setFinition(finition);
        System.out.println("Obj : " + choixPersonnalisation);
        model.addAttribute("finition", finition);
        model.addAttribute("fragmentForm", "fragments :: cadre");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    //Recupération du cadre
    @PostMapping("/oeuvre/{ref}")
    public String postOeuvre(
            @RequestParam(name = "cadre") String cadre
    ) {
        System.out.println("Cadre : " + cadre);
        choixPersonnalisation.setCadre(cadre);
        System.out.println("Obj : " + choixPersonnalisation);

        // TODO : Gestion du panier
        return "redirect:/";
    }
}
