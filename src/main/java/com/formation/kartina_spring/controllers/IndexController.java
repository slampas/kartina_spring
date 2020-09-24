package com.formation.kartina_spring.controllers;

import com.formation.kartina_spring.models.ChoixPersonnalisation;
import com.formation.kartina_spring.services.FormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    private FormatService formatService;

    //Objet pour sauvegarde temporaire des choix
    private ChoixPersonnalisation choixPersonnalisation = new ChoixPersonnalisation();

    @Autowired
    public IndexController(FormatService formatService, ChoixPersonnalisation choixPersonnalisation) {
        this.formatService = formatService;
        this.choixPersonnalisation = choixPersonnalisation;
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
    public String getOeuvre(Model model, @PathVariable Long ref) {
        //Rechercher BDD des format possible avec la ref de l'article, ref dans l'url ?
        //...

        model.addAttribute("fragmentForm", "fragments :: format");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    //route post pour le format
    @PostMapping("/oeuvre/{ref}")
    public String postOeuvre(
            Model model,
            @RequestParam(name = "format") String format,
            @PathVariable Long ref
    ) {
        if (!format.isEmpty()) {
            //Voir pour un objet hors des fonctions pour le garder en vie sur les 3 controllers
            choixPersonnalisation.setFormat(format);
            model.addAttribute("fragmentForm", "fragments :: finition");
            return "redirect:/oeuvre";
        }
        //model.addAttribute("ref", "/" + ref);
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    @GetMapping("/oeuvre/finition")
    public String getOeuvreFinition(
            Model model
    ) {
        //Rechercher BDD des finitions possible selon le format selectionné
        //...

        model.addAttribute("fragmentForm", "finition");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
        // "forward:index"
    }

    @PostMapping("/oeuvre/finition")
    public String postOeuvreFinition(
            Model model,
            @RequestParam(name = "finition") String finition
    ) {
        //Sauvegarde du choix de la finition pour les autres controllers
        //...
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }
}
