package com.formation.kartina_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {
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
    @GetMapping("/oeuvre")
    public String getOeuvre(Model model) {
        //Rechercher BDD des format possible avec l'article selectionné, ref dans l'url ?
        //...
        model.addAttribute("fragmentForm", "fragments :: format");
        model.addAttribute("fragment", "parcours_achat");
        return "index";
    }

    @PostMapping("/oeuvre")
    public String postOeuvre(
            Model model,
            @RequestParam(name = "format") String format
    ) {
        //Sauvegarde du choix de format pour les autres controllers
        //...
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
